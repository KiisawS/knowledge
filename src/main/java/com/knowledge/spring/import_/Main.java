package com.knowledge.spring.import_;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/***
 * @ClassName Main
 * <p>Description: </p>
 * @author TF015582
 * @date 2018/7/25 10:20
 * <p>Company: 杭州传化货嘀科技有限公司</p> 
 */
public class Main {

    public static void main(String []args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
        applicationContext.refresh();
//        System.out.println(applicationContext.getBean(Square.class));
//        System.out.println(applicationContext.getBean("rectangle"));
//        System.out.println(applicationContext.getBean("com.knowledge.spring.import_.Rectangle"));
    }
}
