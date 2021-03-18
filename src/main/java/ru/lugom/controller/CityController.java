package ru.lugom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.lugom.model.City;
import ru.lugom.service.CityService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CityController {
    @Autowired
    CityService cityService;

    @GetMapping
    List<City> findAll(){
        return cityService.findAll();
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable long id){
        cityService.delete(id);
    }

    @PutMapping
    public void edit(@RequestBody City city){
        cityService.edit(city);
    }

    @PostMapping
    public void add(@RequestBody City city){
        cityService.add(city);
    }
}
