package com.francis.zhihudaily_android.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author taoc @ Zhihu Inc.
 * @since 08-29-2016
 */
public class NewsAdapter {



	public static class CardViewHolder extends RecyclerView.ViewHolder{

		public ImageView newsImage;
		public TextView questionTitle;
		public TextView dailyTitle;
		public ImageView overflow;

		private ClickResponseListener mClickResponseListener;

		public CardViewHolder(View itemView, ClickResponseListener clickResponseListener) {
			super(itemView);
			this.mClickResponseListener = clickResponseListener;
		}


		public interface ClickResponseListener{
			void onWholeClick(int position);
			void onOverflowClick(View v,int position);
		}
	}
}
