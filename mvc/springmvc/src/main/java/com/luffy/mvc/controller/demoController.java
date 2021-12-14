package com.luffy.mvc.controller;

import com.luffy.mvc.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Date;

/**
 * @author luffy
 * @version 1.0
 * @desc
 * @date 2021/12/7 13:41
 */
@Controller
@RequestMapping("/demo")
public class demoController {



    @RequestMapping("/handle1")
    public ModelAndView handle1(@ModelAttribute("name") String name){
        int i = 1/0;
        Date date =  new Date();
        ModelAndView modelAndView = new ModelAndView();
        //数据
        modelAndView.addObject("date",date);
        //视图信息
        modelAndView.setViewName("success");

        return modelAndView;
    }

    @RequestMapping("/handle2")
    public String handle2(ModelMap modelMap){
        Date date =  new Date();
        modelMap.addAttribute("date",date);

        return "success";
    }

    @RequestMapping("/handle3")
    public String handle3(@RequestBody User user){
        Date date =  new Date();

        return "success";
    }

    @RequestMapping("/upload")
    public ModelAndView upload(MultipartFile upload) throws IOException {


        upload.transferTo(new File("D:\\workspace\\luffystudy\\mvc\\src\\main\\webapp\\test.png"));

        Date date =  new Date();
        ModelAndView modelAndView = new ModelAndView();
        //数据
        modelAndView.addObject("date",date);
        //视图信息
        modelAndView.setViewName("success");

        return modelAndView;
    }

    //重定向 参数传递问题
    @RequestMapping("/directHandle")
    public String directHandle(String name, RedirectAttributes redirectAttributes)
    {
        //重定向参数  get请求 参数长度受限
        redirectAttributes.addFlashAttribute("name",name);
        return "redirect:handle1";
    }




}
