package com.francis.zhihudaily_android.ui.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.BaseAdapter;
import com.francis.zhihudaily_android.R;
import com.francis.zhihudaily_android.constant.Constants;
import com.francis.zhihudaily_android.ui.activity.base.BaseActivity;

public class MainActivity extends BaseActivity {



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		layoutId = R.layout.activity_main;
		super.onCreate(savedInstanceState);

		TabLayout tabLayout = (TabLayout) findViewById(R.id.main_pager_tabs);
		ViewPager viewPager = (ViewPager) findViewById(R.id.main_pager);

		viewPager.setOffscreenPageLimit(Constants.PAGE_COUNT);


	}
}
