# spring-aop

Basic Spring AOP (Aspect Oriented Programming)

## Maven Dependencies

```
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-aop</artifactId>
    </dependency>
</dependencies>
```


Notes
--------

## AOP Concepts and Terminology

**Aspect** - a modularization of a concern that cuts across multiple classes `@Aspect`

**Joinpoint** - method execution

**Pointcut** - a predicate that matches join points

**Advice** - action taken by an aspect at a particular join point

**Weaving** - linking aspects with other application types or objects to create an advised object

**Before advice**: Advice that executes before a join point, but which does not have the ability to prevent execution flow proceeding to the join point (unless it throws an exception).

`@Before("execution(* com.xyz.myapp.dao.*.*(..))")`

**After returning advice**: Advice to be executed after a join point completes normally: for example, if a method returns without throwing an exception.

`@AfterReturning("com.xyz.myapp.SystemArchitecture.dataAccessOperation()")`

**After throwing advice**: Advice to be executed if a method exits by throwing an exception.

`@AfterThrowing("com.xyz.myapp.SystemArchitecture.dataAccessOperation()")`

**After (finally) advice**: Advice to be executed regardless of the means by which a join point exits (normal or exceptional return).

`@After("com.xyz.myapp.SystemArchitecture.dataAccessOperation()")`

**Around advice**: Advice that surrounds a join point such as a method invocation. This is the most powerful kind of advice. Around advice can perform custom behavior before and after the method invocation. It is also responsible for choosing whether to proceed to the join point or to shortcut the advised method execution by returning its own return value or throwing an exception.

`@Around("com.xyz.myapp.SystemArchitecture.businessService()")`

### Declaring an aspect

`@Aspect`

> not possible to have aspects themselves be the target of advice from other aspects. The @Aspect annotation on a class marks it as an aspect, and hence excludes it from auto-proxying.

### Declaring a pointcut

`@Pointcut("execution(* transfer(..))")// the pointcut expression`

- execution - for matching method execution join points, this is the primary pointcut designator you will use when working with Spring AOP
- within - limits matching to join points within certain types (simply the execution of a method declared within a matching type when using Spring AOP)
- this - limits matching to join points (the execution of methods when using Spring AOP) where the bean reference (Spring AOP proxy) is an instance of the given type
- target - limits matching to join points (the execution of methods when using Spring AOP) where the target object (application object being proxied) is an instance of the given type
- args - limits matching to join points (the execution of methods when using Spring AOP) where the arguments are instances of the given types


Resource
--------

- [Aspect Oriented Programming with Spring](https://docs.spring.io/spring-framework/docs/2.5.x/reference/aop.html)


