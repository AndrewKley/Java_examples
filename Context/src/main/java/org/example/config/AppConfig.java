package org.example.config;

import org.example.beans.Parrot;
import org.example.components.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = "org.example")
public class AppConfig {
    @Bean
    Parrot parrot() {
        Parrot p = new Parrot();
        p.setName("Koko");
        return  p;
    }

    @Bean
    Integer ten() {
        return 10;
    }

    @Bean
    String hello() {
        return "Hello";
    }

    @Bean
    String bye() {
        return "Goodbye";
    }

    @Bean
    @Primary
    String goodLuck() {
        return "Good luck!";
    }

    @Bean(name = "hmmm")
//    @Bean(value = "hmmm")
    String oneTwo() {
        return "Hmmm...";
    }
}
