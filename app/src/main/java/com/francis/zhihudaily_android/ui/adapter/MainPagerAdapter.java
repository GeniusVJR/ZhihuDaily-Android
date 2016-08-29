package com.francis.zhihudaily_android.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.francis.zhihudaily_android.constant.Constants;

/**
 * @author taoc @ Zhihu Inc.
 * @since 08-29-2016
 *
 * 首页的 Adapter
 */
public class MainPagerAdapter extends FragmentStatePagerAdapter{

	public MainPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int position) {
		return null;
	}

	@Override
	public int getCount() {
		return Constants.PAGE_COUNT;
	}
}
