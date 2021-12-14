package com.luffy.mvcdiy.servlet;

import com.luffy.mvcdiy.annotation.LuffyAutowired;
import com.luffy.mvcdiy.annotation.LuffyController;
import com.luffy.mvcdiy.annotation.LuffyRequestMapping;
import com.luffy.mvcdiy.annotation.LuffyService;
import com.luffy.mvcdiy.pojo.Handle;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author luffy
 * @version 1.0
 * @desc
 * @date 2021/12/10 10:58
 */
public class LuffyDispatcherServlet  extends HttpServlet {

    private Properties properties = new Properties();
    private List<Handle> handleMap = new ArrayList<>();
    private Map<String,Object> ioc = new HashMap<>();
    private List<String> classNames =  new ArrayList<>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        //加载配置文件springmvc.properties
        String contextConfigLocation = config.getInitParameter("contextConfigLocation");
        doLoadConfig(contextConfigLocation);
        //扫描相关的类
        doScan(properties.getProperty("scanPackage"));
        //初始化bean 实现ioc容器
        doInstance();
        //依赖注入
        doAutowired();
        //构造处理器映射器
        initHandleMapping();

        System.out.println("初始化完成");
        //处理请求

    }

//    private Map<String,Method> handleMap = new HashMap<>();

    //构造处理器映射器
    //将url将handle对应
    private void initHandleMapping() {
        if (ioc.isEmpty()){ return;}
        for (Map.Entry<String,Object> entry : ioc.entrySet()) {
            //获取ioc容器中当前遍历对象的class
            Class<?> aClass = entry.getValue().getClass();
            if (!aClass.isAnnotationPresent(LuffyController.class)){
                continue;
            }
            String baseUrl = "";
            if (aClass.isAnnotationPresent(LuffyRequestMapping.class)){
                LuffyRequestMapping annotation = aClass.getAnnotation(LuffyRequestMapping.class);
                baseUrl = annotation.value();
            }

            //获取方法上的reqmapping
            Method[] methods = aClass.getMethods();
            for (int i = 0; i < methods.length; i++) {
                Method method = methods[i];
                if (!method.isAnnotationPresent(LuffyRequestMapping.class)){ continue;}
                LuffyRequestMapping annotation = method.getAnnotation(LuffyRequestMapping.class);
                String value = annotation.value();
                String url = baseUrl + value;
                //封装handle
                Handle handle = new Handle(entry.getValue(),method, Pattern.compile(url));
                //处理计算参数位置信息
                Parameter[] parameters = method.getParameters();
                for (int i1 = 0; i1 < parameters.length; i1++) {
                    Parameter parameter = parameters[i1];

                    if (parameter.getType() == HttpServletRequest.class || parameter.getType() == HttpServletResponse.class){
                        handle.put(parameter.getType().getSimpleName(),i1);
                    }else{
                        handle.put(parameter.getName(),i1);
                    }
                }
                handleMap.add(handle);
            }
        }
        }



    //依赖注入
    private void doAutowired() {
        if (ioc.isEmpty()) {
            return;
        }
        //有对象
        for (Map.Entry<String,Object> entry : ioc.entrySet()){
            //获取bean字段
            Field[] declaredFields = entry.getValue().getClass().getDeclaredFields();
            for (int i = 0; i < declaredFields.length; i++) {
                Field declaredField = declaredFields[i];
                if (!declaredField.isAnnotationPresent(LuffyAutowired.class)){
                    continue;
                }
                //有注入注解
                LuffyAutowired annotation = declaredField.getAnnotation(LuffyAutowired.class);
                String beanName = annotation.value();
                if ("".equals(beanName)){
                    //空 代表没配置id  采用接口注入
                    beanName = declaredField.getType().getName();
                }
                declaredField.setAccessible(true);
                try {
                    declaredField.set(entry.getValue(),ioc.get(beanName));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }


        }
    }


    //初始化bean 实现ioc容器
    private void doInstance()  {
        if (classNames.size() == 0 ){
            return;
        }
        try {
            for (int i = 0; i < classNames.size(); i++) {
                String className = classNames.get(i);
                Class<?> aClass = Class.forName(className);
                //区分controller 和service
                if (aClass.isAnnotationPresent(LuffyController.class)) {
                    //拿类的手指母小写作为id
                    String simpleName = aClass.getSimpleName();
                    String lowFirstWorld = lowFirstWorld(simpleName);
                    Object o = aClass.newInstance();
                    ioc.put(lowFirstWorld, o);
                } else if (aClass.isAnnotationPresent(LuffyService.class)) {
                    LuffyService annotation = aClass.getAnnotation(LuffyService.class);
                    //注解value值
                    String beanName = annotation.value();
                    if (!"".equals(beanName)) {
                        ioc.put(beanName, aClass.newInstance());
                    } else {
                        beanName = lowFirstWorld(aClass.getSimpleName());
                        ioc.put(beanName, aClass.newInstance());
                    }

                    //service有接口 以接口名为id  找到实现类 注入ioc
                    Class<?>[] interfaces = aClass.getInterfaces();
                    for (int i1 = 0; i1 < interfaces.length; i1++) {
                        Class<?> anInterface = interfaces[i1];
                        ioc.put(anInterface.getName(), aClass.newInstance());
                    }
                } else {
                    continue;
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public String lowFirstWorld(String word){
        char[] chars = word.toCharArray();
        if ('A' <=chars[0] && chars[0] <= 'Z'){
            chars[0]+= 32;
        }
        return String.valueOf(chars);
    }


    //扫描相关的类
    private void doScan(String scanPackage) {
        String scanPackagePath = Thread.currentThread().getContextClassLoader().getResource("").getPath() + scanPackage.replaceAll("\\.","/");
        File filePath = new File(scanPackagePath);
        File[] files = filePath.listFiles();
        for (File file : files) {
            if (file.isDirectory()){
                doScan(scanPackage+"."+file.getName());
            }else if (file.getName().endsWith(".class")){
                String className = scanPackage + "." + file.getName().replaceAll(".class","");
                classNames.add(className);
            }
        }


    }

    //加载配置文件springmvc.properties
    private void doLoadConfig(String contextConfigLocation) {
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(contextConfigLocation);

//            properties.load(resourceAsStream);
            properties.setProperty("scanPackage","com.luffy.mvcdiy");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //根据url找到对应的method方法
        String requestURI = req.getRequestURI();
//        Method method = handleMap.get(requestURI);//获取到反射方法
        Handle handler = getHandler(req);
        if (handler == null){
            resp.getWriter().write("404 not found");
            return;
        }
        //参数绑定
        //获取所有参数类型数组
        Class<?>[] parameterTypes = handler.getMethod().getParameterTypes();
        //根据数字长度创建新的参数数组
        Object[] params = new Object[parameterTypes.length];
        //同时保证参数顺序一致
        Map<String, String[]> parameterMap = req.getParameterMap();
        for (Map.Entry<String,String[]> param : parameterMap.entrySet()){
            String join = StringUtils.join(param.getValue(), ",");

            if (!handler.getParamIndexMap().containsKey(param.getKey())){
                continue;
            }
            params[handler.getParamIndexMap().get(param.getKey())] = join;
        }
        Integer integer = handler.getParamIndexMap().get(HttpServletRequest.class.getSimpleName());
        params[integer] = req;
        Integer respIndex = handler.getParamIndexMap().get(HttpServletResponse.class.getSimpleName());
        params[respIndex] = resp;


        //调用handle的method属性
        try {
            handler.getMethod().invoke(handler.getController(),params);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }

    private Handle getHandler(HttpServletRequest req) {
        if (handleMap.isEmpty()){
            return null;
        }
        String requestURI = req.getRequestURI();
        for (Handle handle : handleMap) {
            Matcher matcher = handle.getPattern().matcher(requestURI);
            if (!matcher.matches()){
                continue;
            }
            return handle;
        }
        return null;


    }
}
