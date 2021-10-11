package com.wez.jwt.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Author wez
 * @Date 2021/10/11
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password) {
        Algorithm algorithm = Algorithm.HMAC256("wez"); // 加密密钥
        String token = JWT.create()
                .withClaim("login_name", username)
                .withExpiresAt(new Date(System.currentTimeMillis()+3600*1000)) // 设置过期时间：10s
                .sign(algorithm);
        return token;
    }

    @GetMapping("info")
    public String info(@RequestHeader String token) {
        Algorithm algorithm = Algorithm.HMAC256("wez"); // 加密密钥
        JWTVerifier verifier = JWT.require(algorithm)
                .build();

        // 通过捕获过期异常来处理token过期的问题
        String result = null;
        try {
            DecodedJWT jwt = verifier.verify(token);
            result = "登录用户：" + jwt.getClaim("login_name").asString();
        } catch (TokenExpiredException tokenExpiredException) {
            result = "token过期";
        } catch (JWTDecodeException jwtDecodeException) {
            result = "token解码失败";
        }
        return result;
    }

}
