package com.challengefifteendays.basicapp.Rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LearnRestController {
    @Value("${developer.name}") //attaching my custom property
    private String name;

    @GetMapping("/")
    public String sayHello(){
        return name;
    }
}
