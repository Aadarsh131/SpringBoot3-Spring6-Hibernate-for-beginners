package com.differentPackage.util;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary //to prioritize this component while passing as bean in setter/constructor injection
public class VolleyBallCoach implements Coach{
    public VolleyBallCoach(){
        System.out.println("I am from "+ getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout()
    {
        return "for volley run for 10 mins";
    }
}
