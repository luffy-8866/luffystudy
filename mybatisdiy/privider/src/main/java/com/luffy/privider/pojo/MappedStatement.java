package com.luffy.privider.pojo;

/**
 * @author luffy
 * @version 1.0
 * @desc
 * @date 2021/9/27 15:37
 */
public class MappedStatement {
    //id 标识
    private String id;
    //返回值类型
    private String resultType;
    //参数类型
    private String paramerType;
    //SQL语句
    private String sql;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getParamerType() {
        return paramerType;
    }

    public void setParamerType(String paramerType) {
        this.paramerType = paramerType;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }
}
