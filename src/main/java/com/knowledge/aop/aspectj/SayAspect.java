package com.knowledge.aop.aspectj;

import lombok.extern.slf4j.Slf4j;

/***
 * @ClassName HelloAspect
 * <p>Description: </p>
 * @author TF015582
 * @date 2018/8/8 8:52
 * <p>Company: 杭州传化货嘀科技有限公司</p> 
 */
@Slf4j
public class SayAspect implements Say{

    private Hello hello;

    public SayAspect(Hello hello) {
        this.hello = hello;
    }

    @Override
    public void say(String val) {
        log.info("代理开始");
        hello.say(val);
        log.info("代理结束");
    }
}
