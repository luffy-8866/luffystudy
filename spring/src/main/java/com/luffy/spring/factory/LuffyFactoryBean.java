package com.luffy.spring.factory;

import com.luffy.spring.model.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author luffy
 * @version 1.0
 * @desc
 * @date 2021/11/29 13:46
 */
public class LuffyFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        User user = new User();
        user.setId("111");
        user.setName("luffy");
        return user;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }


}
