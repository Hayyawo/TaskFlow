//package com.example.taskflow.config;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.auth0.jwt.exceptions.JWTVerificationException;
//import com.auth0.jwt.interfaces.DecodedJWT;
//import com.auth0.jwt.interfaces.JWTVerifier;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//
//@Component
//public class JwtUtil {
//    private final String SECRET_KEY = "mySecretKey"; // here should be something coming from for example parameter store
//    private final long EXPIRATION_TIME = 1000 * 60 * 60 * 10; // 10 hours
//
//    private final Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
//
//    public String generateToken(String username) {
//        return JWT.create()
//                .withSubject(username)
//                .withIssuedAt(new Date())
//                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
//                .sign(algorithm);
//    }
//
//    public boolean validateToken(String token) {
//        try {
//            JWTVerifier verifier = JWT.require(algorithm).build();
//            verifier.verify(token);
//            return true;
//        } catch (JWTVerificationException e) {
//            return false;
//        }
//    }
//
//    public String extractUsername(String token) {
//        DecodedJWT decodedJWT = JWT.require(algorithm).build().verify(token);
//        return decodedJWT.getSubject();
//    }
//}
