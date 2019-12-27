package com.vebinar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

//Добавили "extends WebMvcConfigurerAdapter" - это компонент спринга который будет обрабатывать и искать наши
//вьюшки в папке WEB-INF и тут описываем бины
//Мы тут определили вью резолвер
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.vebinar.controller")//указываем путь где лежат контроллеры
public class WebConfig extends WebMvcConfigurerAdapter {
    //ViewResolver компонент спринга, который будет обрабатывать и искать
    //наши вьюшки в папке WEB-INF
    @Bean
    public ViewResolver getViewResolver(){
        FreeMarkerViewResolver freeMarkerViewResolver = new FreeMarkerViewResolver();//в роли ViewResolver используем FreeMarker
        freeMarkerViewResolver.setOrder(1);//Настроили порядок, когда он будет загружаться
        freeMarkerViewResolver.setSuffix(".ftl");//все файлы с расширением ftl
        freeMarkerViewResolver.setPrefix("");//сейчас он нам не нужен, так как есть второй бин
        // подставляет путь к view начиная с "/webapp"
        return freeMarkerViewResolver;
    }

    @Bean
    public FreeMarkerConfigurer freeMarkerConfigurer(){
        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
        freeMarkerConfigurer.setTemplateLoaderPaths("/", "WEB-INF/views/");//Два пути, где будут лежать темплейты
        return freeMarkerConfigurer;
    }
}
