package com.luffy.mvcdiy.controller;

/**
 * @author luffy
 * @version 1.0
 * @desc demoController
 * @date 2021/12/10 14:40
 */

import com.luffy.mvcdiy.annotation.LuffyAutowired;
import com.luffy.mvcdiy.annotation.LuffyController;
import com.luffy.mvcdiy.annotation.LuffyRequestMapping;
import com.luffy.mvcdiy.service.IDemoService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@LuffyController
@LuffyRequestMapping("/demo")
public class demoController {

    @LuffyAutowired
    private IDemoService demoService;

    @LuffyRequestMapping("/query")
    public String query(HttpServletRequest rep, HttpServletResponse resp,String name){
        return demoService.getName(name);
    }
}
