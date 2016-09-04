package com.francis.zhihudaily_android.application;

import android.app.Application;
import android.content.SharedPreferences;
import com.francis.zhihudaily_android.utils.Theme;

/**
 * @author taoc @ Zhihu Inc.
 * @since 08-29-2016
 */
public class MyApplication extends Application{


	private static int MyTheme = 0;


	@Override
	public void onCreate() {
		super.onCreate();
		getLocalData();
	}

	private void getLocalData() {
		SharedPreferences sharedPreferences = getSharedPreferences("user_settings", MODE_PRIVATE);
		MyTheme = sharedPreferences.getInt("theme", 0);
	}


	public static int getThemeValue(){
		return MyTheme;
	}

	//设置主题
	public static int getThemeResources(){
		switch (MyTheme){
			case Theme.DAY_THEME:
				return Theme.RESOURCES_DAY_THEME;
			case Theme.NIGHT_THEME:
				return Theme.RESOURCES_NIGHT_THEME;
			default:
				return Theme.RESOURCES_DAY_THEME;
		}
	}
}
