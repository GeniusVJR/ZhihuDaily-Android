package com.francis.zhihudaily_android.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.francis.zhihudaily_android.R;
import com.francis.zhihudaily_android.model.DailyNews;
import com.francis.zhihudaily_android.ui.adapter.MainAdapter;
import java.util.ArrayList;

/**
 * @author taoc @ Zhihu Inc.
 * @since 08-30-2016
 *
 * 首页
 */
public class MainFragment extends Fragment{

	private MainAdapter mAdapter;

	public static MainFragment newInstance(){
		return new MainFragment();
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mAdapter = new MainAdapter(new ArrayList<DailyNews>());
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_main, container, false);
		RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_main);
		LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
		recyclerView.setLayoutManager(layoutManager);

		recyclerView.setAdapter(mAdapter);
		return view;
	}
}
