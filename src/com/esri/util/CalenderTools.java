package com.esri.util;

import java.util.Calendar;
import java.util.Date;

public class CalenderTools {

	public static int getNowTime(Date now) {
		Calendar calendar = Calendar.getInstance();  
		calendar.setTime(now);
		return (int)(calendar.getTime().getTime()/1000);
	}
	
	public static int getNowMonth(Date now) {
		Calendar calendar = Calendar.getInstance();  
		calendar.setTime(now);
		calendar.add(Calendar.MONTH, -1);
		return (int)(calendar.getTime().getTime()/1000);
	}
	
	public static int getYesterDay(Date now) {
		return (int)((now.getTime()-24*60*60*1000)/1000);
	}
}
