package com.luffy.security.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author luffy
 * @version 1.0
 * @desc
 * @date 2021/4/14 14:52
 */
public class MyForwardAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    private final String url;

    public MyForwardAuthenticationSuccessHandler(String url) {
        this.url = url;
    }


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.sendRedirect(url);
    }




}
