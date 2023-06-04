package org.example.config;

import org.example.model.Parrot;
import org.example.model.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.example.component")
public class AppConfig {
    @Bean
    public Parrot parrot() {
        Parrot p = new Parrot();
        p.setName("Koko");
        return p;
    }

    @Bean
    public Parrot parrot2() {
        Parrot p = new Parrot();
        p.setName("Miki");
        return p;
    }

//    @Bean
//    public Person person() {
//        Person p = new Person();
//        p.setName("Jupiter Elia");
//        p.setParrot(parrot());
//        return p;
//    }

//    @Bean
//    public Person person(@Qualifier("parrot2") Parrot parrot) {
//        Person p = new Person();
//        p.setName("Jupiter Elia");
//        p.setParrot(parrot);
//        return p;
//    }

    @Bean
    public Person person(Parrot parrot) {
        Person p = new Person();
        p.setName("Jupiter Elia");
        p.setParrot(parrot);
        return p;
    }
}
