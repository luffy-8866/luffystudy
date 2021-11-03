package com.luffy.privider.sqlSession;

import com.luffy.privider.config.BoundSql;
import com.luffy.privider.pojo.Configuration;
import com.luffy.privider.pojo.MappedStatement;
import com.luffy.privider.utils.GenericTokenParser;
import com.luffy.privider.utils.ParameterMapping;
import com.luffy.privider.utils.ParameterMappingTokenHandler;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author luffy
 * @version 1.0
 * @desc
 * @date 2021/10/11 14:51
 */
public class SimpleExecutor implements Executor {
    @Override
    public <E> List<E> query(Configuration configuration, MappedStatement mappedStatement, Object... params) throws SQLException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException, IntrospectionException, InstantiationException, InvocationTargetException {
        //1.注册驱动，获取连接
        Connection connection = configuration.getDataSource().getConnection();
        //2.获取sql
        //sql转换 #{} 转换？
        String sql = mappedStatement.getSql();
        BoundSql boundSql = getBoundSql(sql);
        //3.获取预处理对象 preparedstatement
        PreparedStatement preparedStatement = connection.prepareStatement(boundSql.getSqlText());
        //4.设置参数
            //获取参数全路径
        String paramerType = mappedStatement.getParamerType();
        Class<?> paramterTypeClass = getClassType(paramerType);
        List<ParameterMapping> parameterMappingList = boundSql.getParameterMappingList();
        for (int i = 0; i < parameterMappingList.size(); i++) {
            ParameterMapping parameterMapping = parameterMappingList.get(i);
            String content = parameterMapping.getContent();
            Field declaredField = paramterTypeClass.getDeclaredField(content);
            //暴力访问
            declaredField.setAccessible(true);
            Object o = declaredField.get(params[0]);

            preparedStatement.setObject(i+1,o);
        }

        //5.执行sql
        ResultSet resultSet = preparedStatement.executeQuery();
        //6.处理结果集
        String resultType = mappedStatement.getResultType();
        Class<?> resultClassType = getClassType(resultType);
        List<Object> objects = new ArrayList<>();
        while (resultSet.next()){
            Object o = resultClassType.newInstance();
            ResultSetMetaData metaData = resultSet.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                //字段名
                String columnName = metaData.getColumnName(i);
                //字段值
                Object object = resultSet.getObject(columnName);
                //使用反射，根据数据库实体对应关系 完成封装
                PropertyDescriptor propertyDescriptor = new PropertyDescriptor(columnName, resultClassType);
                Method writeMethod = propertyDescriptor.getWriteMethod();
                writeMethod.invoke(o,object);

            }
            objects.add(o);
        }
        //

        return (List<E>)objects;
    }

    private Class<?> getClassType(String paramerType) throws ClassNotFoundException {
        if (paramerType != null) {
            Class<?> aClass = Class.forName(paramerType);
            return aClass;
        }
        return null;
    }
    //对 #{}  解析？·
    //解析#{} 里面的值进行存储
    private BoundSql getBoundSql(String sql) {
        //标记处理类，，配合标记解析器完成对占位符的解析处理
        ParameterMappingTokenHandler parameterMappingTokenHandler = new ParameterMappingTokenHandler();
        GenericTokenParser genericTokenParser = new GenericTokenParser("#{", "}", parameterMappingTokenHandler);
        String parse = genericTokenParser.parse(sql);
        //#{} 解析出来的参数名称
        List<ParameterMapping> parameterMappings = parameterMappingTokenHandler.getParameterMappings();
        BoundSql boundSql = new BoundSql(parse, parameterMappings);
        return boundSql;
    }
}
