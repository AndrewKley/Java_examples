package com.example.DTO;

public class CountryDTO {
    private String name;
    private int population;

    public static CountryDTO of(String name, int population) {
        CountryDTO country = new CountryDTO();
        country.setPopulation(population);
        country.setName(name);
        return country;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
