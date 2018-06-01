package com.knowledge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @author KiisawS
 * @see SpringBootServletInitializer
 */
@SpringBootApplication
public class KnowledgeApplication extends SpringBootServletInitializer{

    public static void main(String []args) {
        SpringApplication.run(KnowledgeApplication.class,args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(KnowledgeApplication.class);
    }
}
