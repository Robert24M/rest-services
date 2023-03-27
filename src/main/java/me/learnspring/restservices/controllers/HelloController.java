package me.learnspring.restservices.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class HelloController {

    @GetMapping("/hello")
//    @ResponseBody
    public String hello() {
        return "Hello!";
    }

    @PostMapping("/hello")
    public String hello(@RequestParam String... name) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hello");

        Arrays.asList(name).forEach(s -> stringBuilder.append(", ").append(s));
        stringBuilder.append("!");
        return stringBuilder.toString();
    }
}
