package com.knowledge.statics;

/*** 
 * @ClassName StaticMain
 * <p>Description: </p>
 * @author TF015582
 * @date 2018/6/6 13:36
 * <p>Company: 杭州传化货嘀科技有限公司</p>
 * 只要是static修饰的,子类无法重写父类.
 */
public class StaticMain {

    public static void main(String []args) {
        Parent p = new Children();
        //父类的
        System.out.println(p.val);
        System.out.println(p.finVal);
        System.out.println(p.statVal);
        System.out.println(p.STATFINVAL);
        p.statShow();
        p.finShow();
        //子类重写的
        p.show();

        Children c = new Children();
        //如果子类有相同的则调用子类,否则调用父类
        System.out.println(c.val);
        System.out.println(c.finVal);
        System.out.println(c.statVal);
        System.out.println(c.STATFINVAL);
        c.show();


        c.statShow();

        c.finShow();
    }
}
