package com.esri.test;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.json.JSONObject;
import org.junit.Test;

import com.esri.dao.daoImpl.NewsDaoImpl;
import com.esri.entity.News;
import com.esri.util.CalenderTools;

public class testJ {

	@Test
	public void test() throws ParseException {
		
	}
	@Test
	public void test2() {
		News n = new News();
		n.setKeyWord("adsfsda");
		System.out.println(n);
		JSONObject b = new JSONObject().put("sa", "asdf");
		System.out.println(b);
	}

	@Test
	public void test4() {
		//System.out.println(LocalDateTime.now()); hibernate��֧��
		System.out.println(new java.sql.Date(new Date().getTime()));
	}
	@Test
	public void test8() throws ParseException {
		System.out.println(CalenderTools.formatNowDay(new Date()));
		System.out.println(CalenderTools.formatNowMonth(new Date()));
		System.out.println(CalenderTools.getYesterDay(new Date()));
		System.out.println(new Date((long)CalenderTools.getNowMonthEnd(new Date())*1000));
	}
}
