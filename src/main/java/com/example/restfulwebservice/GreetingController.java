package com.example.restfulwebservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    public static final String template = "Hello, %s";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}

/*
 * @GetMapping - ensures that HTTP GET requests to /greeting are mapped to the
 * greeting method
 * 
 * Since there is a GetMapping annotation, conversely there is a PostMapping for
 * post
 * 
 * @RequestParam - binds the value of the query string parameter name into the
 * name parameter of greeting() method. If the name is absent during the
 * request, it will use the default value of world.
 */