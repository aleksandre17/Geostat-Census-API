package com.apps.censusapp.security;

import com.apps.censusapp.SpringApplicationContext;
import com.apps.censusapp.service.UserService;
import com.apps.censusapp.shared.dti.UserDt.UserDti;
import com.apps.censusapp.ui.model.request.UserLogIn;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class AuthFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager manager;

    public AuthFilter(AuthenticationManager manager) {
        this.manager = manager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            UserLogIn userLogIn = new ObjectMapper().readValue(request.getInputStream(), UserLogIn.class);
            return manager.authenticate(new UsernamePasswordAuthenticationToken(userLogIn.getUserName(), userLogIn.getPassword(), new ArrayList<>()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        String userName = ((User) authResult.getPrincipal()).getUsername();
        String token = Jwts.builder()
                .setSubject(userName)
                .setExpiration(new Date(System.currentTimeMillis() + SecurityVariables.EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SecurityVariables.getTokenSecret())
                .compact();

        UserService userService = (UserService) SpringApplicationContext.getBean("userServiceImpl");
        UserDti userDti = userService.getUser(userName);

        response.addHeader(SecurityVariables.HEADER_STRING, SecurityVariables.TOKEN_PREFIX + token);
        response.addHeader("user", new ObjectMapper().writeValueAsString(userDti));
        response.addHeader("token", token);

    }
}
