package ua.iovsa.citiesgame.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.iovsa.citiesgame.model.City;

public interface CityRepository extends JpaRepository<City, Integer> {
}
