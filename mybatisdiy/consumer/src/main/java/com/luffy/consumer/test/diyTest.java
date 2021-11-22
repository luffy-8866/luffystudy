package com.luffy.consumer.test;

import com.luffy.consumer.dao.IUserDao;
import com.luffy.consumer.model.User;
import com.luffy.privider.io.Resources;
import com.luffy.privider.sqlSession.SqlSession;
import com.luffy.privider.sqlSession.SqlSessionFactory;
import com.luffy.privider.sqlSession.SqlSessionFactoryBuilder;
import org.dom4j.DocumentException;
import org.junit.Test;

import java.beans.IntrospectionException;
import java.beans.PropertyVetoException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author luffy
 * @version 1.0
 * @desc
 * @date 2021/9/27 15:35
 */
public class diyTest {

    @Test
    public void test() throws PropertyVetoException, DocumentException, ClassNotFoundException, SQLException, NoSuchFieldException, IllegalAccessException, InstantiationException, IntrospectionException, InvocationTargetException {
        InputStream resouceAsStream = Resources.getResouceAsStream("sqlMapConfig.xml");
        SqlSessionFactory builder = new SqlSessionFactoryBuilder().builder(resouceAsStream);
        SqlSession sqlSession = builder.openSesion();

        User user = new User();
        user.setId(1);
//        List<User> objects = sqlSession.selectList("user.list", user);
//        for (User object : objects) {
//            System.out.println(object);
//        }
        IUserDao iUserDao = sqlSession.getMapper(IUserDao.class);
        List<User> all = iUserDao.findAll(user);
                for (User object : all) {
            System.out.println(object);
        }
    }
    @Test
    public void test2(){
        String a ="String1,qqqq";
        String[] strings = {"1", "2", "3"};
        String[] split = a.split(",");
        System.out.println(split.toString());
    }

}
