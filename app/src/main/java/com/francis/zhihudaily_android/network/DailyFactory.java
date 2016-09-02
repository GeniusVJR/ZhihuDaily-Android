package com.francis.zhihudaily_android.network;

/**
 * @author taoc @ Zhihu Inc.
 * @since 09-01-2016
 */
public class DailyFactory {


	private static DailyAPI sDailyAPIInstance = null;

	private static final Object WATCH_DOG = new Object();

	private DailyFactory() {
	}

	public static DailyAPI getDailyAPIInstance(){
		synchronized (WATCH_DOG){
			if(sDailyAPIInstance != null){
				DailyClient client = new DailyClient();
				sDailyAPIInstance = client.getClient();
			}
			return sDailyAPIInstance;
		}
	}

}
