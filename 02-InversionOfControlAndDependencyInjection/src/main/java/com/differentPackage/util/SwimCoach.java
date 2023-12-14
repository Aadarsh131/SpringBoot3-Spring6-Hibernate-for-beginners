package com.differentPackage.util;

//notice we are not annotating @Component, we can inject this class as a bean by making a custom bean using @Configuration and @Bean illustrated in
public class SwimCoach implements Coach{
    @Override
    public String getDailyWorkout(){
       return "swim for 3000m";
    }
}
