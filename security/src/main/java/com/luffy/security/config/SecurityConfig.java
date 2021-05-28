package com.luffy.security.config;

import com.luffy.security.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.jnlp.PersistenceService;

/**
 * @author luffy
 * @version 1.0
 * @desc
 * @date 2021/4/14 9:57
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

   @Autowired
   MyAccessDeiniedHandler myAccessDeiniedHandler;
   @Autowired
    UserServiceImpl userService;
//    @Autowired
//    private PersistentTokenRepository tokenRepository;
    @Autowired
    private PersistentTokenRepository inMemoryTokenRepository;



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/login.html")
                        .loginProcessingUrl("/login")
                        .successForwardUrl("/toMain")
//                        .successHandler(new MyForwardAuthenticationSuccessHandler("http://www.baidu.com"))
                        .failureForwardUrl("/toError");
        //所有请求必须通过登录认证
        http.authorizeRequests()
                .antMatchers("/login.html").permitAll()
                .antMatchers("/error.html").permitAll()
//                .regexMatchers(".[.].html").permitAll()
//                .antMatchers("/noRole.html").hasAuthority("admin")
////                .antMatchers("/noRole.html").hasAnyAuthority("admin")
////                .antMatchers("/noRole.html").hasIpAddress("127.0.0.1")
                .antMatchers("/main1.html").access("@roleServiceImpl.hasPermission(request,authentication)")
                .anyRequest().authenticated();
        //异常处理
        http.exceptionHandling().accessDeniedHandler(myAccessDeiniedHandler);
        //记住我
        http.rememberMe()
                //自定义登录逻辑
                .userDetailsService(userService)
                //自定义失效  默认两周
//                .tokenValiditySeconds()
                //自定义参数
//                .rememberMeParameter()
                //自定义功能实现
//                .rememberMeServices()
                .tokenRepository(inMemoryTokenRepository);

        http.logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login.html");


        //关闭crsf防护
//        http.csrf().disable();
    }

    @Bean
    public PasswordEncoder pw(){
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public PersistentTokenRepository tokenRepository(){
//        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
////        jdbcTokenRepository.setCreateTableOnStartup(true);
//        return jdbcTokenRepository;
//    }
//内存存储
    @Bean
    public PersistentTokenRepository inMemoryTokenRepository(){
        InMemoryTokenRepositoryImpl inMemoryTokenRepository = new InMemoryTokenRepositoryImpl();

        return inMemoryTokenRepository;
    }
}
