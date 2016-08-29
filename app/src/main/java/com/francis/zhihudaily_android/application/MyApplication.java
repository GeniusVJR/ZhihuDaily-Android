package com.francis.zhihudaily_android.application;

import android.app.Application;
import android.content.Context;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

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

		initImageLoader(getApplicationContext());
	}

	//初始化 ImageLoader
	public static void initImageLoader(Context context){
		ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(context)
				.denyCacheImageMultipleSizesInMemory()
				.threadPriority(Thread.NORM_PRIORITY - 2)
				.diskCacheFileNameGenerator(new Md5FileNameGenerator())
				.tasksProcessingOrder(QueueProcessingType.LIFO)
				.build();
		ImageLoader.getInstance().init(configuration);
	}
}
