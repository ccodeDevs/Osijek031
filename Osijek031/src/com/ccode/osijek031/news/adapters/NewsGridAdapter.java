package com.ccode.osijek031.news.adapters;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ccode.osijek031.R;
import com.ccode.osijek031.base.adapters.InfiniteBaseAdapter;
import com.ccode.osijek031.news.models.News;
import com.ccode.osijek031.news.models.NewsWrapper;

/**
 * Title: CCode Osijek031 <br />
 * Copyright: Copyright @ 2014 <br />
 * 
 * @author Josip Jurisic
 * @version 1.0
 */

public class NewsGridAdapter extends InfiniteBaseAdapter {

	// Data Source
	private NewsWrapper mDataSource = new NewsWrapper();

	private Context mContext;
	private ViewHolder mViewHolder;

	public NewsGridAdapter(Context context) throws IllegalArgumentException {
		if (context == null) {
			throw new IllegalArgumentException("Context cannot be null!");
		}

		mContext = context;
	}

	public void setData(List<News> news) {
		mDataSource.clear();
		mDataSource.setNews(news);
		notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		return mDataSource.getNews().size();
	}

	@Override
	public News getItem(int position) {
		return mDataSource.getNews().get(position);
	}

	@Override
	public long getItemId(int position) {
		return mDataSource.getNews().get(position).getId();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = LayoutInflater.from(mContext).inflate(
					R.layout.item_news_grid, parent, false);
			mViewHolder = new ViewHolder();
			initViewHolderChilds();
			convertView.setTag(mViewHolder);
		} else {
			mViewHolder = (ViewHolder) convertView.getTag();
		}

		News item = getItem(position);
		if (item != null) {
			fillViewHolderWithData(item);
		}

		return convertView;
	}

	private void fillViewHolderWithData(News item) {
		// TODO TBD
	}

	private void initViewHolderChilds() {
	}

	@Override
	public int getTotalItems() {
		// TODO TBD
		return 0;
	}

	private static class ViewHolder {
		// TODO TBD
	}
}