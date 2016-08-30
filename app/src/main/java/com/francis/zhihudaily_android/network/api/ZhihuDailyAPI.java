package com.francis.zhihudaily_android.network.api;

/**
 * @author taoc @ Zhihu Inc.
 * @since 08-30-2016
 *
 * 参考 https://github.com/izzyleung/ZhihuDailyPurify/wiki/知乎日报-API-分析
 *
 *
 *
 */
public class ZhihuDailyAPI {


	public static final String BASE_URL = "http://news-at.zhihu.com/api/4/";
	public static final String START_IMAGE_SIZE = "1080*1776";


	/**
	 * 启动界面图像获取
	 *
	 * URL: http://news-at.zhihu.com/api/4/start-image/1080*1776
	 */
	public static String getStartImageUrl(){
		return BASE_URL + "start-image" + START_IMAGE_SIZE;
	}

	/**
	 *  最新消息
	 *
	 * URL: http://news-at.zhihu.com/api/4/news/latest
	 * @return
	 */
	public static String getLatestNewsUrl(){
		return BASE_URL + "news/latest";
	}

	/**
	 *
	 * 消息内容获取
	 *
	 * http://news-at.zhihu.com/api/4/news/3892357
	 *
	 */
	public static String getNewsUrl(String id){
		return BASE_URL + "news/" + id;
	}










}
