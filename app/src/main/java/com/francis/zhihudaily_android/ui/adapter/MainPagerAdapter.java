package com.francis.zhihudaily_android.ui.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.francis.zhihudaily_android.R;
import com.francis.zhihudaily_android.constant.Constants;
import com.francis.zhihudaily_android.ui.fragment.DoubanMomentFragment;
import com.francis.zhihudaily_android.ui.fragment.GuokrFragment;
import com.francis.zhihudaily_android.ui.fragment.ZhihuDailyFragment;

/**
 * @author taoc @ Zhihu Inc.
 * @since 08-29-2016
 *
 * 首页的 Adapter
 */
public class MainPagerAdapter extends FragmentStatePagerAdapter{

	private String[] titles;
	private final Context context;

	public MainPagerAdapter(FragmentManager fm, Context context) {
		super(fm);
		this.context = context;
		titles = context.getResources().getStringArray(R.array.page_titles);
	}

	@Override
	public Fragment getItem(int position) {
		if(position == 1){
			return GuokrFragment.newInstance();
		}else if (position == 2){
			return DoubanMomentFragment.newInstance();
		}
		return ZhihuDailyFragment.newInstance();
	}

	@Override
	public int getCount() {
		return titles.length;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return titles[position];
	}
}
