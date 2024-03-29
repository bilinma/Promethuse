package com.bilin.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
 
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PrometheusMetrics {
    /**
     *  默认为空,程序使用method signature作为Metric name
     *  如果name有设置值,使用name作为Metric name
     * @return
     */
    String name() default "";
}
