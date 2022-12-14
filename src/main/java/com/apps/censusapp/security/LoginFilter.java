package com.apps.censusapp.security;

import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class LoginFilter extends BasicAuthenticationFilter {

    public LoginFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        String h = request.getHeader(SecurityVariables.HEADER_STRING);
        if (h == null || !h.startsWith(SecurityVariables.TOKEN_PREFIX)) {
            chain.doFilter(request, response);
            return;
        }

        UsernamePasswordAuthenticationToken authenticationToken = getAuth(request);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        chain.doFilter(request, response);

    }


    private UsernamePasswordAuthenticationToken getAuth (HttpServletRequest request) {
        String token = request.getHeader(SecurityVariables.HEADER_STRING);
        if (token != null) {
            token = token.replace(SecurityVariables.TOKEN_PREFIX, "");

            String user = Jwts.parser().setSigningKey(SecurityVariables.getTokenSecret()).parseClaimsJws(token).getBody().getSubject();

            if (user != null) {
                return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
            }
        }

        return null;
    }
}
