package com.xiaolc.mvcframework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: lc
 * @Date: 2020/4/20 19:19
 */

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Deprecated
public @interface GPRepuestParam {
    String value() default "";
}
