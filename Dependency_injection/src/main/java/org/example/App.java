package org.example;

import org.example.component.PersonComponent;
import org.example.component.PersonComponentWithParrot;
import org.example.config.AppConfig;
import org.example.model.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Person p = context.getBean(Person.class);
        System.out.println(p.getName());
        System.out.println(p.getParrot());

        PersonComponent pc = context.getBean(PersonComponent.class);
        System.out.println(pc.getName());
        System.out.println(pc.getParrot());

        PersonComponentWithParrot pwp = context.getBean(PersonComponentWithParrot.class);
        System.out.println(pwp.getName());
        System.out.println(pwp.getParrot());
    }
}
