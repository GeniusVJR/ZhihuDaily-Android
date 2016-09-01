package com.francis.zhihudaily_android.model;

import java.util.List;

/**
 * @author taoc @ Zhihu Inc.
 * @since 08-29-2016
 *
 * 日报新闻
 */
public class DailyNews {

	private int type;
	private int id;

	private String title;
	private String imgId;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImgId() {
		return imgId;
	}

	public void setImgId(String imgId) {
		this.imgId = imgId;
	}
}
