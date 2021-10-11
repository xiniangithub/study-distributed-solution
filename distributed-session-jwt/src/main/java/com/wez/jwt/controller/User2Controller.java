package com.wez.jwt.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Author wez
 * @Date 2021/10/11
 */
@RestController
@RequestMapping("/user2")
public class User2Controller {

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
    public String info(@RequestAttribute("username") String username) {
        return "登录用户：" + username;
    }

}
