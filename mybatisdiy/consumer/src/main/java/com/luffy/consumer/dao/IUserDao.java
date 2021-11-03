package com.luffy.consumer.dao;

import com.luffy.consumer.model.User;
import org.dom4j.DocumentException;

import java.beans.IntrospectionException;
import java.beans.PropertyVetoException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author luffy
 * @version 1.0
 * @desc
 * @date 2021/10/14 13:51
 */
public interface IUserDao {

    List<User>  findAll(User user) throws IllegalAccessException, IntrospectionException, InstantiationException, NoSuchFieldException, SQLException, InvocationTargetException, ClassNotFoundException, PropertyVetoException, DocumentException;
}
