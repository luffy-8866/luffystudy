package com.luffy.mvcdiy.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface LuffyController {
    String value() default "";
}
