package com.yeow.spring.springaop.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @author Yeow Kin Ren
 *
 */
@Target(ElementType.METHOD) //  Specifies the type of objects that the annotation can be applied to. (Method)
@Retention(RetentionPolicy.RUNTIME) // Specifies whether the annotation metadata can be accessed at runtime by the application (will determine whether the compiled bytecode is affected).
public @interface TrackTime { // @interface - define custom annotation  

}