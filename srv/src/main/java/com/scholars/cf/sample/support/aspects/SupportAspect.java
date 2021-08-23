package com.scholars.cf.sample.support.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
@Slf4j
public class SupportAspect {

    public static Map<String, Object> cache = new HashMap<>();
    @Value("${cache.enabled}")
    boolean enableCache;

    @Before("@annotation(com.scholars.cf.sample.support.annotations.FlowLogger)")
    public void logMethodExecution(JoinPoint joinPoint) {
        log.info("Executing method {} ", joinPoint.getSignature());
    }

    @Around("@annotation(com.scholars.cf.sample.support.annotations.Cached)")
    public Object cachedMethodCall(ProceedingJoinPoint joinPoint) throws Throwable {
        if (!enableCache)
            return joinPoint.proceed();

        String cacheKey = joinPoint.toShortString().replace("..", Arrays.toString(joinPoint.getArgs()));
        log.info("Checking in cache {}", cacheKey);
        if (!cache.containsKey(cacheKey)) {
            Object result = joinPoint.proceed();
            if (result != null) {
                log.info("Caching result");
                cache.put(cacheKey, result);
            }
        } else {
            log.info("Returned cached result");
        }
        return cache.get(cacheKey);
    }

}
