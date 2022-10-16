package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class City {
    private String name;
    private int population;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public City(String name, int population) {
        this.name = name;
        this.population = population;
    }

}
