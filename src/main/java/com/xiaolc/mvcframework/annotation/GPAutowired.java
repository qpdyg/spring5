package com.xiaolc.mvcframework.annotation;

import java.lang.annotation.*;

/**
 * @Author: lc
 * @Date: 2020/4/20 19:19
 */

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Deprecated
public @interface GPAutowired {
    String value() default "";
}
