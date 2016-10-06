package com.mycompany.myapp.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class TestAspect {

    @Before("execution(* com.mycompany.myapp.service.ActivityService.test(..))")
    public void doSmth() {

    }
}
