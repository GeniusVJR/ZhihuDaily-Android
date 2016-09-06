package com.francis.zhihudaily_android.model;

/**
 * @author taoc @ Zhihu Inc.
 * @since 09-05-2016
 */
public class GuokrHandpickPost {

	private String title;
	private String headlineImg;
	private String id;
	private String summary;

	public GuokrHandpickPost(String title, String headlineImg, String id, String summary) {
		this.title = title;
		this.headlineImg = headlineImg;
		this.id = id;
		this.summary = summary;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getHeadlineImg() {
		return headlineImg;
	}

	public void setHeadlineImg(String headlineImg) {
		this.headlineImg = headlineImg;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
}
