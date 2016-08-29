package com.francis.zhihudaily_android.ui.activity.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import com.francis.zhihudaily_android.R;

/**
 * @author taoc @ Zhihu Inc.
 * @since 08-29-2016
 *
 * 基类的 Activity
 *
 * 封装 CoordinatorLayout 和 Toolbar
 */
public class BaseActivity extends AppCompatActivity{

	private CoordinatorLayout mCoordinatorLayout;

	private Toolbar mToolbar;

	//子类重写这个字段，对应相应的布局
	protected int layoutId = R.layout.activity_base;


	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(layoutId);

		mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.layout_coordinator);

		mToolbar = (Toolbar) findViewById(R.id.layout_toolbar);
		setSupportActionBar(mToolbar);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()){
			case android.R.id.home:
				onBackPressed();
				return true;
		}
		return super.onOptionsItemSelected(item);
	}

	//显示 Snackbar
	public void showSnackbar(int resId){
		Snackbar.make(mCoordinatorLayout, resId, Snackbar.LENGTH_SHORT).show();
	}
}
