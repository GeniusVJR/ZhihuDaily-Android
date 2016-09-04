package com.francis.zhihudaily_android.utils;

import android.app.Activity;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;
import com.francis.zhihudaily_android.R;
import com.francis.zhihudaily_android.application.MyApplication;

/**
 * @author taoc @ Zhihu Inc.
 * @since 09-04-2016
 *
 * 用于实现夜间模式的 Theme 类
 */
public class Theme {

	//对应 attrs.xml 的 MyTheme
	public static final int DAY_THEME = 0;
	public static final int NIGHT_THEME = 1;

	//对应 Style
	public static final int RESOURCES_DAY_THEME = R.style.DayTheme;
	public static final int RESOURCES_NIGHT_THEME = R.style.NightTheme;


	//改变 status bar 的颜色
	public static void setStatusBarColor(Activity activity){

		// change the status bar's color
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){

			Window window = activity.getWindow();
			window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

			window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

			if(MyApplication.getThemeValue() == DAY_THEME){
				window.setStatusBarColor(activity.getResources().getColor(R.color.colorStatusBarLight));
			}else {
				window.setStatusBarColor(activity.getResources().getColor(R.color.colorStatusBarDark));
			}

		}
	}

}
