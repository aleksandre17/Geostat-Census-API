package com.apps.censusapp.service.impl;

import com.apps.censusapp.repository.UserRepository;
import com.apps.censusapp.entity.UserEntity;
import com.apps.censusapp.service.UserService;
import com.apps.censusapp.shared.dti.UserDt.UserDti;
import com.apps.censusapp.shared.dti.UserDt.Utils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    Utils utils;

    @Autowired
    BCryptPasswordEncoder encoder;

    @Override
    public UserDti createUser(UserDti user) {

        if (userRepository.findByUserName(user.getUserName()) != null) throw new RuntimeException("Record already exist");

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        userEntity.setPassword(encoder.encode(user.getPassword()));

        UserEntity storeUserDetails = userRepository.save(userEntity);

        UserDti returned = new UserDti();
        BeanUtils.copyProperties(storeUserDetails, returned);

        return returned;
    }

    public List<UserEntity> createUsers(List<UserDti> userDtis) throws JsonProcessingException {

        List<UserEntity> upload = userDtis.stream().map(new Function<UserDti, UserEntity>() {
            @Override
            public UserEntity apply(UserDti userDti) {

                UserEntity newEntity = new UserEntity();
                newEntity.setUserName(userDti.getUserName());

                UserEntity userEntity = userRepository.findByUserName(userDti.getUserName());
                if (userEntity != null) {
                    newEntity.setId(userEntity.getId());
                }

                newEntity.setPassword(encoder.encode(userDti.getPassword()));

                return newEntity;
            }
        }).collect(Collectors.toList());

        System.out.println("USRS :" + new ObjectMapper().writeValueAsString(upload));

        return (List<UserEntity>) userRepository.saveAll(upload);
    }

    @Override
    public UserDti getUser(String userName) throws JsonProcessingException {
        UserEntity userEntity = userRepository.findByUserName(userName);

        if (userEntity == null) throw new UsernameNotFoundException(userName);

        // UserDti returnValue = new UserDti();
        // BeanUtils.copyProperties(userEntity, returnValue);

        return new ObjectMapper().readValue(new ObjectMapper().writeValueAsString(userEntity), UserDti.class);
    }

    @Override
    public UserDti getUserByUserId(String userId) {
        UserDti returnValue  = new UserDti();
        UserEntity userEntity = userRepository.findByUserId(userId);

        if (userEntity == null) throw new UsernameNotFoundException(userId);
        BeanUtils.copyProperties(userEntity, returnValue);

        return returnValue;
    }


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUserName(userName);
        if (userEntity == null) throw new UsernameNotFoundException(userName);

        return new User(userEntity.getUserName(), userEntity.getPassword(), new ArrayList<>());
    }
}
