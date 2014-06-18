package com.ccode.osijek031.news.fragments;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ccode.osijek031.R;
import com.ccode.osijek031.base.fragments.BaseFragment;
import com.ccode.osijek031.news.models.News;

/**
 * Title: CCode Osijek031 <br />
 * Copyright: Copyright @ 2014 <br />
 * 
 * @author Zoran Veres
 * @version 1.0
 */

public class NewsDetailsFragment extends BaseFragment {

	private News mNews;

	private static final String KEY_BUNDLE_NEWS = "key_bundle_news";

	private ImageView mImageViewThump;
	private TextView mTextViewDate;
	private TextView mTextViewTitle;
	private TextView mTextViewDescription;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View parent = inflater.inflate(R.layout.fragment_news_details, null);
		initUi(parent);

		Bundle args = getArguments();
		if (args != null) {
			initNews(args);
		}

		setNewsDetails();

		return parent;
	}

	@Override
	protected void initUi(View parent) {

		mImageViewThump = (ImageView) parent.findViewById(R.id.fragment_news_details_imageview);
		mTextViewDate = (TextView) parent.findViewById(R.id.fragment_news_details_date_textview);
		mTextViewTitle = (TextView) parent.findViewById(R.id.fragment_news_details_title_textview);
		mTextViewDescription = (TextView) parent.findViewById(R.id.fragment_news_details_description_textview);

	}

	@Override
	protected void initListeners() {

	}

	@Override
	protected void initData() {

	}

	private void initNews(Bundle args) {

		if (args.containsKey(KEY_BUNDLE_NEWS)) {
			mNews = (News) args.getSerializable(KEY_BUNDLE_NEWS);
		}

	}

	public static NewsDetailsFragment newInstance(News news) {

		NewsDetailsFragment newsDetailsFragment = new NewsDetailsFragment();
		Bundle args = new Bundle();
		args.putSerializable(KEY_BUNDLE_NEWS, news);
		newsDetailsFragment.setArguments(args);

		return newsDetailsFragment;
	}

	private void setNewsDetails() {

		mImageViewThump.setImageResource(R.drawable.logo);
		mTextViewDate.setText(mNews.getPublishedDate());
		mTextViewTitle.setText(mNews.getTitle());
		mTextViewDescription.setText(mNews.getDescription());

	}

}
