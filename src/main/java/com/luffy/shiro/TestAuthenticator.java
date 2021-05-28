package com.luffy.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;

/**
 * @author luffy
 * @version 1.0
 * @date 2021/1/12 16:01
 */
public class TestAuthenticator {
    public static void main(String[] args) {
        //创建安全管理器
        DefaultSecurityManager securityManager =new DefaultSecurityManager();
        //给管理器设置realms
        CustomerRealm customerRealm = new CustomerRealm();
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        hashedCredentialsMatcher.setHashIterations(1024);
        customerRealm.setCredentialsMatcher(hashedCredentialsMatcher);
        securityManager.setRealm( customerRealm);


        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken luffy = new UsernamePasswordToken("luffy", "123");
        try {
                subject.login(luffy);
            System.out.println(subject.isAuthenticated());
        }catch (IncorrectCredentialsException e){
            e.printStackTrace();
            System.out.println("密码错误  ");
        } catch (UnknownAccountException e){
            e.printStackTrace();
            System.out.println("用户名错误  ");
        }
        //认证用户进行授权
        if (subject.isAuthenticated()){
            System.out.println(subject.hasRole("admin"));
        }




    }


}
