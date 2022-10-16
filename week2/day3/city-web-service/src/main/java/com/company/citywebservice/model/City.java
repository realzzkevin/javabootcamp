package com.company.citywebservice.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class City {
    @NotEmpty()
    private String name;
    @NotEmpty
    private String state;
    @Min(value = 1, message = "Population must have a positive value")
    private int population;
    private boolean isStateCapital;

    public City(String name, String state, int population, boolean isStateCapital) {
        this.name = name;
        this.state = state;
        this.population = population;
        this.isStateCapital = isStateCapital;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public boolean isStateCapital() {
        return isStateCapital;
    }

    public void setStateCapital(boolean stateCapital) {
        isStateCapital = stateCapital;
    }
}
