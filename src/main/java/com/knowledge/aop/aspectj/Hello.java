package com.knowledge.aop.aspectj;

/*** 
 * @ClassName Hello
 * <p>Description: </p>
 * @author TF015582
 * @date 2018/7/20 16:53
 * <p>Company: 杭州传化货嘀科技有限公司</p> 
 */
public class Hello {

    public void sayHello(String name) {
        System.out.println(name + "  hello");
    }

    public static void main(String []args) {
        Hello hello = new Hello();
        hello.sayHello("1231321321");
    }
}
