package com.vebinar.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

//Класс будет при старте создавать апликейшн контекст
//Создадим диспачер сервлет
//имплементим WebApplicationInitializer
//одим метод onStartup, который будет запускаться при старте приложения
//Это у нас поднимается спринг контекст и загрузились все депенденси которые мы опишем в этоим конфиг фвайле.
public class WebAppInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(javax.servlet.ServletContext servletContext) throws ServletException {

        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(SpringConfig.class, WebConfig.class);//регистрируем классы с конфигами
        context.setServletContext(servletContext);//прописываем servletContext, поскольку он приходит в этот класс

        //Создадим диспачер сервлет
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(context));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");//]обрабатывает все начиная с мамого начала.
    }
}