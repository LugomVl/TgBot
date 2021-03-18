package ru.lugom.service;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import ru.lugom.model.City;
import ru.lugom.repository.CityRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class CityServiceImplTest {
    @Autowired
    private CityService cityService;

    @MockBean
    private CityRepository cityRepository;

    @Before
    public void setUp() {
        City one = new City(1l, "Minsk", "The capital of Belarus");
        City two = new City(2l, "Moscow", "The capital of Russia");
        City two2 = new City(2l, "Leningrad", "The capital of Russia");
        City three = new City(3l, "Kiev", "The capital of Ukraine");
        City four = new City(4l, "Riga", "The capital of Latvia");
        List<City> cities = Arrays.asList(two, three, four);
        Mockito.when(cityRepository.findByName("Minsk"))
                .thenReturn(Optional.of(one));
        Mockito.when(cityRepository.findByName("Riga"))
                .thenReturn(null);
        Mockito.when(cityRepository.findByName("Moscow"))
                .thenReturn(Optional.of(two));
        Mockito.when(cityRepository.findById(1l))
                .thenReturn(Optional.of(one));
        Mockito.when(cityRepository.findById(4l))
                .thenReturn(Optional.of(four));
        Mockito.when(cityRepository.findByName("Kiev"))
                .thenReturn(Optional.of(three));
        Mockito.doNothing().when(cityRepository).delete(one);
        Mockito.when(cityRepository.save(two))
                .thenReturn(two2);
        Mockito.when(cityRepository.findAll())
                .thenReturn(cities);
    }

    @Test
    public void findAll() {
        List<City> list = cityService.findAll();
        assertEquals(3, list.size());
    }

    @Test
    public void delete() {
        City city = new City(4l, "Riga", "The capital of Latvia");
        cityService.delete(city.getId());
        Optional<City> city1 = cityService.findByName("Riga");
        assertNull(city1);
    }

    @Test
    public void add() {
        City four = new City(4l, "Riga", "The capital of Latvia");
        Mockito.when(cityRepository.save(any(City.class)))
                .thenReturn(four);
        City test = new City(0l, "Riga", "The capital of Latvia");
        test = cityService.add(test);
        assertNotNull(test);
    }

    @Test
    public void edit() {
        Optional<City> optional = cityService.findByName("Moscow");
        City city = optional.orElseThrow(RuntimeException::new);
        city.setName("Leningrad");
        city = cityService.edit(city);
        assertEquals("Leningrad", city.getName());
    }

    @Test
    public void findByName() {
        Optional<City> city = cityService.findByName("Minsk");
        assertTrue(city.isPresent());
    }
}
