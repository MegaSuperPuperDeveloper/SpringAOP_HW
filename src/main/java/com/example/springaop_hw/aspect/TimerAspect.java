package com.example.springaop_hw.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Slf4j
@Component
@Aspect
public class TimerAspect {

    @Pointcut("@annotation(com.example.springaop_hw.aspect.Timer)")
    public void methodTimer() {}

    @Pointcut("within(@com.example.springaop_hw.aspect.Timer *)")
    public void classTimer() {}

    @Around("methodTimer() || classTimer()")
    public Object around(ProceedingJoinPoint joinPoint) {
        try {
            BigDecimal start = new BigDecimal(System.currentTimeMillis());
            Object result = joinPoint.proceed();
            BigDecimal end = new BigDecimal(System.currentTimeMillis());

            BigDecimal res = new BigDecimal(String.valueOf(end.subtract(start).divide(new BigDecimal(1000))));
            log.info("{} - {} #({})", joinPoint.getTarget().getClass(), joinPoint.getSignature().getName(), res);
            return result;
        } catch (Throwable e) {
            log.error("Something went wrong");
            throw new RuntimeException(e);
        }
    }

}