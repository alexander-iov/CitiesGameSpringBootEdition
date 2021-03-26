package ua.iovsa.citiesgame.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.iovsa.citiesgame.model.City;
import ua.iovsa.citiesgame.repository.CityRepository;

import java.util.Random;

@Service
public class CitiesService {

    private final CityRepository cityRepository;

    @Autowired
    public CitiesService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public City randomCity() {
        Random random = new Random();
        int randomId = random.nextInt((int) cityRepository.count()) + 1;
        return cityRepository.getOne(randomId);
    }

}
