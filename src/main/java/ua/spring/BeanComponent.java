package ua.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class BeanComponent {

    @Bean("asdasdasdasdasd")
    public String getPr(){
        return new String();
    }
}
