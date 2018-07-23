package com.knowledge.aop.aspectj;

/*** 
 * @ClassName HelloAspect
 * <p>Description: </p>
 * @author TF015582
 * @date 2018/7/20 17:00
 * <p>Company: 杭州传化货嘀科技有限公司</p> 
 */
public aspect HelloAspect {

    void around() : call(void Hello.sayHello()){
        System.out.println("开始事务 ...");
        proceed();
        System.out.println("事务结束 ...");
    }
}
