package com.francis.zhihudaily_android.application;

import android.app.Application;

/**
 * @author taoc @ Zhihu Inc.
 * @since 08-29-2016
 */
public class MyApplication extends Application{

	private static MyApplication sMyApplication;

	@Override
	public void onCreate() {
		super.onCreate();
		sMyApplication = this;
	}
}
