package com.bjsxt.java8;

public class SubClass /*extends MyClass*/ implements MyFun,MyInterface{

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return MyInterface.super.getName();
	}

}
