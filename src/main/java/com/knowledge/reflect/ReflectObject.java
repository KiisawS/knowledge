package com.knowledge.reflect;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/***
 * @ClassName ReflectObject
 * <p>Description: </p>
 * @author TF015582
 * @date 2018/8/10 8:51
 * <p>Company: 杭州传化货嘀科技有限公司</p> 
 */
@Getter
@Setter
@Slf4j
public class ReflectObject {

    private Integer intVal;

    private String strVal;

    private List<String> lists;

    private Map<String, Object> maps;


    public void learn(String val1, Integer val2){
        log.info(val1);
        log.info(val2+"");
    }

    public void learn(String... vals) {
        for (String val : vals) {
            log.info(val);
        }
    }

    public static void main(String []args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> clzz = Class.forName("com.knowledge.reflect.ReflectObject");

        Object ref = clzz.newInstance();

        Method method1 = clzz.getMethod("learn", String.class, Integer.class);

        Object object1 = method1.invoke(ref, "2", 1);
        System.out.println(object1);


        Method method2 = clzz.getMethod("learn", Array.newInstance(String.class,0).getClass());
        Object object2 = method2.invoke(ref, new String[][]{new String[]{"a", "b"}});
        System.out.println(object2);

    }

}
