package com.example.springmaventest.controllers;

import com.example.springmaventest.services.GreetingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("api/v1/greetings")
public class GreetingsController {
    private final GreetingService greetingService;

    public record Message(String body, String language) {};

    public GreetingsController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping()
    public Set<String> GetGreetings() {
        return greetingService.GetGreetings();
    }

    @GetMapping("/{language}")
    public Message SayHello(@PathVariable String language) {
        var greeting = greetingService.GetGreeting(language);
        return new Message(greeting, language);
    }
}
