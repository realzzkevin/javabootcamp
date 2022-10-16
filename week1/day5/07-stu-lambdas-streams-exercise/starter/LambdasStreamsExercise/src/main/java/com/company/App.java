package com.company;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {
        try {
            List<Television> tvs = FileIO.getTelevisions("televisions.csv");

            tvs
                    .stream()
                    .filter( tv -> tv.getScreenSize() > 60)
                    .forEach(tv -> {
                                System.out.println(tv.getBrand());
                    });
            Map<String, List<Television>> groupedTv =
                tvs
                        .stream()
                        .collect(Collectors.groupingBy(tv -> tv.getBrand()));

            Double averageScreenSize = tvs
                    .stream()
                    .mapToInt(tv -> tv.getScreenSize())
                    .average()
                    .getAsDouble();

            OptionalInt maxScreen =
                    tvs
                            .stream()
                            .mapToInt( tv -> tv.getScreenSize())
                            .max();
            List<Television> sortedTvs =
                    tvs
                            .stream()
                            .sorted((a, b) ->{
                                return  a.getScreenSize() - b.getScreenSize();
                            })
                            .collect(Collectors.toList());

            for ( Television tv: sortedTvs
                 ) {


            }


        } catch (Exception ex) {

        }
        // CODE GOES HERE
    }
}
