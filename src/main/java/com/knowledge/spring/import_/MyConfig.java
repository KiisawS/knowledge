package com.knowledge.spring.import_;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/***
 * @ClassName MyConfig
 * <p>Description: </p>
 * @author TF015582
 * @date 2018/7/25 13:25
 * <p>Company: 杭州传化货嘀科技有限公司</p> 
 */
@Import({Square.class, Rectangle.class,
//        MyImportSelector.class,
        MyImportBeanDefinitionRegistrar.class})
@Configuration("config")
public class MyConfig {
}
