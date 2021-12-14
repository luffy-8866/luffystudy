package com.luffy.mvcdiy.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LuffyAutowired {
    String value() default "";
}
