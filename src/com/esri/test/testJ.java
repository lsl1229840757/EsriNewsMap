package com.esri.test;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.json.JSONObject;
import org.junit.Test;

import com.esri.dao.daoImpl.NewsDaoImpl;
import com.esri.entity.News;

public class testJ {

	@Test
	public void test() throws ParseException {
		NewsDaoImpl nd = new NewsDaoImpl();
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
		//System.out.println(LocalDateTime.now()); hibernate²»Ö§³Ö
		System.out.println(new java.sql.Date(new Date().getTime()));
	}
	
}
