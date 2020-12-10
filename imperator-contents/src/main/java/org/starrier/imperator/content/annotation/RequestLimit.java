package org.starrier.imperator.content.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 请求限制的自定义注解
 *
 * @author Starrier
 * @date 2020/11/21
 */
@Documented
@Inherited
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestLimit {

    /**
     * 在 second 秒内，最大只能请求 maxCount 次
     */
    int second() default 1;

    int maxCount() default 1;
}
