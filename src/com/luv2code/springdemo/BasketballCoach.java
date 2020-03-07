package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component //uses default bean id "basketballCoach"
public class BasketballCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Shooty Hoops is fun";
    }

    @Override
    public String getDailyFortune() {
        return null;
    }
}
