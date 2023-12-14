package com.challengefifteendays.basicapp.config;

import com.differentPackage.util.Coach;
import com.differentPackage.util.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Creating a custom bean; but why do we need it? In some situation when we are working with external third party packages it is not possible to lets say go their class implementation as annotate it as @Component, in those cases we can convert those classes as Beans using this method
@Configuration
public class sportsBeanConfig {
    @Bean ("aquatic") //custom bean id
    public Coach swimCoach(){ // this method name would be termed as the bean name
       return new SwimCoach();  //creating the instance of the class manually (the task which was done automatically before now we have to do it on our own)
    }
}
