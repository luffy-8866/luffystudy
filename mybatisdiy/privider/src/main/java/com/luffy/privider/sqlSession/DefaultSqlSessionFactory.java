package com.luffy.privider.sqlSession;

import com.luffy.privider.pojo.Configuration;

public class DefaultSqlSessionFactory implements SqlSessionFactory{

    private Configuration configuration;
    public DefaultSqlSessionFactory(){

    }
    public DefaultSqlSessionFactory(Configuration configuration){
        this.configuration=configuration;
    }

    @Override
    public SqlSession openSesion() {
        return new DefaultSqlSession(configuration);
    }
}
