package com.luffy.mvcdiy.pojo;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author luffy
 * @version 1.0
 * @desc
 * @date 2021/12/14 11:07
 */
public class Handle {

    private Object controller;

    private Method method;
    //uri正则表达
    private Pattern pattern;
    //参数顺序 进行参数绑定 key 是参数名  index 参数顺序
    private Map<String,Integer> paramIndexMap;

    public void put(String simpleName, int i1) {
        paramIndexMap.put(simpleName,i1);
    }

    public Object getController() {
        return controller;
    }

    public void setController(Object controller) {
        this.controller = controller;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    public Map<String, Integer> getParamIndexMap() {
        return paramIndexMap;
    }

    public void setParamIndexMap(Map<String, Integer> paramIndexMap) {
        this.paramIndexMap = paramIndexMap;
    }

    public Handle(Object controller, Method method,Pattern pattern) {
        this.controller = controller;
        this.method = method;
        this.pattern = pattern;
        this.paramIndexMap = new HashMap<>();
    }
}
