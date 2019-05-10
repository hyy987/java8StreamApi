package com.bjsxt.java8;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class TestForkJoin {

	public static void main(String[] args) {
		test1();
//		test2();
	}
	
	public static void test1() {
		/*
		 * fork-join框架
		 */
		Instant start =Instant.now();
		ForkJoinPool pool= new ForkJoinPool();
		ForkJoinTask<Long> task = new ForkJoinCalculate(0, 5000000L);
		Long invoke = pool.invoke(task);
		System.out.println(invoke);
		
		Instant end = Instant.now();
		System.out.println("耗费时间为："+Duration.between(start,end).toMillis());
	
	}
	/*
	 * 普通for循环
	 * 
	 */
	public static void test2() {
		Instant start =Instant.now();
		long sum =0;
		for(long i=0;i<=1000000L;i++) {
			sum+=i;
		}
		System.out.println(sum);
		
		Instant end = Instant.now();
		System.out.println("耗费时间为："+Duration.between(start,end).toMillis());
	
	}
	
	//java8并行流
	public static void test3() {
		Instant start =Instant.now();
		LongStream.rangeClosed(0, 10000000000L)
		.sequential()
		.reduce(0,Long::sum);
		
		Instant end = Instant.now();
		System.out.println("耗费时间为："+Duration.between(start,end).toMillis());

	}
	public static void test4() {
		
	}
}
