package com.sap.cf.sample.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class FlowLoggerAspect {

    @Before("@annotation(com.sap.cf.sample.annotations.FlowLogger)")
    public void logMethodExecution(JoinPoint joinPoint) {
        log.info("Executing method {} ", joinPoint.getSignature());
    }

}
