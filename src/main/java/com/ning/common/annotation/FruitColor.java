package com.ning.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 水果颜色注解
 * 网络来源DEMO
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitColor {

	/** 颜色枚举 */
	public enum Color{RED,BLUE,YELLOW,GREEN};
	
	/**
	 * 颜色属性
	 * @return
	 */
	Color fruitColor() default Color.GREEN;
	
}
