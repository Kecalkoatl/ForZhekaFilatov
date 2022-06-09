package zf.task.hiperspring.java_config;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import zf.task.hiperspring.model.Car;
import zf.task.hiperspring.model.User;

@Configuration
@ComponentScan(basePackages = "zf.task.hiperspring")
public class AppConfig {

    @Bean
    public SessionFactory getSessionFactory() {
        SessionFactory factory = new org.hibernate.cfg.Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(User.class).addAnnotatedClass(Car.class).buildSessionFactory();

        return factory;
    }


}
