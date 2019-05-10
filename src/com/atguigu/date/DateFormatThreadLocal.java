package com.atguigu.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatThreadLocal {

	private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>() {
		
			protected DateFormat initialValue() {
				return new SimpleDateFormat("yyyy-MM-dd");
			}	
	};
	
	public static Date convert(String source) throws ParseException {
		return df.get().parse(source);
	}
}
