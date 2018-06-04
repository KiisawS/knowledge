package com.knowledge.collection;

import com.knowledge.collection.set.MyHashSet;
import com.knowledge.utils.ClassUtil;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

/***
 * @ClassName CollectionTest
 * <p>Description: </p>
 * @author TF015582
 * @date 2018/6/1 16:31
 * <p>Company: 杭州传化货嘀科技有限公司</p> 
 */
public class CollectionTest {
    private HashMap hashMap;
    private LinkedHashMap linkedHashMap;

    private ArrayList arrayList;
    private LinkedList linkedList;

    public static void main(String[] args) {
        ClassUtil.printClassMsg(MyHashSet.class);
        for (Method method : Integer.class.getMethods()) {
            System.out.println(method);
        }
}
}
