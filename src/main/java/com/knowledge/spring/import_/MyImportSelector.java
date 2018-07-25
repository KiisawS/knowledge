package com.knowledge.spring.import_;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/***
 * @ClassName MyImportSelector
 * <p>Description: </p>
 * @author TF015582
 * @date 2018/7/25 10:30
 * <p>Company: 杭州传化货嘀科技有限公司</p> 
 */
public class MyImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{ "com.knowledge.spring.import_.MyImportSelector" };
    }
}
