package com.company;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class AppTest {
    App newApp;

    @Before
    public void setUp() throws Exception {
        newApp = new App();
    }

    @Test
    public void shouldFilterMapWithPopulation() {
        Map<String, City> cityMap = new HashMap<String, City>();

        cityMap.put("New York", new City("New York", 8654321));
        cityMap.put("California", new City("Los Angeles", 4563218));
        cityMap.put("Illinois", new City("Chicago", 2716520));
        cityMap.put("Colorado", new City("Denver", 704621));
        cityMap.put("Iowa", new City("Des Moines", 217521));
        cityMap.put("Georgia", new City("Atlanta", 486213));

        Map<String, City> filtedCities = newApp.filterByPopulation(cityMap, 999999);
        assertEquals(3, filtedCities.size());
        assertTrue(filtedCities.containsKey("New York"));
        assertTrue(filtedCities.containsKey("California"));
        assertTrue(filtedCities.containsKey("Illinois"));

        filtedCities = newApp.filterByPopulation(cityMap, 9999999);
        assertEquals(0, filtedCities.size());

        filtedCities = newApp.filterByPopulation(cityMap, 2716520);
        assertEquals(2, filtedCities.size());
        assertTrue(filtedCities.containsKey("New York"));
        assertTrue(filtedCities.containsKey("California"));

        filtedCities = newApp.filterByPopulation(cityMap, 0);
        assertEquals(cityMap.keySet(), filtedCities.keySet());

    }
}