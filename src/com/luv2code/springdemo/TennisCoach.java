package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class TennisCoach implements Coach {
    //@Autowired // field injection
    private FortuneService fortuneService;

    //define default constructor
    public TennisCoach() {
        System.out.println(">> TennisCoach: inside default constructor");
    }

    // define my init method
    //@PostConstruct
    public void doMyStartupStuff() {
        System.out.println(">> TennisCoach: inside doMyStartupStuff()");
    }

    // define my destroy method
    // @PreDestroy
    public void doMyCleanupStuff(){
        System.out.println(">> TennisCoach: inside doMyCleanupStuff()");
    }
    /*
    // method injection
    @Autowired
    public void doSomeCrazyStuff(FortuneService theFortuneService){
        System.out.println(">> TennisCoach: inside doSomeCrazyStuff method");
        fortuneService = theFortuneService;
    }
    */
    /*
    // define a setter method for injection
    @Autowired
    public void setFortuneService(FortuneService theFortuneService){
        System.out.println(">> TennisCoach: inside setFortuneService");
        fortuneService = theFortuneService;
    }
    */

    // constructor injection
    @Autowired // Spring scans for component that implements FortuneService interface... ex. HappyFortuneService
    public TennisCoach(@Qualifier("randomFortuneService") FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
