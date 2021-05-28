package com.luffy.security.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luffy
 * @version 1.0
 * @desc
 * @date 2021/4/14 10:34
 */
@Controller
public class LoginController {

//    @RequestMapping("/login")
//    public String login(){
//        return "redirect:main.html";
//    }


    @RequestMapping("/toMain")
//    @Secured("ROLE_abc")
    @PreAuthorize("hasRole('abc')")
    public String toMain(){
        return "redirect:main.html";
    }
    @RequestMapping("/toError")
    public String toError(){
        return "redirect:error.html";
    }
}
