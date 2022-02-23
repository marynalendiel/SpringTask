package com.example.springtask;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//@SpringBootApplication
//@EnableConfigurationProperties
//@EntityScan(basePackages = {"com.example.springtask.entity"})  // scan JPA entities
public class SpringTaskDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { DemoAppConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

}
