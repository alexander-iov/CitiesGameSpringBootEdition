package ua.iovsa.citiesgame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ua.iovsa.citiesgame.model.City;
import ua.iovsa.citiesgame.service.CitiesService;

@Controller
public class CitiesController {

    private final CitiesService citiesService;
    private static int count = 1;

    @Autowired
    public CitiesController(CitiesService citiesService) {
        this.citiesService = citiesService;
    }

    @GetMapping("/new-game")
    public String newGame(Model model) {
        City city = citiesService.randomCity();
        System.out.println(city);
        model.addAttribute("randomCity", city);
        model.addAttribute("city", new City());
        return "/new-game";
    }

    @PostMapping("/city")
    public String city(@ModelAttribute("city") City city, Model model) {
        citiesService.addCity(city);
        System.out.println(city);
        City newCity = citiesService.getNextCity(city.getName());
        System.out.println(newCity);
        count++;
        if (newCity != null) {
            model.addAttribute("newCity", newCity);
            model.addAttribute("count", count);
            model.addAttribute("city", new City());
            return "/city";
        } else {
            model.addAttribute("count", count);
            return "/win";
        }
    }
}
