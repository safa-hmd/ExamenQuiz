package com.example.quiz.Config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggingAspect {
    @Before("execution(* com.example.quiz.ServiceImpl.*.ajouter*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println(
                "Début méthode " + joinPoint.getSignature().getName()
        );
    }

//    @After("execution(* com.example.quiz.ServiceImpl.*.*(..))")
//    public void logMethodAfter(JoinPoint joinPoint) {
//        String name = joinPoint.getSignature().getName();
//        log.info("out of method After " + name + " : ");
//    }
//
//    @AfterThrowing("execution(* com.example.quiz.ServiceImpl.*.*(..))")
//    public void logMethodAfterThrowing(JoinPoint joinPoint) {
//        String name = joinPoint.getSignature().getName();
//        log.info("out of method AfterThrowing " + name + " : ");
//    }
//    @AfterReturning("execution(* com.example.quiz.ServiceImpl.*.*(..))")
//    public void logMethodAfterReturning(JoinPoint joinPoint) {
//        String name = joinPoint.getSignature().getName();
//        log.info("out of method AfterReturning " + name + " : ");
//    }


}
