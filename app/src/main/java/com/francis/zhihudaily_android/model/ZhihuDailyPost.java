package com.francis.zhihudaily_android.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author taoc @ Zhihu Inc.
 * @since 09-05-2016
 */
public class ZhihuDailyPost {

	private String title;
	private List<String> images = new ArrayList<>();
	private String type;
	private String id;

	public ZhihuDailyPost(String title, List<String> images, String type, String id) {
		this.title = title;
		this.images = images;
		this.type = type;
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstImg(){
		if (images.isEmpty())
			return null;
		return images.get(0);
	}
}
