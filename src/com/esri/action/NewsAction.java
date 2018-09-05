package com.esri.action;

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
/**
 * 
 * @author 李松廉
 * 新闻显示action
 *
 */
@Scope("prototype")
@Repository
public class NewsAction extends ActionSupport {

	/*public static NewsDao nd = new NewsDaoImpl();*/
	@Resource
	private NewsService ns;
	
	public HttpServletRequest req = ServletActionContext.getRequest();
	/**
	 *第一次初始化新闻 
	 */
	public void initiateNews() {
		System.out.println("访问当前action");
		ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
		ServletActionContext.getResponse().setContentType("text/html");
		//获取前台的时间参数
		String timestr = req.getParameter("pubDate");
		try {
			Date time = new Date(Long.valueOf(timestr));
			List<News> news = ns.findNewsByPubWeek(time);
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
				jb.put("pageView",n.getPageView());
				jb.put("title",n.getTitle());
				jb.put("pubDate",n.getPubDate());
				ja.put(jb);
			}
			ServletActionContext.getResponse().getWriter().println(ja.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
