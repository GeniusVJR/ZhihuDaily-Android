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
import com.francis.zhihudaily_android.model.ZhihuDailyPost;
import java.util.ArrayList;
import java.util.List;

/**
 * @author taoc @ Zhihu Inc.
 * @since 09-05-2016
 *
 *
 * 知乎日报适配器
 */
public class ZhihuDailyPostAdapter extends RecyclerView.Adapter<ZhihuDailyPostAdapter.LatestItemViewHolder>{

	private Context context;
	private LayoutInflater inflater;
	private List<ZhihuDailyPost> list = new ArrayList<>();
	private OnRecyclerViewItemClickListener mListener;

	public ZhihuDailyPostAdapter(Context context, List<ZhihuDailyPost> list, LayoutInflater inflater) {
		this.context = context;
		this.list = list;
		this.inflater = LayoutInflater.from(context);
	}

	@Override
	public LatestItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = inflater.inflate(R.layout.zhihu_item_layout, parent, false);
		return new LatestItemViewHolder(view, mListener);
	}

	@Override
	public void onBindViewHolder(LatestItemViewHolder holder, int position) {
		ZhihuDailyPost item = list.get(position);

		if(item.getFirstImg() == null){
			holder.itemImg.setImageResource(R.drawable.no_img);
		}else {
			Glide.with(context)
					.load(item.getFirstImg())
					.error(R.drawable.no_img)
					.centerCrop()
					.into(holder.itemImg);
		}
		holder.tvLatestNewsTitle.setText(item.getTitle());
	}

	@Override
	public int getItemCount() {
		return list.size();
	}

	public void setItemClickListener(OnRecyclerViewItemClickListener listener){
		this.mListener = listener;
	}

	public class LatestItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

		private ImageView itemImg;
		private TextView tvLatestNewsTitle;
		private OnRecyclerViewItemClickListener mListener;

		public LatestItemViewHolder(View itemView, OnRecyclerViewItemClickListener listener) {
			super(itemView);

			itemImg = (ImageView) itemView.findViewById(R.id.zhihu_item_iv);
			tvLatestNewsTitle = (TextView) itemView.findViewById(R.id.zhihu_item_tv_title);
			this.mListener = listener;
			itemView.setOnClickListener(this);
		}

		@Override
		public void onClick(View view) {
			if(mListener != null){
				mListener.onItemClick(view, getLayoutPosition());
			}
		}
	}



}
