package com.francis.zhihudaily_android.ui.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.francis.zhihudaily_android.db.DatabaseHelper;
import com.francis.zhihudaily_android.model.ZhihuDailyPost;
import com.francis.zhihudaily_android.ui.adapter.ZhihuDailyPostAdapter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author taoc @ Zhihu Inc.
 * @since 09-04-2016
 */
public class ZhihuDailyFragment extends Fragment{

	private RecyclerView rvLatestNews;
	private SwipeRefreshLayout refresh;
	private FloatingActionButton fab;
	private RequestQueue queue;
	private List<ZhihuDailyPost> list = new ArrayList<>();

	private ZhihuDailyPostAdapter adapter;

	private DatabaseHelper dbHelper;
	private SQLiteDatabase db;

	private SharedPreferences sp;

	// 2013.5.20 是知乎日报 api 首次上线
	private int year = 2013;
	private int month = 5;
	private int day = 20;

	//用语纪录加载更多的次数
	private int groupCount = -1;




	public static ZhihuDailyFragment newInstance(){
		return new ZhihuDailyFragment();
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		queue = Volley.newRequestQueue(getActivity().getApplicationContext());

		//dbHelper = new DatabaseHelper(getActivity(), "History.db", null, 3);
		//db = dbHelper.getWritableDatabase();

		sp = getActivity().getSharedPreferences("user_settings", Context.MODE_PRIVATE);

		deleteTimeoutPosts();


	}

	//删除掉以前的时间的数据
	private void deleteTimeoutPosts() {

		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, -2);


	}
}
