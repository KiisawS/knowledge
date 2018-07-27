package com.knowledge.collection.set;

import com.knowledge.collection.bean.Param;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/***
 * @ClassName MyHashSet
 * <p>Description: </p>
 * @author TF015582
 * @date 2018/6/1 16:31
 * <p>Company: 杭州传化货嘀科技有限公司</p> 
 */
public class MyHashSet {

    public static void main(String []args) {
        hashSet();
        treeSet();
        new LinkedHashSet();
//                EnumSet;
        new HashSet();
        Set<String> set = new TreeSet<>();
        set.add("");
        new Hashtable();
        new HashMap<>();
        new TreeMap<>();
        new LinkedHashMap<>();
        new ConcurrentHashMap<>();
    }

    static void treeSet() {
        Set<Param> params = new TreeSet<>();
        init(params);
        print(params);
    }

    static void init(Set<Param> params) {
        Param param;
        for (int i = 0; i < 15; i+=2) {
            param = new Param();
            param.setCode(i);
            param.setValue("value:"+i);
            params.add(param);
        }
        param = new Param(0,"String");
        params.add(new Param(11, "ss"));
        params.add(param);
    }

    static void print(Set<Param> params) {
        System.out.println(params.size());
        System.out.println(params.toString());
        for (Param param : params) {
            System.out.println(param);
        }
    }

    static void hashSet() {
        Set<Param> params = new HashSet<>(16);
        init(params);
        print(params);
    }


}
