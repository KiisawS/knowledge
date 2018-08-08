package com.knowledge.mvc.servlet;

import com.knowledge.mvc.annotation.MyAutowired;
import com.knowledge.mvc.annotation.MyController;
import com.knowledge.mvc.annotation.MyRequestMapping;
import com.knowledge.mvc.annotation.MyService;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyDispatcherServlet extends HttpServlet {

    List<String> classNames = new ArrayList<>();

    Map<String, Object> beans = new HashMap<>();

    Map<String, Object> handlerMap = new HashMap<>();

    public MyDispatcherServlet() {
        init(null);

        System.out.println(1111);
    }

    @Override
    public void init(ServletConfig config) {
        //扫码所有class
        scanPackage("com.knowledge.mvc");

        //new对象放到map
        doInstance();

        autowired();

        urlMapping();
    }

    public void urlMapping(){
        for (Map.Entry<String, Object> entry : beans.entrySet()) {
            Object instance = entry.getValue();
            Class<?> clazz = instance.getClass();

            if (clazz.isAnnotationPresent(MyController.class)) {
                MyRequestMapping requestMapping = clazz.getAnnotation(MyRequestMapping.class);
                String classPath = requestMapping.value();

                Method[] methods = clazz.getMethods();
                for (Method method : methods) {
                    if (method.isAnnotationPresent(MyRequestMapping.class)) {
                        MyRequestMapping urlMapping = method.getAnnotation(MyRequestMapping.class);
                        String methodPath = urlMapping.value();
                        handlerMap.put(classPath+methodPath, method);
                    } else {
                        continue;
                    }
                }
            }
        }
    }

    private void autowired() {
        for (Map.Entry<String, Object> entry : beans.entrySet()) {
            Object instance = entry.getValue();
            Class<?> clazz = instance.getClass();

            if (clazz.isAnnotationPresent(MyController.class)) {
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    if (field.isAnnotationPresent(MyAutowired.class)) {
                        MyAutowired autowired = field.getAnnotation(MyAutowired.class);
                        String key = autowired.value();

                        try {
                            field.setAccessible(true);
                            field.set(instance, beans.get(key));
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }


    public void scanPackage(String basePackage) {
//        String name= "/" + basePackage.replaceAll("\\.", "/");
        URL url = this.getClass().getClassLoader().getResource(basePackage.replaceAll("\\.", "/"));

        String fileStr = url.getFile();

        File file = new File(fileStr);
        String[] filesStr = file.list();

        for (String path : filesStr) {
            File filePath = new File(fileStr +"/"+path);
            if (filePath.isDirectory()) {
                //文件夹
                scanPackage(basePackage + "." + path);
            } else {
                //com.**.class
                classNames.add(basePackage + "." + filePath.getName());
            }

        }
    }

    public void doInstance(){
        for (String className : classNames) {
            //class = com.**.class
            //cn = com.**
            String cn = className.replace(".class", "");

            try {
                Class<?> clazz = Class.forName(cn);
                if (clazz.isAnnotationPresent(MyController.class)) {
                    Object instance = clazz.newInstance();
                    MyRequestMapping requestMapping = clazz.getAnnotation(MyRequestMapping.class);
                    String key = requestMapping.value();
                    beans.put(key, instance);
                } else if (clazz.isAnnotationPresent(MyService.class)){
                    Object instance = clazz.newInstance();
                    MyService component = clazz.getAnnotation(MyService.class);
                    String key = component.value();
                    beans.put(key, instance);
                } else {
                    continue;
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        String context = req.getContextPath();
        String path = url.replace(context, "");

        Method method = (Method) handlerMap.get(path);


        MyController instance = (MyController) beans.get("/"+ path.split("/")[1]);


        Object[] args = hand(req, resp, method);

        try {
            method.invoke(instance, args);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        super.doPost(req, resp);
    }

    public Object[] hand(HttpServletRequest req, HttpServletResponse resp,Method method) {
        return  null;
    }
}
