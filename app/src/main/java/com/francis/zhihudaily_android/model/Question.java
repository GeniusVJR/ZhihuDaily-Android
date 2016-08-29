package com.francis.zhihudaily_android.model;

import com.francis.zhihudaily_android.constant.Constants;

/**
 * @author taoc @ Zhihu Inc.
 * @since 08-29-2016
 */
public class Question {

	private String title;
	private String url;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isValidZhihuQuestion() {
		return url != null && url.startsWith(Constants.Strings.ZHIHU_QUESTION_LINK_PREFIX);
	}
}
