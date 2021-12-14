package com.luffy.mvc.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;

/**
 * @author luffy
 * @version 1.0
 * @desc
 * @date 2021/12/10 10:17
 */
@ControllerAdvice
public class GlobalExceptionResolver {

    @ExceptionHandler(Exception.class)
    public void handleExceotion(Exception exception, HttpServletResponse response){
        try{
            response.getWriter().write(exception.getMessage());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
