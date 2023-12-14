package com.differentPackage.util;

import com.differentPackage.util.Coach;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//beans are by default of singleton types, meaning all instance of this bean will point to same memory location
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) //changing it to prototype scope means now each instance will be uniquely created in memory

public class CricketCoach implements Coach {
    public CricketCoach(){
        System.out.println("I am from "+ getClass().getSimpleName());
    }

    /* using @PostConstruct and @PreDestroy we can handle what to do when the bean starts and when it stops */
    //init method
    @PostConstruct
    public void doStartupStuff(){
        System.out.println("Starting up the bean: " + getClass().getSimpleName());
    }

    //destroy methods
    @PreDestroy
    public void doCleanupStuff(){
        System.out.println("cleaning the beans: " + getClass().getSimpleName());
    }


    @Override
    public String getDailyWorkout() {
        return "15 mins of running";
    }
}
