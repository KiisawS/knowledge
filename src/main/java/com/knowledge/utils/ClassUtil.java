package com.knowledge.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author KiisawS
 * @date 2018-6-6
 */
public class ClassUtil {

    private static final Logger LOG = LoggerFactory.getLogger(ClassUtil.class);

    public static void main(String []args) {
        printClassMsg(AtomicInteger.class);
    }

    public static void printClassMsg(Class clzz) {
        LOG.info("Class:{}", clzz);
        LOG.info("Class-Name:{}", clzz.getName());
        LOG.info("Class-SimpleName:{}", clzz.getSimpleName());
        LOG.info("Superclass:{}", clzz.getSuperclass());
        LOG.info("Generic-Superclass:{}", clzz.getGenericSuperclass());
        LOG.info("Interfaces:{}", clzz.getInterfaces().length);
        for (Class aClass : clzz.getInterfaces()) {
            LOG.info("{}", aClass);
        }
        LOG.info("Generic-Interfaces:{}", clzz.getGenericInterfaces().length);
        for (Type type : clzz.getGenericInterfaces()) {
            LOG.info("{}", type);
        }
        LOG.info("Methods:{}", clzz.getMethods().length);
        for (Method method : clzz.getMethods()) {
            LOG.info("{}", method);
        }
        LOG.info("All-Methods:{}",clzz.getDeclaredMethods().length);
        for (Method method : clzz.getDeclaredMethods()) {
            LOG.info("{}", method);
        }
        LOG.info("Constructors:{}",clzz.getConstructors().length);
        for (Constructor constructor : clzz.getConstructors()) {
            LOG.info("{}", constructor);
        }
        LOG.info("All-Constructors:{}",clzz.getDeclaredConstructors().length);
        for (Constructor constructor : clzz.getDeclaredConstructors()) {
            LOG.info("{}", constructor);
        }
        LOG.info("Fields:{}", clzz.getFields().length);
        for (Field field : clzz.getFields()) {
            LOG.info("{}", field);
        }
        LOG.info("All-Fields:{}",clzz.getDeclaredFields().length);
        for (Field field : clzz.getDeclaredFields()) {
            LOG.info("{}", field);
        }
        LOG.info("Annotations:{}", clzz.getAnnotations().length);
        for (Annotation annotation : clzz.getAnnotations()) {
            LOG.info("{}", annotation);
        }
        LOG.info("All-Annotations:{}", clzz.getDeclaredAnnotations().length);
        for (Annotation annotation : clzz.getDeclaredAnnotations()) {
            LOG.info("{}", annotation);
        }
    }
}
