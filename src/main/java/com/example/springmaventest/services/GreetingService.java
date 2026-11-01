package com.example.springmaventest.services;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class GreetingService {
    private final HashSet<String> languages = new HashSet<>(Set.of("sv","en"));

    public String GetGreeting(String language){
        return switch (language) {
            case "sv" -> "Hej världen!";
            case "en" -> "Hello world!";
            default -> "Unknown language";
        };
    }

    public Set<String> GetGreetings() {
        return languages;
    }
}
