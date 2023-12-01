package tn.etudedecas.stationdeski.Aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LogingAspect {
@After("execution(* tn.etudedecas.stationdeski.Services.*.add*(..))")
public void logMethodEntry(JoinPoint joinPoint){
    String name=joinPoint.getSignature().getName();
    log.info("Success "+name+":");
}
}
