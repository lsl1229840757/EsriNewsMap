package com.esri.entity;

import java.util.Date;

/**
 * 鏂伴椈鍩熸ā鍨�
 * 
 * @author 鑳℃．
 *
 */
public class News {

	// 鏍囪瘑id
	private Integer id;
	// 鏂伴椈鏉ユ簮
	private String origin;
	// 鍒嗗壊鍏抽敭璇�
	private String keyWord;
	// web绔師鏂囬摼鎺�
	private String webUrl;
	// 绉诲姩绔殑鍘熸枃閾炬帴
	private String mobileUrl;
	// 灏侀潰鍥剧墖閾炬帴
	private String picUrl;
	// 缁忓害
	private double longitude;
	// 绾害
	private double latitude;
	// 鏂伴椈鏍囬
	private String title;
	// 鏂伴椈鍙戝竷鏃ユ湡
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
