package com.atguigu.pojo;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestTransaction {

	static List<Transaction> transactions=null;
	
	
	public static void before() {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		
		transactions= Arrays.asList(
				new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710),
				new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950)				
				);
	}
	//1.找出2011年发送的交易，并按照交易额排序（从低到高）
	//2.交易员都在哪些不同的城市工作过
	//3.查找所有来自剑桥的交易员，并按照姓名排序
	//4.返回所有交易员的 姓名字符串，按字母顺序排序
	//5.有没有交易员在米兰工作
	//6.打印生活在剑桥的交易员的所有交易额
	//7.所有交易中，最高的交易额是多少
	//8.找到交易额最小的交易
	public static void main(String[] args) {
//		test1();
//		test2();
		
//		test3();
//		test4();
//		test5();
//		test6();
//		test7();
		test8();
		
	}
	public static void test1() {
		before();
		Stream<Transaction> stream = transactions.stream()
		.filter((t)->new Integer(t.getYear()).equals(new Integer(2011)))
		.sorted((t1,t2)->Integer.compare(t1.getValue(), t2.getValue()));
		stream.forEach(System.out::println);
		
		transactions.stream()
		.filter((t)->new Integer(t.getYear()).equals(new Integer(2011)))
		.map(Transaction::getValue)
		.sorted(Integer::compare)
		.forEach(System.out::println);
		
	}
	public static void test2() {
		before();
		transactions.stream()
		.map((t)->t.getTrader().getCity())
		.distinct()
		.forEach(System.out::println);;
		
		
	}
	public static void test3() {
		before();
		transactions.stream()
		.filter((t)->t.getTrader().getCity().equals("Cambridge"))
		.sorted((t1,t2)->t1.getTrader().getCity().compareTo(t2.getTrader().getCity()))
		.forEach(System.out::println);
		System.out.println("*********************************************");
		transactions.stream()
		.filter((t)->t.getTrader().getCity().equals("Cambridge"))
		.map(Transaction::getTrader)
		.sorted((t1,t2)->t1.getName().compareTo(t2.getName()))
		.distinct()
		.forEach(System.out::println);
	}
	public static void test4() {
		before();
		transactions.stream()
		.map((t)->t.getTrader().getName())
		.sorted()
		.forEach(System.out::println);
		
		System.out.println("*********************************************");

		Optional<String> r = transactions.stream()
		.map((t)->t.getTrader().getName())
		.sorted()
		.reduce(String::concat);
		System.out.println(r.get());
		
		System.out.println("*********************************************");
		
	}
	public static void test5() {
		before();
		transactions.stream()
		.filter((t)->t.getTrader().getCity().equals("Milan"))
		.forEach(System.out::println);;
	}
	public static void test6() {
		before();
		IntSummaryStatistics sum = transactions.stream()
		.filter((t)->t.getTrader().getCity().equals("Cambridge"))
		.collect(Collectors.summarizingInt((t)->t.getValue()));
		System.out.println(sum.getSum());
	}
	public static void test7() {
		before();
		Optional<Transaction> max = transactions.stream()
		.max((t1,t2)->Integer.compare(t1.getValue(), t2.getValue()));
		System.out.println(max.get());
		
	}
	public static void test8() {
		before();
		Optional<Integer> min = transactions.stream()
		.map(Transaction::getValue)
		.min(Integer::compare);
		System.out.println(min.get());
	}
	public static void test9() {
		
	}
	
	
}
