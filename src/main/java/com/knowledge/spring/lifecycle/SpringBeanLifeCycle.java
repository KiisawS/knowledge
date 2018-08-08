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
 * Spring Bean的生命周期
    1.实例化一个Bean,即new;
    2.Spring根据上下文环境对实例化的Bean进行配置,即IOC注入;
    3.如果实现了BeanNameAware,则调用setBeanName(String);
    4.如果实现了BeanFactoryAware或ApplicationContextAware,则调用setBeanFactory(BeanFactory)或setApplicationContext(ApplicationContext), 可以使用Spring工厂方法,即IOC容器相关方法;
    5.如果实现了BeanPostProcessor,则调用postProcessBeforeInitialization();
    注意：BeanPostProcessor这个前处理Bean和后处理Bean会对所有的Bean进行拦截。
    6.如果实现了InitializingBean,则调用afterPropertiesSet();
    7.如果配置了init-method(),则自动调用配置的初始化方法;
    8.如果实现了BeanPostProcessor,则调用postProcessAfterInitialization();
    9.如果实现了DisposableBean,则调用destroy();
    10.如果配置了destroy-mehod(),则自动调用配置的销毁方法.
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

    //5
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }

    //4
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization" + beanName);
        return bean;
    }
    //7
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization" + beanName);
        return bean;
    }
}
