package org.example.component;

import org.example.model.Parrot;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PersonComponentWithParrot {
    private String name;

    private final Parrot parrot;

//    public PersonComponentWithParrot(Parrot parrot2) {
//        this.parrot = parrot2;
//    }

    public PersonComponentWithParrot(@Qualifier("parrot2") Parrot parrot) {
        this.parrot = parrot;
    }

    public String getName() {
        return name;
    }

    public Parrot getParrot() {
        return parrot;
    }

    public void setName(String name) {
        this.name = name;
    }
}
