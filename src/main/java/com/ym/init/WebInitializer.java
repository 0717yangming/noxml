package com.ym.init;

import com.ym.app.AppConfig;
import com.ym.app.SpringmvcConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class WebInitializer implements WebApplicationInitializer {
    public void onStartup(ServletContext servletContext) {
        System.out.println("-----初始化------");
        AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
        ac.register(AppConfig.class,SpringmvcConfig.class);
        //ac.refresh();
      //  servletContext.addFilter("encodingFilter",new CharacterEncodingFilter("UTF-8",true,true));
        ac.setServletContext(servletContext);
        ac.refresh();
        // Create and register the DispatcherServlet
        DispatcherServlet servlet = new DispatcherServlet(ac);
        ServletRegistration.Dynamic registration = servletContext.addServlet("app", servlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/*");

//        FilterRegistration.Dynamic filterRegistration = servletContext.addFilter("encodingFilter",
//                new CharacterEncodingFilter());
//        filterRegistration.setInitParameter("encoding", "UTF-8");
//        filterRegistration.setInitParameter("forceEncoding", "true");
//        filterRegistration.addMappingForUrlPatterns(null,true,"/*");
        FilterRegistration.Dynamic encodingFilter = servletContext.addFilter("encodingFilter", new CharacterEncodingFilter("UTF-8", true, true));
        encodingFilter.addMappingForUrlPatterns(null,true,"/*");
    }
}

