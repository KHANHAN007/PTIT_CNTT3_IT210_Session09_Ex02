package com.session05.ex02.config;

import org.jspecify.annotations.Nullable;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer{
    @Override
    protected Class<?> @Nullable [] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?> @Nullable[] getServletConfigClasses() {
        return new Class[] { AppConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}
