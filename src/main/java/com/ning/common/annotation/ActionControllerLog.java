package com.ning.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 请求日志,如果有这个注解就保存访问路径、和阐述
 * @author Mf-CX05
 *
 */
@Target({ElementType.PARAMETER ,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ActionControllerLog {
    
    /** 动作的名称 */
    String action() default "";
    
    /** 是否保存请求的参数 */
    boolean isSaveRequestData() default false;
}
