package com.mcnc.usermanagement.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class SimpleAspect {
	
	private static final Logger LOG = LoggerFactory.getLogger(SimpleAspect.class);
	
	@Pointcut("execution(* com.mcnc.usermanagement.dao.*.*(..))")
	public void myPointCut() {}
	
	@Before("myPointCut()")
	public void before(JoinPoint jp) {
		LOG.debug("Before Advice");
	}
	
	@After("myPointCut()")
	public void after(JoinPoint jp) {
		LOG.debug("After Advice");
	}
	
	@AfterReturning(pointcut="myPointCut()", returning = "object")
	public void afterReturning(JoinPoint jp, Object object) {
		LOG.debug("After Returning Advice");
	}
	
//	@Around("myPointCut()")
//	public void around(JoinPoint jp) {
//		LOG.debug("Around Advice");
//	}
}
