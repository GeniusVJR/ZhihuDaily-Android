package com.francis.zhihudaily_android.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.francis.zhihudaily_android.R;
import com.francis.zhihudaily_android.interfaces.OnRecyclerViewItemClickListener;
import com.francis.zhihudaily_android.model.GuokrHandpickPost;
import java.util.List;

/**
 * @author taoc @ Zhihu Inc.
 * @since 09-05-2016
 */
public class GuokrPostAdapter extends RecyclerView.Adapter<GuokrPostAdapter.GuokrPostViewHolder>{

	private final Context context;

	private final LayoutInflater inflater;

	private List<GuokrHandpickPost> list;

	private OnRecyclerViewItemClickListener listener;

	public GuokrPostAdapter(Context context, List<GuokrHandpickPost> list) {
		this.context = context;
		this.inflater = LayoutInflater.from(context);
		this.list = list;
	}

	public void setItemClickListener(OnRecyclerViewItemClickListener listener) {
		this.listener = listener;
	}

	@Override
	public GuokrPostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = inflater.inflate(R.layout.guokr_douban_post_layout, parent, false);
		return new GuokrPostViewHolder(view, listener);
	}

	@Override
	public void onBindViewHolder(GuokrPostViewHolder holder, int position) {

		GuokrHandpickPost item = list.get(position);

		Glide.with(context)
				.load(item.getHeadlineImg())
				.asBitmap()
				.centerCrop()
				.into(holder.ivHeadlineImg);

		holder.tvTitle.setText(item.getTitle());
		holder.tvSummary.setText(item.getSummary());

	}

	@Override
	public int getItemCount() {
		return list.size();
	}

	public class GuokrPostViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

		ImageView ivHeadlineImg;

		TextView tvTitle;

		TextView tvSummary;

		OnRecyclerViewItemClickListener listener;

		public GuokrPostViewHolder(View itemView, OnRecyclerViewItemClickListener listener) {
			super(itemView);

			ivHeadlineImg = (ImageView) itemView.findViewById(R.id.image_view);
			tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
			tvSummary = (TextView) itemView.findViewById(R.id.tv_summary);

			this.listener = listener;

			itemView.setOnClickListener(this);
		}

		@Override
		public void onClick(View view) {
			if (listener != null) {
				listener.onItemClick(view, getLayoutPosition());
			}
		}
	}

}
