package com.ning.common.annotation.test;

import com.ning.common.annotation.FruitColor;
import com.ning.common.annotation.FruitColor.Color;
import com.ning.common.annotation.FruitName;
import com.ning.common.annotation.FruitProvider;

public class Fruit {
	
	@FruitName("Apple")
	private String fruitName;
	
	@FruitColor(fruitColor=Color.RED)
	private String fruitColor;
	
	@FruitProvider(id=1,name="陕西红富士集团",address="陕西省西安市延安路89号红富士大厦")
    private String fruitProvider;

	public String getFruitProvider() {
		return fruitProvider;
	}

	public void setFruitProvider(String fruitProvider) {
		this.fruitProvider = fruitProvider;
	}

	public String getFruitName() {
		return fruitName;
	}

	public void setFruitName(String fruitName) {
		this.fruitName = fruitName;
	}

	public String getFruitColor() {
		return fruitColor;
	}

	public void setFruitColor(String fruitColor) {
		this.fruitColor = fruitColor;
	}

	public void displayName(){
		System.out.println("这是一个"+this.fruitColor+"颜色的"+this.fruitName);
	}
	
}
