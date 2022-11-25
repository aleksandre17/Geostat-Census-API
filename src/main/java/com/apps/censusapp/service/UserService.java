package com.apps.censusapp.service;

import com.apps.censusapp.entity.Addressing;
import com.apps.censusapp.entity.UserEntity;
import com.apps.censusapp.shared.dti.UserDt.UserDti;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    UserDti createUser(UserDti user);
    List<UserEntity> createUsers(List<UserDti> userDtis) throws JsonProcessingException;
    UserDti getUser(String email) throws JsonProcessingException;
    UserDti getUserByUserId(String userId);
}
