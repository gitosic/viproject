package com.vebinar.config;

import com.vebinar.service.TestBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//После создания этого класса как SpringConfig (Особенность как созд.)с видео 9:17). Все бины описанные в этом классе будут
//в нашем контексте приложения
@Configuration//Это конфигурация спринга --> spring-context --> добавит в pom.xml зависимость на spring-context
public class SpringConfig {

    //В этом бине мы описываем класс TestBean
    @Bean
    public TestBean getTestBean(){
        return new TestBean("Vitally!");
    }
}