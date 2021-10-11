package com.wez.session;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableRedisHttpSession
@SpringBootApplication
public class SessionApplicationMain {
    public static void main(String[] args) {
        SpringApplication.run(SessionApplicationMain.class, args);
    }
}
