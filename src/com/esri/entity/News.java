package com.esri.entity;

import java.util.Date;

/**
 * 新闻域模型
 * 
 * @author 胡森
 *
 */
public class News {

	// 标识id
	private Integer id;
	// 新闻来源
	private String origin;
	// 分割关键词
	private String keyWord;
	// web端原文链接
	private String webUrl;
	// 移动端的原文链接
	private String mobileUrl;
	// 封面图片链接
	private String picUrl;
	// 经度
	private double longitude;
	// 纬度
	private double latitude;
	// 页面浏览量
	private double pageView;
	// 新闻标题
	private String title;
	// 新闻发布日期
	private Date pubDate;
	// 新闻类别
	private Category category = new Category();

	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public String getWebUrl() {
		return webUrl;
	}

	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}

	public String getMobileUrl() {
		return mobileUrl;
	}

	public void setMobileUrl(String mobileUrl) {
		this.mobileUrl = mobileUrl;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getPageView() {
		return pageView;
	}

	public void setPageView(double pageView) {
		this.pageView = pageView;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getPubDate() {
		return pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

	public News(String origin, String keyWord, String webUrl, String mobileUrl, String picUrl, double longitude,
			double latitude, double pageView, String title, Date pubDate) {
		super();
		this.origin = origin;
		this.keyWord = keyWord;
		this.webUrl = webUrl;
		this.mobileUrl = mobileUrl;
		this.picUrl = picUrl;
		this.longitude = longitude;
		this.latitude = latitude;
		this.pageView = pageView;
		this.title = title;
		this.pubDate = pubDate;
	}

	public News() {
		super();
	}

	@Override
	public String toString() {
		return "{id:" + id + ", origin:" + origin + ", keyWord:" + keyWord + ", webUrl:" + webUrl + ", mobileUrl:"
				+ mobileUrl + ", picUrl:" + picUrl + ", longitude:" + longitude + ", latitude:" + latitude
				+ ", pageView:" + pageView + ", title:" + title + ", pubDate:" + pubDate + "}";
	}

}
