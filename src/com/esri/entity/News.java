package com.esri.entity;

public class News {

	private Integer id;
	private String origin;
	private String keyWord;
	private String webUrl;
	private String mobileUrl;
	private String picUrl;
	private double longitude;
	private double latitude;
	private String title;
	private int pubDate;

	
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPubDate() {
		return pubDate;
	}

	public void setPubDate(int pubDate) {
		this.pubDate = pubDate;
	}

	public News(String origin, String keyWord, String webUrl, String mobileUrl, String picUrl, double longitude,
			double latitude, String title, int pubDate) {
		super();
		this.origin = origin;
		this.keyWord = keyWord;
		this.webUrl = webUrl;
		this.mobileUrl = mobileUrl;
		this.picUrl = picUrl;
		this.longitude = longitude;
		this.latitude = latitude;
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
				+ ", title:" + title + ", pubDate:" + pubDate + "}";
	}

}
