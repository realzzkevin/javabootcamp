package com.company;

public class TeamLead extends Developer {

    private String favoriteProjectMethodology;

    public int planSprint() {
        System.out.println("We are going to deliver everything we commit to! Let's Go!!!");
        return 29;
    }

    public void assignWork(Developer developer) {
        System.out.println("I think you can handle this one, " + developer.getName() + ".");
    }

    public String getFavoriteProjectMethodology() {
        return favoriteProjectMethodology;
    }

    public void setFavoriteProjectMethodology(String favoriteProjectMethodology) {
        this.favoriteProjectMethodology = favoriteProjectMethodology;
    }
}