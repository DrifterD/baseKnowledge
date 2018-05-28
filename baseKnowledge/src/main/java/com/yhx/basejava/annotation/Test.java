package com.yhx.basejava.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

/**
 * 1. 注解默认继承Annotation类，且不能实现接口和继承
 * 2. 注解属性类型必须是基础类型数据和响应的封装类
 *
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Test {
    String value() default "test";
    int count() default 2;
}
