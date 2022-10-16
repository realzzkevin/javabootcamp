package com.coompany.CarLotJPA.controller;

import com.coompany.CarLotJPA.dto.CarLot;
import com.coompany.CarLotJPA.repository.CarLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CarLotController {
    @Autowired
    private CarLotRepository carLotRepository;

    @GetMapping(value = "/cars")
    @ResponseStatus(HttpStatus.OK)
    public List<CarLot> getAllCars() {
        return carLotRepository.findAll();
    }

    @PostMapping(value = "/cars")
    @ResponseStatus(HttpStatus.CREATED)
    public CarLot createfNewCar(@RequestBody CarLot car) {
        return carLotRepository.save(car);
    }

    @DeleteMapping(value = "/cars/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void deleteACarById(@PathVariable Integer id) {
        carLotRepository.deleteById(id);
    }

    @GetMapping(value = "/cars/makeandcolor")
    @ResponseStatus(HttpStatus.OK)
    public List<CarLot> getAllCarsByMakeOrColor(@RequestParam(required = false) String make, @RequestParam(required = false) String color) {
        List<CarLot> cars = new ArrayList<>();
        if(make != null && color != null  ) {
            cars = carLotRepository.findByMakeAndColor(make, color);
        } else if (make != null) {
            cars = carLotRepository.findByMake(make);
        } else if(color != null) {
            cars = carLotRepository.findByColor(color);
        }

        return cars;
    }

    @GetMapping(value = "/car/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<CarLot> getACarById(@PathVariable Integer id) {
        return carLotRepository.findById(id);
    }

    @PutMapping(value = "/car")
    @ResponseStatus(HttpStatus.CREATED)
    public CarLot updateACar(@RequestBody CarLot car) {
        carLotRepository.save(car);
        return car;
    }


}
