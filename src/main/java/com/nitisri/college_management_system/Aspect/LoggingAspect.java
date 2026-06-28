package com.nitisri.college_management_system.Aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.nitisri.college_management_system.Service.*.*(..))")
    public void beforeMethod(JoinPoint joinPoint){

        System.out.println("=================================");
        System.out.println("Class : " + joinPoint.getTarget().getClass().getSimpleName());
        System.out.println("Method: " + joinPoint.getSignature().getName());
        System.out.println("=================================");
    }

    @After("execution(* com.nitisri.college_management_system.Service.*.*(..))")
    public void afterMethod(JoinPoint joinPoint){

        System.out.println("=================================");
        System.out.println("Leaving Method : "
                + joinPoint.getSignature().getName());
        System.out.println("=================================");
    }

    @AfterReturning(
            pointcut = "execution(* com.nitisri.college_management_system.Service.*.*(..))",
            returning = "result")
    public void afterReturningMethod(JoinPoint joinPoint, Object result) {

        System.out.println("=================================");
        System.out.println("Method Executed Successfully");
        System.out.println("Method : " + joinPoint.getSignature().getName());
        System.out.println("Returned Value : " + result);
        System.out.println("=================================");
    }

    @AfterThrowing(
            pointcut = "execution(* com.nitisri.college_management_system.Service.*.*(..))",
            throwing = "exception")
    public void afterThrowingMethod(JoinPoint joinPoint, Exception exception) {

        System.out.println("=================================");
        System.out.println("Exception occurred!");
        System.out.println("Class  : " + joinPoint.getTarget().getClass().getSimpleName());
        System.out.println("Method : " + joinPoint.getSignature().getName());
        System.out.println("Reason : " + exception.getMessage());
        System.out.println("=================================");
    }

    @Around("execution(* com.nitisri.college_management_system.Service.*.*(..))")
    public Object aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {

        long startTime = System.currentTimeMillis();

        System.out.println("=================================");
        System.out.println("Started Method : "
                + joinPoint.getSignature().getName());

        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis();

        System.out.println("Execution Time : "
                + (endTime - startTime) + " ms");

        System.out.println("Completed Method : "
                + joinPoint.getSignature().getName());

        System.out.println("=================================");

        return result;
    }
}