package com.yeow.spring.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author Yeow Kin Ren
 *
 */
//AOP
@Aspect
//Configuration
@Configuration
public class AspectConfiguration {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// What kind of method calls I would intercept
	// execution(* PACKAGE.*.*(..))
	// Weaving & Weaver
	@Before("execution(* com.yeow.spring.springaop.*.*.*(..))")
	public void before(JoinPoint joinPoint) {
		// Advice
		logger.info("**Check for user access ");
		logger.info("**Allowed execution for {}", joinPoint);
	}

	@After(value = "execution(* com.yeow.spring.springaop.*.*.*(..))")
	public void after(JoinPoint joinPoint) {
		logger.info("**After execution of {}", joinPoint);
	}

	@Around("@annotation(com.yeow.spring.springaop.aspect.TrackTime)")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();

		Object returnProceed = joinPoint.proceed();

		long timeTaken = System.currentTimeMillis() - startTime;
		logger.info("Time Taken by {} is {}", joinPoint, timeTaken);

		return returnProceed;
	}

	@Pointcut("within(com.yeow.spring.springaop.data..*)")
	public void dataLayerExecutionWithWithin() {
	}

	@AfterReturning(value = "com.yeow.spring.springaop.aspect.AspectConfiguration.dataLayerExecutionWithWithin()", returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		logger.info("##{} returned with value {}", joinPoint, result);
	}

}