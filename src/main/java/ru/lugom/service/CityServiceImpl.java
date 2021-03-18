package ru.lugom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.lugom.model.City;
import ru.lugom.repository.CityRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityRepository cityRepository;

    @Override
    @Transactional
    public List<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    @Transactional
    public void delete(long id) {
        cityRepository.delete(cityRepository.findById(id).get());
    }

    @Override
    @Transactional
    public City add(City city) {
        return cityRepository.save(city);
    }

    @Override
    @Transactional
    public City edit(City city) {
        if (city.getName().trim().isEmpty() || city.getInfo().trim().isEmpty())
            throw new RuntimeException();
        return cityRepository.save(city);
    }

    @Override
    @Transactional
    public Optional<City> findByName(String name) {
        return cityRepository.findByName(name);
    }
}
