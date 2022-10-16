package com.coompany.CarLotJPA.repository;

import com.coompany.CarLotJPA.dto.CarLot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarLotRepository extends JpaRepository<CarLot, Integer> {

    public List<CarLot> findByMakeAndColor(String make, String color);

    public List<CarLot> findByMake(String make);
    public List<CarLot> findByColor(String color);

}
