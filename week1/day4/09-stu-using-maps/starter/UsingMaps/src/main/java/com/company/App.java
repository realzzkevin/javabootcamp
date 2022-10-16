package com.company;

import java.util.*;

public class App {
    public void printKeys(Map< String, String> myMap) {
        Set<String> allKeys = myMap.keySet();
        for (String key : allKeys) {
            System.out.println(key);
        }
    }

    public void printValues(Map<String, String> myMap) {
//        Collection<String> allValues = myMap.values();
//        for (String values : allValues) {
//            System.out.println(values);
//        }
        Set<String> allKeys = myMap.keySet();
        for (String key : allKeys) {
            System.out.println(myMap.get(key));
        }
    }

    public void printKeysAndValues(Map<String, String> myMap) {
        Set<Map.Entry<String, String>> allKeysAndValue = myMap.entrySet();
        for (Map.Entry<String, String> item : allKeysAndValue) {
            System.out.println(item.getKey() + ": " +item.getValue());
        }
    }

    public Map<String, Integer> mapFun (Map<String, Integer> myMap) {

        myMap.put("Ford Explorer", 2012);
        myMap.put("Smart Fortwo", 2013);
        myMap.remove("Jeep Wrangler");
        return myMap;
    }

    public Map<String, List<Car>> listCars (List<Car> cars) {
        List<Car> toyotaList = new ArrayList<Car>();
        List<Car> fordList = new ArrayList<Car>();
        List<Car> hondaList = new ArrayList<Car>();

        for(Car car: cars) {
            switch (car.getMake()) {
                case "Toyota":
                    toyotaList.add(car);
                    break;
                case "Ford":
                    fordList.add(car);
                    break;
                case "Honda":
                    hondaList.add(car);
            }
        }

        HashMap<String, List<Car>> allCars = new HashMap<String, List<Car>>();
        allCars.put("Toyota", toyotaList);
        allCars.put("Ford", fordList);
        allCars.put("Honda", hondaList);
        return allCars;
    }
}
