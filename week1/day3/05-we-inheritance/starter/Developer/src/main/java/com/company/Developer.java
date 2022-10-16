package com.company;

public class Developer {
    private String name;
    private String favoriteLanguage;
    private int firstYearAsDeveloper;

    public int estimateStoryPoints() {
        int returnVal = 3;
        System.out.println("I believe that is a 3 point problem.");
        return returnVal;
    }

    public void checkInCode() {
        System.out.println("git add -A; git commit -m 'somethin'; git push;");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFavoriteLanguage() {
        return favoriteLanguage;
    }

    public void setFavoriteLanguage(String favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;
    }

    public int getFirstYearAsDeveloper() {
        return firstYearAsDeveloper;
    }

    public void setFirstYearAsDeveloper(int firstYearAsDeveloper) {
        this.firstYearAsDeveloper = firstYearAsDeveloper;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "name='" + name + '\'' +
                ", favoriteLanguage='" + favoriteLanguage + '\'' +
                ", firstYearAsDeveloper=" + firstYearAsDeveloper +
                '}';
    }
}