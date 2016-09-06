package com.francis.zhihudaily_android.ui.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import com.francis.zhihudaily_android.model.GuokrHandpickPost;
import java.util.ArrayList;

/**
 * @author taoc @ Zhihu Inc.
 * @since 09-04-2016
 *
 *
 * 果壳精选
 */
public class GuokrFragment extends Fragment{

	private RecyclerView rvGuokr;
	private SwipeRefreshLayout refreshGuokr;

	private ArrayList<GuokrHandpickPost> guokrList = new ArrayList<>();




	public static GuokrFragment newInstance(){
		return new GuokrFragment();
	}
}
