package ua;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ua.hibernate.model.Actor;
import ua.hibernate.service.ActorService;

import java.time.LocalDateTime;

import static org.springframework.boot.SpringApplication.run;


@SpringBootApplication
public class ForHibernateTest {
    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext applicationContext = run(ForHibernateTest.class, args);
        String[] names = applicationContext.getBeanDefinitionNames();
    }
}

