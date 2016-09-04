package com.francis.zhihudaily_android.ui.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.volley.RequestQueue;

/**
 * @author taoc @ Zhihu Inc.
 * @since 09-04-2016
 *
 *
 * 跳转页
 *
 * 使用  volley 获取数据
 */
public class SplashActivity extends AppCompatActivity{

	private ImageView ivWelcome;
	private TextView tvWelcomeName;

	private RequestQueue mQueue;

	private SharedPreferences sp;

	private final static String TAG = "SplashActivity";

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		sp = getSharedPreferences("user_settings", MODE_PRIVATE);

		if(sp.getBoolean("load_splash", true)){

			Intent intent = new Intent(SplashActivity.this, MainActivity.class);
			startActivity(intent);
			finish();
		}
		else {

		}


	}
}
