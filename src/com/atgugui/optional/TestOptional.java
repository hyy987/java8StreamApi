package com.atgugui.optional;

import java.util.Optional;

import com.bjsxt.java8.Employee;
import com.bjsxt.java8.Employee.Status;

public class TestOptional {

	public static void main(String[] args) {
//		test1();
//		test2();
//		test3();
//		test4();
		test5();
	}

	/*
	 * Optional容器类的常用方法： Optional.of(T t):创建一个Optional实例
	 * Optional.empty():创建一个空的Optional实例 Optional.ofNullable(T
	 * t):若t不为null，创建Optional实例，否则创建空实例 isPresent():是否包含值 op.orElse(T
	 * t):如果调用对象包含值，返回该值，否则返回t op.orElseGet(Supplier s):如果调用对象包含值，返回该值，否则返回s获取的值
	 *
	 * 
	 */

	public static void test1() {
		Optional<Employee> op = Optional.of(null);
		System.out.println(op.get());
	}

	public static void test2() {
		Optional<Employee> op = Optional.empty();
		System.out.println(op.get());
	}

	public static void test3() {
		Optional<Employee> op = Optional.ofNullable(null);

//		if(op.isPresent()) {
//			System.out.println(op.get());
//		}
//		Employee employee = op.orElse(new Employee("张三",18,888.88,Status.VOCATION));
//		System.out.println(employee);
		Employee employee = op.orElseGet(() -> new Employee());
		System.out.println(employee);
	}

	public static void test4() {
		Optional<Employee> op = Optional.ofNullable(new Employee("张三", 18, 888.88, Status.VOCATION));

//		Optional<String> map = op.map(Employee::getName);
//		System.out.println(map.get());
		Optional<String> flatMap = op.flatMap((e) -> Optional.of(e.getName()));
		System.out.println(flatMap.get());
	}

	// 例题
	public static void test5() {
		/*Man man = new Man();
		String name = getGodName(man);
		System.out.println(name);*/
		Optional<NewMan> op = Optional.ofNullable(null);
		String godName2 = getGodName2(op);
		System.out.println(godName2);
	}

	public static String getGodName2(Optional<NewMan> man) {
		return man.orElse(new NewMan())
				.getGod()
				.orElse(new Godness("苍老师"))
				.getName();
	}
	public static String getGodName(Man man) {
		if (null != man) {
			Godness gn = man.getGodness();
			if (null != gn) {
				return gn.getName();
			}
		}
		return "苍老师";
	}
}
