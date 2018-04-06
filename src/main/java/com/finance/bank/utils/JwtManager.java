package com.finance.bank.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.io.UnsupportedEncodingException;
import java.util.Date;

public class JwtManager {

    public static String generateJwt(String subject, Date date, String name, String scope) throws UnsupportedEncodingException {
        return Jwts.builder()
                .setSubject(subject)
                .setExpiration(date)
                .claim("name", name)
                .claim("scope", scope)
                .signWith(
                        SignatureAlgorithm.HS256,
                        "myPersonalSecretKey12345".getBytes("UTF-8")
                )
                .compact();
    }
}
