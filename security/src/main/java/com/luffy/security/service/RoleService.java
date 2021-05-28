package com.luffy.security.service;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * @author luffy
 * @version 1.0
 * @desc
 * @date 2021/4/14 16:43
 */
public interface RoleService {
    Boolean hasPermission(HttpServletRequest request, Authentication authentication);
}
