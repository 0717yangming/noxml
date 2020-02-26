package com.ym.app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(basePackages = "com.ym",excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION , classes = {Controller.class})})
public class AppConfig {

}
