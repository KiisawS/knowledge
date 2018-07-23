package com.knowledge.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/***
 * @ClassName SpringBeanConfig
 * <p>Description: </p>
 * @author TF015582
 * @date 2018/7/20 15:52
 * <p>Company: 杭州传化货嘀科技有限公司</p> 
 */
@Configuration
public class SpringBeanConfig {

    @Bean(initMethod = "init",destroyMethod = "close")
    @Scope("prototype")
    public SpringBeanLifeCycle springBeanLifeCycle() {
        return new SpringBeanLifeCycle();
    }

    public static void main(String []args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.knowledge.spring");
        System.out.println(applicationContext.getBean(SpringBeanLifeCycle.class));
        System.out.println(applicationContext.getBean(SpringBeanLifeCycle.class));

        applicationContext.destroy();


    }
}
