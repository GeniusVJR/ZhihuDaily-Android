package com.francis.zhihudaily_android.network;

import android.content.Context;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * @author taoc @ Zhihu Inc.
 * @since 09-06-2016
 */
public class VolleySingleton {

	private static VolleySingleton sVolleySingleton;
	private RequestQueue mRequestQueue;

	private VolleySingleton(Context context){
		mRequestQueue = Volley.newRequestQueue(context.getApplicationContext());
	}

	public static synchronized VolleySingleton getVolleySingleton(Context context){
		if(sVolleySingleton == null){
			sVolleySingleton = new VolleySingleton(context);
		}
		return sVolleySingleton;
	}

	public RequestQueue getRequestQueue(){
		return this.mRequestQueue;
	}

	public <T> void addToRequestQueue(Request<T> req){
		getRequestQueue().add(req);
	}

}
