package com.vebinar.config;

import com.vebinar.dao.UserDao;
import com.vebinar.dao.UserDaoImpl;
import com.vebinar.service.UserService;
import com.vebinar.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.DriverManager;
import java.sql.SQLException;

//После создания этого класса как SpringConfig (Особенность как созд.)с видео 9:17). Все бины описанные в этом классе будут
//в нашем контексте приложения

//В этом конфиг файле явно бина с типом UserService не описываем

@Configuration//Это конфигурация спринга --> spring-context --> добавит в pom.xml зависимость на spring-context
@ComponentScan(basePackages = {"com.vebinar.service", "com.vebinar.dao"})//Указываем место, где лефат все компоненты - т.е. не нужно теперь создавать бины
public class SpringConfig {

    //В этом бине мы описываем класс TestBean --> вместо удаления коментирую навсегда
    /*@Bean
    public TestBean getTestBean(){
        return new TestBean("Vitally!");
    }*/

    //Используем спринг jdbc
    @Bean
    public JdbcTemplate getJdbcTemplate(){
        return new JdbcTemplate(getDataSource());//Параметром(в скобках) принимает датаСоурс - это объект, который описывает конекшен к базе данных
        //getDataSoruce - это бин, который опишем
    }

    //Этот бин создаст конекшн и датасорс в котором будут лежать настройки додключения к базе данных
    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres?useSll=false");
        //dataSource.setUsername("");
        //dataSource.setPassword("");
        dataSource.setDriverClassName("org.postgresql.Driver");
        //dataSource.setDriverClassName("com.mysql.jdbc.Driver");//mysql
        return dataSource;
    }

    //getUserService используется в dao.
    //Вместо обозначения этого бина перед названием класса пишем: @ComponentScan(basePackages = "com.vebinar.dao")
    /*@Bean
    public UserDao getUserDao(){
        return new UserDaoImpl(getJdbcTemplate());
    }*/

    //getUserService используется в controller-е.
    //Вместо обозначения этого бина перед названием класса пишем: @ComponentScan(basePackages = "com.vebinar.service")
    /*@Bean
    public UserService getUserService(){
        return new UserServiceImpl();
    }*/
}