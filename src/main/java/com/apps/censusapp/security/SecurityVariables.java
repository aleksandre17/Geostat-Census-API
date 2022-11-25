package com.apps.censusapp.security;

import com.apps.censusapp.SpringApplicationContext;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.security.SecureRandom;
import java.util.Base64;

public class SecurityVariables {
    public static final long EXPIRATION_TIME = 864000000;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/users";
//    public static final String TOKEN_SECRET = "nkGA6Dr/JTVkUrd2uWdPl9ZBs7+cspIRzYFnhYUeGiQwj3gm95xeQR5ZailrfcABuW26OplYqEumIfI/RAtihQ==";

    private static String generateSafeToken() {
        SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
        System.out.println("Key " + Encoders.BASE64.encode(key.getEncoded()));
        return Encoders.BASE64.encode(key.getEncoded());
    }

    public static String getTokenSecret() {
        AppProperties appProperties = (AppProperties) SpringApplicationContext.getBean("AppProperties");
        return appProperties.getTokenSecret();
    }
}
