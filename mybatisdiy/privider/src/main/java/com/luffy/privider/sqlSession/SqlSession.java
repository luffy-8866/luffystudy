package com.luffy.privider.sqlSession;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public interface SqlSession {

    //查询所有
    public <T> List<T> selectList(String statementId,Object... params) throws ClassNotFoundException, SQLException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, IntrospectionException, InstantiationException;

    //查询单个
    public <T> T selectOne(String statementId,Object... params);

    public <T> T getMapper(Class<?> mapperClass);

}
