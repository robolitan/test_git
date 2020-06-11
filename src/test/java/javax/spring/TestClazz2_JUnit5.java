package javax.spring;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ua.ForHibernateTest;

class TestClazz2_JUnit5 {

    @Test
    void getX() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ForHibernateTest.class);
    }
}