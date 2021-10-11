package com.wez.session.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @Author wez
 * @Date 2021/10/11
 */
@RestController
public class UserController {

    @GetMapping("login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpSession session) {
        session.setAttribute("login_name", username);
        return "登录成功：" + username;
    }

    @GetMapping("info")
    public String info(HttpSession session) {
        return "登录用户：" + session.getAttribute("login_name");
    }

}
