package com.francis.zhihudaily_android.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.francis.zhihudaily_android.R;
import com.francis.zhihudaily_android.model.DailyNews;
import java.util.ArrayList;
import java.util.List;

/**
 * @author taoc @ Zhihu Inc.
 * @since 09-01-2016
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder>{


	private Context mContext;
	private List<DailyNews> mDailyNewses;
	private OnItemClickListener mOnItemClickListener;

	public MainAdapter(List<DailyNews> list) {
		mDailyNewses = list;
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		mContext = parent.getContext();
		View view = LayoutInflater.from(mContext).inflate(R.layout.main_news_item, parent, false);
		return new ViewHolder(view);
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {

	}

	@Override
	public int getItemCount() {
		return mDailyNewses.size();
	}

	public static class ViewHolder extends RecyclerView.ViewHolder{

		TextView newsTitle;
		ImageView newsImg;

		public ViewHolder(View itemView) {
			super(itemView);
			newsTitle = (TextView) itemView.findViewById(R.id.main_news_title);
			newsImg = (ImageView) itemView.findViewById(R.id.main_new_img);
		}
	}

	public void setOnItemClickListener(OnItemClickListener listener){
		this.mOnItemClickListener = listener;
	}
	/**
	 * Item 点击事件
	 */
	public interface OnItemClickListener{
		void onItemClick(View view, int position);
	}
}
