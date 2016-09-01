package com.francis.zhihudaily_android.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * @author taoc @ Zhihu Inc.
 * @since 09-01-2016
 *
 *
 * 添加 Fragment 到 Activity 和 更换 Fragment 的工具类
 */
public class ActivityUtils {

	public static void addFragmentToActivity(FragmentManager fragmentManager,
			Fragment fragment, int frameId){

		FragmentTransaction transaction = fragmentManager.beginTransaction();
		transaction.add(frameId, fragment);
		transaction.commit();
	}

	public static void replaceFragmentToActivity(FragmentManager fragmentManager,
			Fragment fragment, int frameId){
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		transaction.replace(frameId, fragment);
		transaction.commit();
	}
}
