package org.example.component;

import org.springframework.stereotype.Component;

@Component
public class ParrotComponent {
    private String name = "Koko component";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Parrot: " + name;
    }
}
