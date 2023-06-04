package org.example;

import org.example.beans.Parrot;
import org.example.components.Dog;
import org.example.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App
{
    public static void main(String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Parrot p = context.getBean(Parrot.class);
        System.out.println(p.getName());

        Integer ten = context.getBean(Integer.class);
        System.out.println(ten);

        String primary = context.getBean(String.class);
        System.out.println(primary);

        String str = context.getBean("bye", String.class);
        System.out.println(str);

        String str2 = context.getBean("hmmm", String.class);
        System.out.println(str2);

        Dog sharic = context.getBean(Dog.class);
        System.out.println(sharic.getName());

        
    }
}
