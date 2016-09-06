package com.francis.zhihudaily_android.network;

import com.francis.zhihudaily_android.model.DailyNews;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * @author taoc @ Zhihu Inc.
 * @since 09-01-2016
 */
public class DailyAPI {



	// 获取果壳精选的文章列表,通过组合相应的参数成为完整的url
	// Guokr handpick articles. make complete url by combining params
	public static final String GUOKR_ARTICLES = "http://apis.guokr.com/handpick/article.json?retrieve_type=by_since&category=all&limit=20&ad=1";

}
