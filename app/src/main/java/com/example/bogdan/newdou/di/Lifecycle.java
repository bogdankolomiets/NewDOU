package com.example.bogdan.newdou.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 23.05.16
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface Lifecycle {

    String value() default "";
}
