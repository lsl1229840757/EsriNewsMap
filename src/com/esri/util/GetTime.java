package com.esri.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GetTime {

	public static String getStatetime(Date date,int num){
        Calendar c = Calendar.getInstance();  
        c.setTime(date);
        c.add(Calendar.DATE, num);
        Date monday = c.getTime();
        String preMonday = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(monday);
        return preMonday;
    }
}

