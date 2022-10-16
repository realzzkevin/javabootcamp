package com.company;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        Map<String, City> cityMap = new HashMap<String, City>();

        cityMap.put("New York", new City("New York", 8654321));
        cityMap.put("California", new City("Los Angeles", 4563218));
        cityMap.put("Illinois", new City("Chicago", 2716520));
        cityMap.put("Colorado", new City("Denver", 704621));
        cityMap.put("Iowa", new City("Des Moines", 217521));
        cityMap.put("Georgia", new City("Atlanta", 486213));

        for(String state: cityMap.keySet()) {
            System.out.println(" State: " + state + " City: " + cityMap.get(state).getName() + " Population: " + cityMap.get(state).getPopulation() );
        }
        //Set<Map.Entry<String, City>> citySet = cityMap.entrySet();
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        for(Map.Entry<String, City> city: cityMap.entrySet()) {
            System.out.println(city.getKey() + " " + city.getValue().getName() + " " +city.getValue().getPopulation());
        }
    }
    public Map<String, City> filterByPopulation (Map<String, City> cities, int population) {
        Map<String, City> largeCity = new HashMap<String, City>();
        for(String state : cities.keySet() ) {
            if(cities.get(state).getPopulation() > population) {
                largeCity.put(state, cities.get(state));
            }
        }
        return largeCity;
    }

}
