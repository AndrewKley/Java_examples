package org.example.components;

import org.springframework.stereotype.Component;

@Component
public class Dog {
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
