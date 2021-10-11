package com.wez.token.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Author wez
 * @Date 2021/10/11
 */
@RestController
public class UserController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password) {
        String key = "token_" + UUID.randomUUID().toString().replace("-", "_");
        stringRedisTemplate.opsForValue().set(key, username);
        return key;
    }

    @GetMapping("/info")
    public String login(@RequestHeader String token) {
        return "登录用户：" + stringRedisTemplate.opsForValue().get(token);
    }

}
