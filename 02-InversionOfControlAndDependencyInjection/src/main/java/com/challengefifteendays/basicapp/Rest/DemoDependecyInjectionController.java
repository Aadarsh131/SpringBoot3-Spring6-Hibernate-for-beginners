package com.challengefifteendays.basicapp.Rest;

import com.differentPackage.util.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoDependecyInjectionController {
    //NOTE: there are Field injection which are not recommended by Spring team to use, as it make the unit testing harder
    private Coach theCoach;
    private Coach anotherCoach;

    /*
    //constructor injection (for required dependencies)
   @Autowired //if there is only one constructor we can skip the @Autowired
    public DemoDependecyInjectionController(@Qualifier("aquatic") Coach theCoach) {
        System.out.println("Testing this bean for lazy initialization");
        this.theCoach = theCoach;
    }
    */

//    setter injection (for optional dependencies)
//    it need not be just a setter method, it can be any method
    @Autowired
    public void setCoach(@Qualifier("cricketCoach") Coach theCoach, @Qualifier("cricketCoach") Coach anotherCoach){ //@Qualifier to prioritize the CricketCoach component
      // NOTE: "cricketCoach" is termed as a bean Id, and first character of the class name is lowercase
        this.theCoach = theCoach;
        this.anotherCoach = anotherCoach;
    }

    @GetMapping("/getDailyWorkout")
    public String getDailyWorkoutDetails(){
       return theCoach.getDailyWorkout();
    }

    @GetMapping("/checkBeanScope")
    public String beanScope(){
       return "Checking bean scope(using memory location): " + (theCoach == anotherCoach); // if true, means the memory location is same, i.e, singleton scoped, false otherwise
    }
}

/* Behind the scenees

Case 1: constructor injection-

CricketCoach theCoach = new CricketCoach();
DemoDependencyInjectionController b = new DemoDependencyInjectionController(theCoach);
-----------------------------------------------------------------------------------------
Case 2: setter injection-

CricketCoach theCoach = new CricketCoach();
DemoDependencyInjectionController b = new DemoDependencyInjectionController();
b.setCoach(theCoach);
 */