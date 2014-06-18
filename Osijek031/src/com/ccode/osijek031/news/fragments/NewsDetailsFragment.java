package com.ccode.osijek031.news.fragments;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ccode.osijek031.R;
import com.ccode.osijek031.base.fragments.BaseFragment;
import com.ccode.osijek031.news.models.News;
import com.squareup.picasso.Picasso;

/**
 * Title: CCode Osijek031 <br />
 * Copyright: Copyright @ 2014 <br />
 * 
 * @author Zoran Veres
 * @version 1.0
 */

public class NewsDetailsFragment extends BaseFragment {

	// Bundle keys
	private static final String KEY_BUNDLE_NEWS = "key_bundle_news";

	// Ui widgets
	private ImageView mNewsImage;
	private TextView mDateText;
	private TextView mTitleText;
	private TextView mDescriptionText;

	// Datasource
	private News mNews;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Bundle args = getArguments();
		if (args != null) {
			initBundle(args);
		}
	}

	private void initBundle(Bundle args) {
		if (args.containsKey(KEY_BUNDLE_NEWS)) {
			mNews = (News) args.getSerializable(KEY_BUNDLE_NEWS);
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View parent = inflater.inflate(R.layout.fragment_news_details, null);
		initUi(parent);
		return parent;
	}

	@Override
	protected void initUi(View parent) {
		mNewsImage = (ImageView) parent
				.findViewById(R.id.fragment_news_details_imageview);
		mDateText = (TextView) parent
				.findViewById(R.id.fragment_news_details_date_textview);
		mTitleText = (TextView) parent
				.findViewById(R.id.fragment_news_details_title_textview);
		mDescriptionText = (TextView) parent
				.findViewById(R.id.fragment_news_details_description_textview);
	}

	@Override
	protected void initListeners() {
		// ok nothing
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		initData();
	}

	@Override
	protected void initData() {
		setNewsDetails();
	}

	private void setNewsDetails() {
		String imagePath = mNews.getDescription();
		if (!TextUtils.isEmpty(imagePath)) {
			Pattern p = Pattern
					.compile("<img[^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>");
			Matcher m = p.matcher(imagePath);
			if (m.find()) {
				imagePath = m.group(1);
			}

			Picasso.with(getActivity()).load(imagePath)
					.placeholder(R.drawable.logo).into(mNewsImage);
		}

		mDateText.setText(mNews.getPublishedDate());
		mTitleText.setText(Html.fromHtml(mNews.getTitle()));
		mDescriptionText.setText(Html.fromHtml(mNews.getDescription()));
	}

	public static NewsDetailsFragment newInstance(News news) {
		Bundle args = new Bundle();
		args.putSerializable(KEY_BUNDLE_NEWS, news);

		NewsDetailsFragment newsDetailsFragment = new NewsDetailsFragment();
		newsDetailsFragment.setArguments(args);
		return newsDetailsFragment;
	}
}