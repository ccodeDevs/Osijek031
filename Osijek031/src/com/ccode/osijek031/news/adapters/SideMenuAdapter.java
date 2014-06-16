package com.ccode.osijek031.news.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ccode.osijek031.R;
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
	private Category[] mDataSource = Category.values();

	private Context mContext;

	public SideMenuAdapter(Context context) throws IllegalArgumentException {
		if (context == null) {
			throw new IllegalArgumentException("Context cannot be null!");
		}

		mContext = context;
	}

	@Override
	public int getCount() {
		return mDataSource.length;
	}

	@Override
	public Category getItem(int position) {
		return mDataSource[position];
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		convertView = LayoutInflater.from(mContext).inflate(
				R.layout.item_side_menu, parent, false);

		Category item = getItem(position);
		if (item != null) {
			TextView titleTextView = (TextView) convertView
					.findViewById(R.id.item_side_menu_title);
			titleTextView.setText(item.getName());
		}

		return convertView;
	}
}