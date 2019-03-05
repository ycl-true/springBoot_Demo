package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {
    private final  Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.example.demo.controller.BootController.*(..))")
    public void log(){
        // 此处不会执行
    }
    @Before("log()")
    public void doBefore(JoinPoint jp){
//        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest hsr = sra.getRequest();
//        // url
//        logger.info("URL={}",hsr.getRequestURL());
//        // method
//        logger.info("method={}",hsr.getMethod());
//        // ip
//        logger.info("IP={}",hsr.getRemoteAddr());
//        // 类方法
//        logger.info("类方法={}",jp.getSignature().getDeclaringTypeName() + ":" + jp.getSignature().getName());
//        // 参数
//        logger.info("参数={}", jp.getArgs());
    }

    @AfterReturning(pointcut = "log()", returning = "object")
    public void doAfter(Object object){
        logger.info("返回的参数={}", object);
    }
}

