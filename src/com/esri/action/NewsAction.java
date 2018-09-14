package com.esri.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.esri.dao.NewsDao;
import com.esri.dao.daoImpl.NewsDaoImpl;
import com.esri.entity.News;
import com.esri.service.NewsService;
import com.opensymphony.xwork2.ActionSupport;
@Scope("prototype")
@Repository
public class NewsAction extends ActionSupport {

	/*public static NewsDao nd = new NewsDaoImpl();*/
	@Resource
	private NewsService ns;
	
	public HttpServletRequest req = ServletActionContext.getRequest();
	/**
	 *ï¿½ï¿½Ò»ï¿½Î³ï¿½Ê¼ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ 
	 */
	public void initiateNews() {
		System.out.println("ï¿½ï¿½ï¿½Êµï¿½Ç°action");
		ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
		ServletActionContext.getResponse().setContentType("text/html");
			System.out.println("Ç°¶Ë·¢ÐÅÏ¢ÁË");
			List<News> news = ns.findRecentNews();
			JSONArray ja = new JSONArray();
			for(News n:news) {
				JSONObject jb = new JSONObject();
				jb.put("id", n.getId());
				jb.put("origin", n.getOrigin());
				jb.put("keyWord",n.getKeyWord());
				jb.put("webUrl",n.getWebUrl());
				jb.put("mobileUrl",n.getMobileUrl());
				jb.put("picUrl",n.getPicUrl());
				jb.put("longitude",n.getLongitude());
				jb.put("latitude",n.getLatitude());
				jb.put("title",n.getTitle());
				jb.put("pubDate",n.getPubDate());
				ja.put(jb);
			}
			try {
				ServletActionContext.getResponse().getWriter().println(ja.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}
	
	public void executeAjax() {
		JSONArray ja = ns.statistics();
		try {
			ServletActionContext.getResponse().getWriter().print(ja);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
