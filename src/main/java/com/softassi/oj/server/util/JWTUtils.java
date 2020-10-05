package com.softassi.oj.server.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

/**
 * @ClassName : JWTUtils
 * @Description :
 * @Author : cybersa
 * @Date: 2020-09-02 20:58
 */
public class JWTUtils {
    private static final String TOKEN = "sd00wu%$T4";
    public static final long EXPIRITION = 1000 * 24 * 60 * 60 * 7;


    public static String getToken(Map<String, String> payload) {
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE, 7);
        JWTCreator.Builder builder = JWT.create();
        payload.forEach((k ,v) -> {
            builder.withClaim(k, v);
        });
        builder.withExpiresAt(instance.getTime());
        String token = builder.sign(Algorithm.HMAC256(TOKEN));
        return token;
    }

    public static void verify(String token) {
        JWT.require(Algorithm.HMAC256(TOKEN)).build().verify(token);
    }
    
    public static DecodedJWT getTokenInfo(String token) {
        return JWT.require(Algorithm.HMAC256(TOKEN)).build().verify(token);
    }

}
