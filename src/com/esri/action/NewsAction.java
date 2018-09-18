package com.esri.action;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.esri.entity.HistoryNews;
import com.esri.entity.News;
import com.esri.service.NewsService;
import com.esri.util.CalenderTools;
import com.opensymphony.xwork2.ActionSupport;
@Scope("prototype")
@Repository
public class NewsAction extends ActionSupport {

	/*public static NewsDao nd = new NewsDaoImpl();*/
	@Resource
	private NewsService ns;
	
	public HttpServletRequest req = ServletActionContext.getRequest();
	
	public int flag = 0;
	
	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public void initiateNews() {
		ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
		ServletActionContext.getResponse().setContentType("text/html");
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
	
	public void getMoreNews() {
		System.out.println("访问到此方法：flag为："+flag);
		ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
		ServletActionContext.getResponse().setContentType("text/html");
		Date now = new Date();
		long yesterDay = 0l;
		for (int i = 0; i < 4; i++) {
			yesterDay = CalenderTools.getYesterDay(now);
			now = new Date(yesterDay * 1000);
		}	
		System.out.println(flag);
		for(int i = 0;i <= flag;i++) {
			long tempt = CalenderTools.getYesterDay(now);
			now = new Date(tempt*1000);
		}
		List<HistoryNews> news = ns.findHistoryNewsByTime(now);
		JSONArray ja = new JSONArray();
		for(HistoryNews n:news) {
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
			System.out.println(ja);
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
