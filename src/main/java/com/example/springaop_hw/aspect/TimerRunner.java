package com.example.springaop_hw.aspect;

import com.example.springaop_hw.Numbers;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class TimerRunner {

    private final Numbers numbers;

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationStart() {
        numbers.getAllNumbersOneToHundred();
    }

}