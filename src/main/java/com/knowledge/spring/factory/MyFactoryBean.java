package com.knowledge.spring.factory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/***
 * @ClassName MyFactoryBean
 * <p>Description: </p>
 * @author TF015582
 * @date 2018/7/24 14:30
 * <p>Company: 杭州传化货嘀科技有限公司</p> 
 */
@Component
public class MyFactoryBean implements FactoryBean<MyFactoryBean.MyBean> {

    private MyBean myBean;

    @Override
    public MyBean getObject() throws Exception {
        myBean = new MyBean();
        myBean.setVal("123");
        return myBean;
    }

    @Override
    public Class<?> getObjectType() {
        return myBean != null ? myBean.getClass(): MyBean.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }


    static class MyBean {
        private String val;
        public String getVal() {
            return val;
        }
        public void setVal(String val) {
            this.val = val;
        }
    }

    public static void main(String []args) {
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        BeanFactory beanFactory = defaultListableBeanFactory;
        try {
            ApplicationContext context1 = (ApplicationContext) beanFactory;
        } catch(Exception e) {
           System.out.println(e);
        }
        DefaultListableBeanFactory defaultListableBeanFactory1 = (DefaultListableBeanFactory) beanFactory;

        beanFactory = new AnnotationConfigApplicationContext("com.knowledge.spring.factory");

        //通过myFactoryBean获取的Bean实例为MyBean对象
        System.out.println(beanFactory.getBean("myFactoryBean"));

        System.out.println(beanFactory.getBean("myFactoryBean"));

        //如果要获取MyFactoryBean对象实例，需要添加&符号
        System.out.println(beanFactory.getBean("&myFactoryBean"));
    }
}
