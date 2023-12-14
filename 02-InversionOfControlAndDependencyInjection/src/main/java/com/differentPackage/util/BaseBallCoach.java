package com.differentPackage.util;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy //bean will not be created until there's a requirement, we can also set this on application.properties file
public class BaseBallCoach implements Coach{
    public BaseBallCoach() {
        System.out.println("I am from "+ getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout(){
        return "for baseball run atlest 30 mins";
    }
}
