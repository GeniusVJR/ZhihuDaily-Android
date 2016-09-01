package com.francis.zhihudaily_android.network;

import com.francis.zhihudaily_android.model.DailyNews;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * @author taoc @ Zhihu Inc.
 * @since 09-01-2016
 */
public interface DailyAPI {


	@GET("api/4/news/{newsId}")
	Observable<DailyNews> updateNews(@Path ("newsId") String newsId);


}
