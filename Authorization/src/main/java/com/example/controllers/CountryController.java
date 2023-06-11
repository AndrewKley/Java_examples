package com.example.controllers;

import com.example.DTO.CountryDTO;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {
    // curl -v http://localhost:8080/france
    @GetMapping("/france")
    public CountryDTO france() {
        CountryDTO france = CountryDTO.of("France", 101);
        return  france;
    }

    // return response in HTTP response body
    @GetMapping("/all")
    public List<CountryDTO> countries() {
        CountryDTO france = CountryDTO.of("France", 89);
        CountryDTO spain = CountryDTO.of("Spain", 60);

        return List.of(france, spain);
    }

    // return response in HTTP response head
    @GetMapping("/head")
    public ResponseEntity<CountryDTO> franceAll() {
        CountryDTO france = CountryDTO.of("France", 89);

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("continent", "europe")
                .header("capital", "Paris")
                .header("favorite_food", "cheese and wine")
                .body(france);
    }
}
