package ua.iovsa.citiesgame.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.iovsa.citiesgame.model.City;
import ua.iovsa.citiesgame.repository.CityRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class CitiesService {

    private final CityRepository cityRepository;
    private static List<City> tempCity;

    @Autowired
    public CitiesService(CityRepository cityRepository) {
        tempCity = new ArrayList<>();
        this.cityRepository = cityRepository;
    }

    public City randomCity() {
        Random random = new Random();
        int randomId = random.nextInt((int) cityRepository.count()) + 1;
        City one = cityRepository.getOne(randomId);
        tempCity.add(one);
        return one;
    }

    public City getNextCity(String name) {
        String substring = name.substring(name.length() - 1);
        List<City> all = cityRepository.findAll();
        for (City c : all) {
            if (tempCity.contains(c)){
                continue;
            }
            if (c.getName().startsWith(substring.toUpperCase())){
                tempCity.add(c);
                return c;
            }
        }
        return null;
    }

}
