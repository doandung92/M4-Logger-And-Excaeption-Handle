package com.codegym.concern;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;

@Aspect
public class Logger {

    @AfterReturning(pointcut = "within(com.codegym.controller.*)", returning = "object")
    public void logController(JoinPoint joinPoint, Object object){
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.printf("Log: %s.%s%s . Object: %s\n", className, method, args, object.hashCode());
    }
    @AfterReturning(pointcut = "within(com.codegym.service.*.*)", returning = "object")
    public void logService(JoinPoint joinPoint, Object object){
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.printf("Log: %s.%s%s . Object: %s\n", className, method, args, object.hashCode());
    }
    @AfterThrowing(pointcut = "execution(public * com.codegym.controller.*.*(..))", throwing = "e")
    public void logService(JoinPoint joinPoint, Exception e){
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.printf("Exception: %s.%s%s: %s\n", className, method, args, e.getMessage());
    }
}
