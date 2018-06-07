package com.knowledge.statics;

import lombok.val;

/***
 * @ClassName Parent
 * <p>Description: </p>
 * @author TF015582
 * @date 2018/6/6 13:32
 * <p>Company: 杭州传化货嘀科技有限公司</p> 
 */
class Parent {

    String val = "parent";
    final String finVal = "final parent";
    static String statVal = "static parent";
    static final String STATFINVAL = "static final parent";

    /**
     *
     */
    public void show() {
        System.out.println("parent show");
    }

    /**
     * 不能被子类重写,子类只是有相同名称的方法.
     */
    public static void statShow() {
        System.out.println("parent statShow");
    }

    /**
     * 不能被子类重写,子类不能有相同签名的方法.
     */
    public final void finShow() {
        System.out.println("parent finShow");
    }
}
