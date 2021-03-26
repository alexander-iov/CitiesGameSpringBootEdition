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

    @Autowired
    public CitiesController(CitiesService citiesService) {
        this.citiesService = citiesService;
    }

    @GetMapping("/new-game")
    public String newGame(Model model) {
        model.addAttribute("randomCity", citiesService.randomCity());
        model.addAttribute("city", new City());
        return "/new-game";
    }

    @PostMapping("/city")
    public String city(@ModelAttribute("city") City city, Model model) {
        City newCity = citiesService.getNextCity(city.getName());
        if (newCity != null) {
            model.addAttribute("newCity", newCity);
            model.addAttribute("city", new City());
            return "/city";
        } else {
            return "/win";
        }
    }
}
