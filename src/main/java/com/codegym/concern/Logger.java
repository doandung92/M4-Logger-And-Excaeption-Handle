package com.codegym.concern;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;

@Aspect
public class Logger {

    @AfterReturning(pointcut = "within(com.codegym.controller.*)", returning = "object")
    public void log(JoinPoint joinPoint, Object object){
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.printf("Log: %s.%s%s\n", className, method, args);
    }
}
