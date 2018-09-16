package com.esri.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalenderTools{
	
	
	public static Date formatNowDay(Date now){
		SimpleDateFormat  sf = new SimpleDateFormat("yyyy-MM-dd");
		Date result = null;
		String format = sf.format(now);
		try {
			 result = sf.parse(format);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static Date formatNowMonth(Date now) {
		SimpleDateFormat  sf = new SimpleDateFormat("yyyy-MM");
		Date result = null;
		String format = sf.format(now);
		try {
			 result = sf.parse(format);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static int getNowTime(Date now) {
		Calendar calendar = Calendar.getInstance();  
		calendar.setTime(now);
		return (int)(calendar.getTime().getTime()/1000);
	}
	
	public static int getNowMonthEnd(Date now)  {
		now = formatNowMonth(now);
		Calendar calendar = Calendar.getInstance();  
		calendar.setTime(now);
		calendar.add(Calendar.MONTH, +1);
		return (int)(calendar.getTime().getTime()/1000);
	}
	public static int getNowMonthStart(Date now)  {
		now = formatNowMonth(now);
		return (int)(now.getTime()/1000);
	}
	
	public static int getYesterDay(Date now) {
		now = formatNowDay(now);
		return (int)((now.getTime()-24*60*60*1000)/1000);
	}
	
	public static int getTomorrow(Date now){
		now = formatNowDay(now);
		return (int)((now.getTime()+24*60*60*1000)/1000);
	}
	
	public static int getNowDay(Date now) {
		now = formatNowDay(now);
		return (int) (now.getTime()/1000);
	}
	
}
