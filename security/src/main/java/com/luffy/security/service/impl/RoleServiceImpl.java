package com.luffy.security.service.impl;

import com.luffy.security.service.RoleService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

/**
 * @author luffy
 * @version 1.0
 * @desc
 * @date 2021/4/14 16:44
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Override
    public Boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        String requestURI = request.getRequestURI();
        Object principal = authentication.getPrincipal();
        if (principal instanceof UserDetails){
            UserDetails userDetails = (UserDetails) principal;
            Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
             return authorities.contains(new SimpleGrantedAuthority(requestURI));
        }
        return false;
    }
}
