package com.francis.zhihudaily_android.network;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author taoc @ Zhihu Inc.
 * @since 09-01-2016
 */
public class DailyClient {

	DailyAPI mDailyAPI;

	public DailyClient() {

		Retrofit retrofit = new Retrofit.Builder().
				baseUrl("http://news-at.zhihu.com/")
				.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
				.addConverterFactory(GsonConverterFactory.create())
				.build();

		mDailyAPI = retrofit.create(DailyAPI.class);




	}
}
