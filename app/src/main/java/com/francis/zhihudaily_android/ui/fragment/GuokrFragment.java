package com.francis.zhihudaily_android.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.francis.zhihudaily_android.R;
import com.francis.zhihudaily_android.interfaces.OnRecyclerViewItemClickListener;
import com.francis.zhihudaily_android.model.GuokrHandpickPost;
import com.francis.zhihudaily_android.network.DailyAPI;
import com.francis.zhihudaily_android.network.VolleySingleton;
import com.francis.zhihudaily_android.ui.activity.GuokrReadActivity;
import com.francis.zhihudaily_android.ui.adapter.GuokrPostAdapter;
import com.francis.zhihudaily_android.ui.widget.DividerItemDecoration;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

	private GuokrPostAdapter adapter;

	private static final String TAG = "GUOKR";

	public static GuokrFragment newInstance(){
		return new GuokrFragment();
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_guokr, container, false);

		initView(view);

		requestData();

		return super.onCreateView(inflater, container, savedInstanceState);
	}

	//请求数据
	private void requestData() {

		refreshGuokr.post(new Runnable() {
			@Override
			public void run() {
				refreshGuokr.setRefreshing(true);
			}
		});

		JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, DailyAPI.GUOKR_ARTICLES, new Response.Listener<JSONObject>() {
			@Override
			public void onResponse(JSONObject jsonObject) {

				try {
					if (jsonObject.getString("ok").equals("true")){
						JSONArray array = jsonObject.getJSONArray("result");
						for (int i = 0; i < array.length(); i++){
							JSONObject o = array.getJSONObject(i);
							GuokrHandpickPost item = new GuokrHandpickPost(
									o.getString("id"),
									o.getString("title"),
									o.getString("headline_img_tb"),
									o.getString("summary"));

							guokrList.add(item);
						}
					}

					if (guokrList.size() != 0){

						adapter = new GuokrPostAdapter(getActivity(),guokrList);
						adapter.setItemClickListener(new OnRecyclerViewItemClickListener() {

							@Override
							public void onItemClick(View v, int position) {

								Intent intent = new Intent(getActivity(),GuokrReadActivity.class);
								intent.putExtra("id",guokrList.get(position).getId());
								intent.putExtra("headlineImageUrl",guokrList.get(position).getHeadlineImg());
								intent.putExtra("title",guokrList.get(position).getTitle());

								startActivity(intent);
							}
						});

						rvGuokr.setAdapter(adapter);

						refreshGuokr.post(new Runnable() {
							@Override
							public void run() {
								refreshGuokr.setRefreshing(false);
							}
						});

					}

				} catch (JSONException e) {
					e.printStackTrace();
				}

			}
		}, new Response.ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError volleyError) {
				Snackbar.make(rvGuokr,R.string.loaded_failed,Snackbar.LENGTH_SHORT).show();
				refreshGuokr.post(new Runnable() {
					@Override
					public void run() {
						refreshGuokr.setRefreshing(false);
					}
				});

			}
		});

		request.setTag(TAG);
		VolleySingleton.getVolleySingleton(getContext()).addToRequestQueue(request);
	}

	private void initView(View view) {
		rvGuokr = (RecyclerView) view.findViewById(R.id.rv_guokr);
		rvGuokr.setLayoutManager(new LinearLayoutManager(getActivity()));
		rvGuokr.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));

		refreshGuokr = (SwipeRefreshLayout) view.findViewById(R.id.refresh_guokr);

		refreshGuokr.setColorSchemeResources(android.R.color.holo_blue_bright, android.R.color.holo_green_light, android.R.color.holo_orange_light, android.R.color.holo_red_light);
		//设置手指在屏幕上下拉多少距离开始刷新
		refreshGuokr.setDistanceToTriggerSync(300);

	}

	@Override
	public void onStop() {
		super.onStop();

		if(refreshGuokr.isRefreshing()){
			refreshGuokr.setRefreshing(false);
		}
	}
}
