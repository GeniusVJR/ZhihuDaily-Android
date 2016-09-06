package com.francis.zhihudaily_android.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.francis.zhihudaily_android.R;
import com.francis.zhihudaily_android.interfaces.OnRecyclerViewItemClickListener;
import com.francis.zhihudaily_android.model.GuokrHandpickPost;
import java.util.List;

/**
 * @author taoc @ Zhihu Inc.
 * @since 09-05-2016
 */
public class GuokrPostAdapter {

	private final Context context;
	private final LayoutInflater inflater;
	private List<GuokrHandpickPost> list;

	private OnRecyclerViewItemClickListener mListener;

	public GuokrPostAdapter(Context context, LayoutInflater inflater, List<GuokrHandpickPost> list) {
		this.context = context;
		this.inflater = LayoutInflater.from(context);
		this.list = list;
	}




	public class GuokrPostViewHolder extends RecyclerView.ViewHolder{


		ImageView ivHeadlineImg;
		TextView tvTitle;
		TextView tvSummary;

		OnRecyclerViewItemClickListener listener;

		public GuokrPostViewHolder(View itemView) {
			super(itemView);

			//ivHeadlineImg = itemView.findViewById(R.id.im)
		}
	}



}
