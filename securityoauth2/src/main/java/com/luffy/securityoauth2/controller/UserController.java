package com.luffy.securityoauth2.controller;

import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author luffy
 * @version 1.0
 * @desc
 * @date 2021/4/15 15:45
 */
@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping("/getCurrentUser")
    public Object getCurrentUser(Authorization authorization){
        return authorization;
    }
}
