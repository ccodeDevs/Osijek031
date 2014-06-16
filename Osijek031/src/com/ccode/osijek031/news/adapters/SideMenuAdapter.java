package com.ccode.osijek031.news.adapters;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.ccode.osijek031.R;
import com.ccode.osijek031.news.models.CategoriesWrapper;
import com.ccode.osijek031.news.models.Category;

/**
 * Title: CCode Osijek031 <br />
 * Copyright: Copyright @ 2014 <br />
 * 
 * @author Josip Jurisic
 * @version 1.0
 */


public class SideMenuAdapter extends BaseAdapter {

	// Data Source
	private CategoriesWrapper mDataSource = new CategoriesWrapper();

	private Context mContext;
	private ViewHolder mViewHolder;

	public SideMenuAdapter(Context context) throws IllegalArgumentException {
		if (context == null) {
			throw new IllegalArgumentException("Context cannot be null!");
		}

		mContext = context;
	}

	public void setData(List<Category> categories) {
		mDataSource.clear();
		mDataSource.setCategories(categories);
		notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		return mDataSource.getCategories().size();
	}

	@Override
	public Category getItem(int position) {
		return mDataSource.getCategories().get(position);
	}

	@Override
	public long getItemId(int position) {
		return mDataSource.getCategories().get(position).getId();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = LayoutInflater.from(mContext).inflate(
					R.layout.item_news_list, parent, false);
			mViewHolder = new ViewHolder();
			initViewHolderChilds();
			convertView.setTag(mViewHolder);
		} else {
			mViewHolder = (ViewHolder) convertView.getTag();
		}

		Category item = getItem(position);
		if (item != null) {
			fillViewHolderWithData(item);
		}

		return convertView;
	}

	private void fillViewHolderWithData(Category item) {
		// TODO TBD
	}

	private void initViewHolderChilds() {
	}

	private static class ViewHolder {
		// TODO TBD
	}
}