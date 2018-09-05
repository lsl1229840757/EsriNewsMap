package com.esri.test;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.json.JSONObject;
import org.junit.Test;

import com.esri.dao.daoImpl.NewsDaoImpl;
import com.esri.entity.News;

public class testHibernate {

	@Test
	public void test() throws ParseException {
		NewsDaoImpl nd = new NewsDaoImpl();
		List<News> news = nd.findNewsByPubDate(new Date());
		System.out.println(news);
	}
	@Test
	public void test2() {
		News n = new News();
		n.setKeyWord("adsfsda");
		System.out.println(n);
		JSONObject b = new JSONObject().put("sa", "asdf");
		System.out.println(b);
	}

}
