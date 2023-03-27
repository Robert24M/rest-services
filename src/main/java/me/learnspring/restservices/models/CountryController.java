package me.learnspring.restservices.models;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CountryController {

    @GetMapping("/romania")
    public Country romania() {
        return new Country("Romania", 20);
    }

    @GetMapping("/countries")
    public List<Country> countries() {
        return Arrays.asList(new Country("Germany", 83),
                new Country("Serbia", 6));
    }

    @GetMapping("/france")
    public ResponseEntity<Country> france() {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("continent","Europe")
                .header("capital", "Paris")
                .header("what I know","oui")
                .body(new Country("France", 67));
    }
}
