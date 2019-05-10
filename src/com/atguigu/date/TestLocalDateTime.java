package com.atguigu.date;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

public class TestLocalDateTime {

	// 1.LocalDate LocalTime LoaclDateTime

	// 2.Instant：时间戳以Unix元年1970-1-1 00：00：00到某个时间之间的毫秒值
	// 3.Duration:比较两个日期时间
	//	 Preiod:比较两个日期
	//4.TemporalAdjuster:时间校正器
	public static void main(String[] args) {
//		main1();
//		main2();
//		main3();
//		main4();
//		main5();
//		main6();
		main7();
		
		
	}

	public static void main1() {
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);

		LocalDateTime ldt2 = LocalDateTime.of(2015, 10, 19, 13, 14, 56);
		System.out.println(ldt2);

		LocalDateTime ldt3 = ldt.plusYears(2);
		System.out.println(ldt3);

		LocalDateTime ldt4 = ldt.minusMinutes(2);
		System.out.println(ldt4);

		System.out.println(ldt.getYear());
		System.out.println(ldt.getMonth());
		System.out.println(ldt.getDayOfMonth());
		System.out.println(ldt.getHour());
		System.out.println(ldt.getMinute());
		System.out.println(ldt.getSecond());

	}

	public static void main2() {
		Instant now = Instant.now();// 默认获取UTC时区
		System.out.println(now);

		System.out.println(now.atOffset(ZoneOffset.ofHours(8)));

		System.out.println(now.toEpochMilli());

		Instant ins2 = Instant.ofEpochSecond(1000);
		System.out.println(ins2);
	}

	public static void main3() {
		Instant ins1 = Instant.now();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

		}
		Instant ins2 = Instant.now();
		Duration d = Duration.between(ins1, ins2);
		System.out.println(d.getSeconds());
		System.out.println("---------------------");
		LocalDateTime L1 = LocalDateTime.now();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
		}
		LocalDateTime L2 = LocalDateTime.now();
		System.out.println(Duration.between(L1, L2).toMillis());
		
	}

	public static void main4() {
		
		LocalDate ld1 = LocalDate.of(2016, 12, 13);
		LocalDate ld2 = LocalDate.now();
		System.out.println(Period.between(ld1, ld2).getYears());
		System.out.println(Period.between(ld1, ld2).getMonths());
		System.out.println(Period.between(ld1, ld2).getDays());
	}

	public static void main5() {
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);
		
		LocalDateTime dm = ldt.withDayOfMonth(20);
		System.out.println(dm);
		
		LocalDateTime ldt3 = ldt.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
		System.out.println(ldt3);
		
		//自定义：下一个工作日
//		ldt.with((l)->{
//			LocalDateTime ldt4 =(LocalDateTime)l;
//			DayOfWeek dow =ldt4.getDayOfWeek();
//			/*switch(dow){
//				
//			}*/
//		});
		
	}

	//DateTimeFormatter：时间日期格式化
	public static void main6() {
		DateTimeFormatter t1 = DateTimeFormatter.ISO_DATE_TIME;
		LocalDateTime ldt = LocalDateTime.now();
		String string = ldt.format(t1);
		System.out.println(string);
		DateTimeFormatter t2 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
		System.out.println(ldt.format(t2));
		
		String string2 = ldt.format(t2);
		System.out.println(ldt.parse(string2,t2));
	}
	
	public static void main7() {
		Set<String> set = ZoneId.getAvailableZoneIds();
		set.forEach(System.out::println);
	}
	public static void main8() {}
	public static void main9() {}
}
