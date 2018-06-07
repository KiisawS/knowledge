package com.knowledge.statics;

/*** 
 * @ClassName Children
 * <p>Description: </p>
 * @author TF015582
 * @date 2018/6/6 13:35
 * <p>Company: 杭州传化货嘀科技有限公司</p> 
 */
class Children extends Parent{

//    String val = "child";
//    final String finVal = "final child";
//    static String statVal = "static child";
//    static final String STATFINVAL = "static final child";

    @Override
    public void show() {
        System.out.println("child show");
    }

    /**
     * 父类static方法不可重写.
     * 子类只是有与父类相同的方法,但不是重写
     */
    public static void statShow() {
        System.out.println("child statShow");
    }

}
