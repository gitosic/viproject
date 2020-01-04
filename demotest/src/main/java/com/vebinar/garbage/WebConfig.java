package com.vebinar.garbage;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "ru.library.controller")
////
//@ComponentScan(basePackages = {"ru.library.service", "ru.library.dao", "ru.library.config"})
public class WebConfig extends WebMvcConfigurerAdapter {

    //new_qw13
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        //registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/login").setViewName("login");
    }

    @Bean
    public ViewResolver getViewResolver(){
        FreeMarkerViewResolver freeMarkerViewResolver = new FreeMarkerViewResolver();//в роли ViewResolver используем FreeMarker
        freeMarkerViewResolver.setOrder(1);//Настроили порядок, когда он будет загружаться
        freeMarkerViewResolver.setSuffix(".html");//все файлы с расширением jsp
        freeMarkerViewResolver.setPrefix("");//сейчас он нам не нужен, так как есть второй бин
        return freeMarkerViewResolver;
    }
    @Bean
    public FreeMarkerConfigurer freeMarkerConfigurer(){
        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
        freeMarkerConfigurer.setTemplateLoaderPaths("/", "WEB-INF/views/");
        return freeMarkerConfigurer;
    }
}
