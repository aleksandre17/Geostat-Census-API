package com.apps.censusapp.ui.controller;

import com.apps.censusapp.service.UserService;
import com.apps.censusapp.shared.dti.UserDt.UserDti;
import com.apps.censusapp.ui.model.request.UserRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserService userService;

//    @GetMapping(path = {"test"})
//    public String test(@RequestBody(required = false) Map<String, Object> params) {
//
//        if (params != null) {
//            System.out.println("S " + params.toString());
//        }
//        return "get user was called";
//    }

    @GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public UserRequest getUser(@PathVariable String id) {

        UserRequest returnValue = new UserRequest();
        UserDti userDti = userService.getUserByUserId(id);
        BeanUtils.copyProperties(userDti, returnValue);

        return returnValue;
    }

    @PostMapping
    public UserRequest createUser (@RequestBody UserRequest userRequest) throws JsonProcessingException {
        UserRequest returnedUser = new UserRequest();

        UserDti userDti = new UserDti();
        BeanUtils.copyProperties(userRequest, userDti);

        String json = new ObjectMapper().writeValueAsString(userDti);

        System.out.println(json);

        UserDti createUser = userService.createUser(userDti);
        BeanUtils.copyProperties(createUser, returnedUser);

        return returnedUser;
    }

    @PostMapping("create-users")
    public void createUsers(@RequestBody List<UserDti> userDtis) throws JsonProcessingException {
        System.out.println(new ObjectMapper().writeValueAsString(userDtis));
        userService.createUsers(userDtis);
    }

    public String updateUser () {
        return "update user was called";
    }
}
