package com.knowledge.aop.aspectj;

import lombok.extern.slf4j.Slf4j;

/***
 * @ClassName Hello
 * <p>Description: </p>
 * @author TF015582
 * @date 2018/7/20 16:53
 * <p>Company: 杭州传化货嘀科技有限公司</p> 
 */
@Slf4j
public class Hello implements Say{

    @Override
    public void say(String name) {
        log.info("hello " + name);
    }

    public static void main(String []args) {
        SayAspect sayAspect = new SayAspect(new Hello());
        sayAspect.say("1231321321");
    }
}
