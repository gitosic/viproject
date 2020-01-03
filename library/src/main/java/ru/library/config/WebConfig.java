package ru.library.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "ru.library.controller")
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public ViewResolver getViewResolver(){
        FreeMarkerViewResolver freeMarkerViewResolver = new FreeMarkerViewResolver();//в роли ViewResolver используем FreeMarker
        freeMarkerViewResolver.setOrder(1);//Настроили порядок, когда он будет загружаться
        freeMarkerViewResolver.setSuffix(".jsp");//все файлы с расширением ftl
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
