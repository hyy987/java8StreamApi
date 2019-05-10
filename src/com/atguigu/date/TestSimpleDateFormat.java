package com.atguigu.date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestSimpleDateFormat {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		Callable<LocalDate> task = new Callable<LocalDate>() {
			@Override
			public LocalDate call() throws Exception {
				// TODO Auto-generated method stub
				return LocalDate.parse("2018-01-23", dtf);
			}
		};
		
		ExecutorService pool = Executors.newFixedThreadPool(10);
		
		List<Future<LocalDate>> res = new ArrayList<>();
		for(int i=0;i<10;i++) {
			res.add(pool.submit(task));
		}
		
		for (Future<LocalDate> future : res) {
			System.out.println(future.get());
		}
		pool.shutdown();
	}
}
