package ru.lugom.service;
import java.util.List;
import java.util.Optional;

import ru.lugom.model.City;

public interface CityService {
    List<City> findAll();
    void delete(long id);
    City add(City city);
    City edit(City city);
    Optional<City> findByName(String name);
}
