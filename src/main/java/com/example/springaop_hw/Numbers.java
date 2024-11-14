package com.example.springaop_hw;

import com.example.springaop_hw.aspects.aspectTimer.Timer;
import org.springframework.stereotype.Component;

@Component
public class Numbers {

    @Timer
    public void getAllNumbersOneToHundred() {
        for (int i = 1; i <= 10000; i++) {
            System.out.println(i);
        }
    }

}