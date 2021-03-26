package ua.iovsa.citiesgame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
        model.addAttribute("city", citiesService.randomCity());
        return "/new-game";
    }
}
