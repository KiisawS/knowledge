package com.knowledge.spring.import_;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/***
 * @ClassName MyImportBeanDefinitionRegistrar
 * <p>Description: </p>
 * @author TF015582
 * @date 2018/7/25 12:54
 * <p>Company: 杭州传化货嘀科技有限公司</p> 
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        // new一个RootBeanDefinition
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Rectangle.class);
        // 注册一个名字叫rectangle的bean
        registry.registerBeanDefinition("rectangle", rootBeanDefinition);
    }
}
