package ru.kataproject.p_sm_airlines_1.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@Api("MainController")
public class MainController {

    @GetMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }
}
