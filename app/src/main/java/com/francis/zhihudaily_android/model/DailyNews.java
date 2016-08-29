package com.francis.zhihudaily_android.model;

import java.util.List;

/**
 * @author taoc @ Zhihu Inc.
 * @since 08-29-2016
 */
public class DailyNews {

	private String date;
	private String dailyTitle;
	private String thumbnailUrl;
	private List<Question> questions;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDailyTitle() {
		return dailyTitle;
	}

	public void setDailyTitle(String dailyTitle) {
		this.dailyTitle = dailyTitle;
	}

	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
}
