package com.francis.zhihudaily_android.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.francis.zhihudaily_android.R;
import com.francis.zhihudaily_android.model.DailyNews;
import com.francis.zhihudaily_android.ui.activity.MainActivity;
import com.francis.zhihudaily_android.ui.adapter.MainAdapter;
import com.francis.zhihudaily_android.ui.adapter.MainPagerAdapter;
import java.util.ArrayList;

/**
 * @author taoc @ Zhihu Inc.
 * @since 08-30-2016
 *
 * 首页
 */
public class MainFragment extends Fragment{

	private Context context;

	private MainPagerAdapter adapter;

	private TabLayout tabLayout;

	private OnViewPagerCreated mOnViewPagerCreated;

	public MainFragment(){

	}



	private MainAdapter mAdapter;

	public static MainFragment newInstance(){
		return new MainFragment();
	}

	@Override
	public void onAttach(Context context) {
		this.context = context;
		mOnViewPagerCreated = (OnViewPagerCreated) context;
		super.onAttach(context);
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_main, container, false);
		initViews(view);
		mOnViewPagerCreated.viewPagerCreated();
		return view;
	}

	private void initViews(View view) {

		Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
		((MainActivity)context).setSupportActionBar(toolbar);
		tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
		ViewPager viewPager = (ViewPager) view.findViewById(R.id.view_pager);
		viewPager.setOffscreenPageLimit(3);
		adapter = new MainPagerAdapter(getChildFragmentManager(), context);
		viewPager.setAdapter(adapter);
		tabLayout.setupWithViewPager(viewPager);
	}

	public interface OnViewPagerCreated {
		void viewPagerCreated();
	}
}
