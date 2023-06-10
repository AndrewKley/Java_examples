package com.example.controllers;

import com.example.DTO.CountryDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {
    //  curl -v http://localhost:8080/france
    @GetMapping("/france")
    public CountryDTO france() {
        CountryDTO france = CountryDTO.of("France", 101);
        return  france;
    }
}
