package com.luffy.privider.sqlSession;

import com.luffy.privider.config.XMLConfigBuilder;
import com.luffy.privider.pojo.Configuration;
import org.dom4j.DocumentException;

import java.beans.PropertyVetoException;
import java.io.InputStream;

/**
 * @author luffy
 * @version 1.0
 * @desc
 * @date 2021/9/27 15:54
 */
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory builder(InputStream inputStream) throws DocumentException, PropertyVetoException {
        //1.使用dom4j解析配置文件，讲解洗出来的内若封装到configuration
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder();
        Configuration configuration = xmlConfigBuilder.parseConfig(inputStream);
        //2.创建sqlsessionfactory对象  工厂模式
        SqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory(configuration);
        return sqlSessionFactory;
    }
}
