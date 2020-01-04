package ru.library.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import javax.sql.DataSource;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"ru.library.controller", "ru.library.service", "ru.library.dao"})//{ru.library.controller} - чтоб открывались страницы. //{com.vebinar.service, com.vebinar.dao}Указываем место, где лефат все компоненты - т.е. не нужно теперь создавать бины
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/base").setViewName("base");
        registry.addViewController("/").setViewName("base");
        registry.addViewController("/hello").setViewName("hello.html");//см комент
        registry.addViewController("/login").setViewName("login.html");//см комент
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        //registry.addViewController("/hello").setViewName("hello.html");
        registry.addViewController("/test").setViewName("test.html");//Это должно быть
        registry.addViewController("/test2").setViewName("test2.html");//Это должно быть
        registry.addViewController("/bookslist").setViewName("bookslist.html");//Это должно быть
        registry.addViewController("/books").setViewName("books");
        registry.addViewController("/createbook").setViewName("createbook.html");//Это должно быть
        //registry.addViewController("/login").setViewName("login.html");
    }

    @Bean
    public ViewResolver getViewResolver(){
        FreeMarkerViewResolver freeMarkerViewResolver = new FreeMarkerViewResolver();//в роли ViewResolver используем FreeMarker
        freeMarkerViewResolver.setOrder(1);//Настроили порядок, когда он будет загружаться
        freeMarkerViewResolver.setSuffix(".jsp");//все файлы с расширением jsp
        freeMarkerViewResolver.setPrefix("");//сейчас он нам не нужен, так как есть бин freeMarkerConfigurer
        return freeMarkerViewResolver;
    }

    @Bean
    public FreeMarkerConfigurer freeMarkerConfigurer(){
        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
        freeMarkerConfigurer.setTemplateLoaderPaths("/", "WEB-INF/views/");
        return freeMarkerConfigurer;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate(){
        return new JdbcTemplate(getDataSource());
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres?useSll=false");
        dataSource.setDriverClassName("org.postgresql.Driver");
        return dataSource;
    }
}
