package com.bjsxt.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.bjsxt.java8.Employee.Status;

public class TestStreamAPI {

	public static void main(String[] args) {

		test1();
		
	}

	static List<Employee> employees = Arrays.asList(
			new Employee("张三", 18, 9999.99, Status.BUSY),
			new Employee("李四", 38, 5555.99, Status.FREE), 
			new Employee("王五", 58, 3333.99, Status.VOCATION),
			new Employee("赵六", 16, 2222.99, Status.FREE),
			new Employee("赵六", 16, 2222.99, Status.FREE),
			new Employee("沈七", 8, 8888.99, Status.VOCATION));

	/*
	 1.给定一个数字列表，如何返回一个由每个数的平方构成的列表
	 */
	public static void test1() {
		Integer[] ins = new Integer[] {1,2,3,4,5};
		List<Integer> list = Arrays.stream(ins)
		.map((x)->x*x)
		.collect(Collectors.toList());
		System.out.println(list);

	}

	/**
	 用map和reduce方法数一数流中有多少个Employee 
	 
	 */
	public static void test2() {

		Optional<Integer> r = employees.stream()
		.map((e)->1)
		.reduce(Integer::sum);
		System.out.println(r.get());
	}

	public static void test3() {
	}

	public static void test4() {
	}

	public static void test5() {
	}

	public static void test6() {
	}

	public static void test7() {
	}

	public static void test8() {
	}
}
