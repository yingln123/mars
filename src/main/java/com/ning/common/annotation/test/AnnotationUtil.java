package com.ning.common.annotation.test;

import java.lang.reflect.Field;

import com.ning.common.annotation.FruitColor;
import com.ning.common.annotation.FruitName;
import com.ning.common.annotation.FruitProvider;

public class AnnotationUtil {

	
	public static void getFruitInfo(Class<?> classes){
		Field[] fields = classes.getDeclaredFields();
		
		for(Field field : fields){
			
			if(field.isAnnotationPresent(FruitName.class)){
				FruitName fruitName = field.getAnnotation(FruitName.class);
				System.out.println("水果名称："+fruitName.value());
			}else if(field.isAnnotationPresent(FruitColor.class)){
				FruitColor fruitColor = field.getAnnotation(FruitColor.class);
				System.out.println("水果颜色："+fruitColor.toString());
				System.out.println("水果颜色："+fruitColor.fruitColor().toString());
			}else if(field.isAnnotationPresent(FruitProvider.class)){
				FruitProvider fruitProvider = field.getAnnotation(FruitProvider.class);
				System.out.println(fruitProvider.toString());
				System.out.println("供应商的Id : "+fruitProvider.id()+" 供应商名称 ："+fruitProvider.name()+" 供应商地址："+fruitProvider.address());
			}
		}
	} 
	
	
	public static void main(String[] args) {
		getFruitInfo(Fruit.class);
	}
}
