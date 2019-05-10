package com.atguigu.annotation;

import java.lang.reflect.Method;

public class TestAnnotation {

	// checker framework
	private Object obj = null;

	@MyAnnotation("Hello")
	@MyAnnotation("World")
	public void show(@MyAnnotation("abc") String s) {

	}

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		test1();
	}

	public static void test1() throws NoSuchMethodException, SecurityException {
		Class<TestAnnotation> clazz = TestAnnotation.class;
		Method m1 = clazz.getMethod("show");
		MyAnnotation[] mas = m1.getAnnotationsByType(MyAnnotation.class);
		for (MyAnnotation myAnnotation : mas) {
			System.out.println(myAnnotation.value());
		}

	}
}
