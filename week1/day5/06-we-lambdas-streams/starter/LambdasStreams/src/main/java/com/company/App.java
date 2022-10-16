package com.company;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {
        try {

            List<Motorcycle> bikes = MotoFileIO.getMotorcycles("motorcycles.csv");

            // Print the information for all Suzuki motorcycles in inventory
            String make = "Suzuki";
            System.out.println("All " + make + " motorcycles in inventory: ");
            bikes
                    .stream()
                    .filter(b -> b.getMake().equals(make))
                    .forEach(bike -> {
                        System.out.println("===============");
                        System.out.println("Make: " + bike.getMake());
                        System.out.println("Model: " + bike.getModel());
                        System.out.println("Color: " + bike.getColor());
                        System.out.println("Year: " + bike.getYear());
                        System.out.println("Displacement: " + bike.getDisplacement());
                        System.out.println("Horsepower: " + bike.getHorsepower());
                        System.out.println("Weight: " + bike.getWeight());
                    });

            // Print the information for all motorcycles the weigh less than 500 pounds

            // Rather than printing out the matching motorcycles, let's put them into a list

            // We can also group our motorcycles by Make.

            // Print the average horsepower of the motorcycles in inventory



        } catch (FileNotFoundException e) {
            System.out.println("Could not find CSV file: " + e.getMessage());
        }
    }

}
