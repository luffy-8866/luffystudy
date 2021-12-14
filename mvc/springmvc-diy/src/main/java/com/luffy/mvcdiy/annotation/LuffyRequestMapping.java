package com.luffy.mvcdiy.annotation;

import java.lang.annotation.*;

@Documented
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LuffyRequestMapping {
    String value() default "";
}
