package com.company.citywebservice.contoller;

import com.company.citywebservice.model.City;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class CityController {
//    private static int currentId = 1;
    private List<City> cityList = new ArrayList<>(Arrays.asList(
            new City("New York", "NY", 80000000, false),
            new City("Philadelphia", "PA", 700000, false),
            new City("Seattle", "WA", 1000000, false),
            new City("Olympia", "WA", 500000, true),
            new City("Las Vegas", "NV", 800000, false)
    ));

    @RequestMapping(value = "/city", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public City createRecord(@RequestBody @Valid City city) {
        cityList.add(city);
        return city;
    }
    @RequestMapping(value = "/city/{name}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteCityByName(@PathVariable String name) {

        for(int i = 0; i < cityList.size(); i++) {
            if(cityList.get(i).getName().toLowerCase().equals(name.toLowerCase())) {
                cityList.remove(i);
                break;
            }
        }
    }
    @RequestMapping(value = "/city", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<City> getAllCities() {
        return cityList;
    }
    @RequestMapping(value = "/city/{name}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public City getCityByName(@PathVariable String name) {
        City returnVal = null;
        for(int i = 0; i < cityList.size(); i++) {
            if(cityList.get(i).getName().toLowerCase().equals(name.toLowerCase())) {
                returnVal = cityList.get(i);
                break;
            }
        }
        return returnVal;
    }

}
