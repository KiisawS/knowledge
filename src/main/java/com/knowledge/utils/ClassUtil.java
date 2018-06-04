package com.knowledge.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClassUtil {

    private static final Logger LOG = LoggerFactory.getLogger(ClassUtil.class);

    public static void printClassMsg(Class clzz) {
        LOG.info("method:{}",clzz.getMethods().toString());
        LOG.info("all-method:{}", clzz.getDeclaredMethods());
        LOG.info("Constructors:{}", clzz.getConstructors());
        LOG.info("all-Constructors:{}", clzz.getDeclaredConstructors());
        LOG.info("Fields:{}", clzz.getFields());
        LOG.info("all-Fields:{}", clzz.getFields());
    }
}
