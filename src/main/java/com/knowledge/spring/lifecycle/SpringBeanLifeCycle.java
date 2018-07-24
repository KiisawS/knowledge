package com.knowledge.spring.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;

/***
 * @ClassName SpringBeanLifeCycle
 * <p>Description: </p>
 * @author TF015582
 * @date 2018/7/20 14:44
 * <p>Company: 杭州传化货嘀科技有限公司</p> 
 */
public class SpringBeanLifeCycle implements BeanNameAware,BeanFactoryAware,BeanPostProcessor,InitializingBean,DisposableBean {

    //1
    public SpringBeanLifeCycle() {
        System.out.println("SpringBeanLifeCycle");
    }

    //6
    public void init() {
        System.out.println("init");
    }

    //9
    public void close() {
        System.out.println("close");
    }

    //3
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("setBeanFactory");
    }


    //2
    @Override
    public void setBeanName(String name) {
        System.out.println("setBeanName");
    }

    //8
    @Override
    public void destroy() throws Exception {
        System.out.println("destroy");
    }

    //4
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }

    //5
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization");
        return bean;
    }
    //7
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization");
        return bean;
    }
}
