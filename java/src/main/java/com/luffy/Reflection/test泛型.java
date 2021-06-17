package com.luffy.Reflection;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * @author luffy
 * @version 1.0
 * @desc 通过反射操作泛型
 * @date 2021/6/17 13:44
 */
public class test泛型 {
        public void test(Map<String,luffy> map, List<luffy> list){

        }
        public Map<String,luffy> test2(){
            return null;
        }

    public static void main(String[] args) throws NoSuchMethodException {
        Method test = test泛型.class.getMethod("test", Map.class, List.class);
        Type[] genericParameterTypes = test.getGenericParameterTypes();
        for (Type genericParameterType : genericParameterTypes) {
            System.out.println(genericParameterType);
            if (genericParameterType instanceof ParameterizedType){
                Type[] actualTypeArguments = ((ParameterizedType) genericParameterType).getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments) {
                    System.out.println(actualTypeArgument);
                }
            }
        }
        Method test2 = test泛型.class.getMethod("test2");
        Type genericReturnType = test2.getGenericReturnType();
        System.out.println(genericReturnType);
    }
}
