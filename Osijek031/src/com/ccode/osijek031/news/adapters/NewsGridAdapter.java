package com.ccode.osijek031.news.adapters;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ccode.osijek031.R;
import com.ccode.osijek031.base.adapters.InfiniteBaseAdapter;
import com.ccode.osijek031.news.models.News;
import com.ccode.osijek031.news.models.NewsWrapper;
import com.ccode.osijek031.utils.RoundedTransformation;
import com.squareup.picasso.Picasso;

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
		mDataSource.getChannel().clear();
		mDataSource.getChannel().setNews(news);
		notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		return mDataSource.getChannel().getNews().size();
	}

	@Override
	public News getItem(int position) {
		return mDataSource.getChannel().getNews().get(position);
	}

	@Override
	public long getItemId(int position) {
		return mDataSource.getChannel().getNews().get(position).getId();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = LayoutInflater.from(mContext).inflate(
					R.layout.item_news_grid, parent, false);
			mViewHolder = new ViewHolder();
			initViewHolderChilds(convertView);
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
		String title = item.getTitle();
		if (!TextUtils.isEmpty(title)) {
			mViewHolder.mTitleText.setText(title);
		}

		String imagePath = item.getDescription();
		if (!TextUtils.isEmpty(imagePath)) {
			Pattern p = Pattern
					.compile("<img[^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>");
			Matcher m = p.matcher(imagePath);
			if (m.find()) {
				imagePath = m.group(1);
			}
			int radius = mContext.getResources().getDimensionPixelSize(
					R.dimen.list_image_radius);

			Picasso.with(mContext)
					.load(imagePath)
					.resizeDimen(R.dimen.list_image_width,
							R.dimen.list_image_height)
					.transform(new RoundedTransformation(radius, 0))
					.placeholder(R.drawable.logo).into(mViewHolder.mImage);
		}
	}

	private void initViewHolderChilds(View parent) {
		mViewHolder.mTitleText = (TextView) parent
				.findViewById(R.id.item_news_grid_title);

		mViewHolder.mImage = (ImageView) parent
				.findViewById(R.id.item_news_grid_image);
	}

	@Override
	public int getTotalItems() {
		// TODO TBD
		return 0;
	}

	private static class ViewHolder {
		private TextView mTitleText;
		private ImageView mImage;
	}
}