package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    private FortuneService fortuneService;

    //define default constructor
    public TennisCoach() {
        System.out.println(">> TennisCoach: inside default constructor");
    }

    // define a setter method
    @Autowired
    public void setFortuneService(FortuneService theFortuneService){
        System.out.println(">> TennisCoach: inside setFortuneService");
        fortuneService = theFortuneService;
    }

    /*
    @Autowired // Spring scans for component that implements FortuneService interface... ex. HappyFortuneService
    public TennisCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }
    */

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
