package com.bjsxt.java8;

public interface MyInterface {

	default String getName() {
		return "嘻嘻嘻";
	}
	
	public static void show() {
		System.out.println("接口中静态方法");
	}
}
