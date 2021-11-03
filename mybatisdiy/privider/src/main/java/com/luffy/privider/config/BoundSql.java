package com.luffy.privider.config;

import com.luffy.privider.utils.ParameterMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luffy
 * @version 1.0
 * @desc
 * @date 2021/10/11 15:37
 */
public class BoundSql {

    private String sqlText;
    private List<ParameterMapping> parameterMappingList = new ArrayList<>();

    public BoundSql(String sqlText, List<ParameterMapping> parameterMappingList) {
        this.sqlText = sqlText;
        this.parameterMappingList = parameterMappingList;
    }

    public String getSqlText() {
        return sqlText;
    }

    public void setSqlText(String sqlText) {
        this.sqlText = sqlText;
    }

    public List<ParameterMapping> getParameterMappingList() {
        return parameterMappingList;
    }

    public void setParameterMappingList(List<ParameterMapping> parameterMappingList) {
        this.parameterMappingList = parameterMappingList;
    }
}
