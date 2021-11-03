package com.luffy.privider.sqlSession;

import com.luffy.privider.pojo.Configuration;

import java.beans.IntrospectionException;
import java.lang.reflect.*;
import java.sql.SQLException;
import java.util.List;

/**
 * @author luffy
 * @version 1.0
 * @desc
 * @date 2021/10/11 13:54
 */
public class DefaultSqlSession implements SqlSession {
    private Configuration configuration;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <T> List<T> selectList(String statementId, Object... params) throws ClassNotFoundException, SQLException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, IntrospectionException, InstantiationException {
        SimpleExecutor simpleExecutor = new SimpleExecutor();
        List<Object> list = simpleExecutor.query(configuration, configuration.getMappedStatementMap().get(statementId), params);
        return (List<T>) list;
    }

    @Override
    public <T> T selectOne(String statementId, Object... params) {

        return null;
    }

    @Override
    public <T> T getMapper(Class<?> mapperClass) {
        //使用jdk动态代理 为dao接口生成代理对象
        Object proxyInstance = Proxy.newProxyInstance(DefaultSqlSession.class.getClassLoader(), new Class[]{mapperClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //底层执行jdbc代码

                String methodName = method.getName();
                String className = method.getDeclaringClass().getName();
                String statementId= className+"."+methodName;

                //获取被调用的返回值类型
                Type genericReturnType = method.getGenericReturnType();
                //是否进行了参数泛型化
                if (genericReturnType instanceof ParameterizedType){
                    List<Object> objects = selectList(statementId, args);
                    return objects;
                }
                return selectOne(statementId, args);
            }
        });

        return (T) proxyInstance;
    }
}
