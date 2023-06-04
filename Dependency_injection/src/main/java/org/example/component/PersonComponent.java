package org.example.component;

import org.example.model.Parrot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonComponent {
    private String name;

//    @Autowired
    private final ParrotComponent parrot;

//    @Autowired
    public  PersonComponent(ParrotComponent parrot) {
        this.parrot = parrot;
    }

    public String getName() {
        return name;
    }

    public ParrotComponent getParrot() {
        return parrot;
    }

    public void setName(String name) {
        this.name = name;
    }

//    @Autowired
//    public void setParrot(ParrotComponent parrot) {
//        this.parrot = parrot;
//    }
}
