package com.luffy.shiro;

import com.sun.corba.se.impl.encoding.CodeSetConversion;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.net.Authenticator;

/**
 * @author luffy
 * @version 1.0
 * @date 2021/1/12 16:45
 */
public class CustomerRealm extends AuthorizingRealm {
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String primaryPrincipal = (String)principalCollection.getPrimaryPrincipal();
        System.out.println("身份信息"+primaryPrincipal);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //将数据库查询出来的角色信息 授权
        simpleAuthorizationInfo.addRole("admin");
        simpleAuthorizationInfo.addRole("user");
        return simpleAuthorizationInfo;
    }
//认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        String principal = (String)authenticationToken.getPrincipal();
        Md5Hash md5Hash = new Md5Hash("123","X0*7ps",1024);

        if (principal.equals("luffy")){
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo("luffy",md5Hash.getBytes(),
                    ByteSource.Util.bytes("X0*7ps"),this.getName());
            return simpleAuthenticationInfo;
        }
        return null;
    }
}
