package com.luffy.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author luffy
 * @version 1.0
 * @desc
 * @date 2021/4/14 10:01
 */
@Service
public class UserServiceImpl implements UserDetailsService {
    @Autowired
    private PasswordEncoder pw;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        if (!"admin".equals(s)){
            throw new RuntimeException("账号密码错误");
        }
        String password = pw.encode("123456");
        return new User("admin",password, AuthorityUtils.commaSeparatedStringToAuthorityList("admin,/main.html,ROLE_abc"));
    }
}
