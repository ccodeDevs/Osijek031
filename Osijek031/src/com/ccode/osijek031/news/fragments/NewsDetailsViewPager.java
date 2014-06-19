package com.ccode.osijek031.news.fragments;

import java.util.ArrayList;
import java.util.List;

import com.android.volley.VolleyError;
import com.ccode.osijek031.R;
import com.ccode.osijek031.base.fragments.BaseFragment;
import com.ccode.osijek031.news.managers.NewsDataManager;
import com.ccode.osijek031.news.managers.NewsDataManager.OnNewsLoadedListener;
import com.ccode.osijek031.news.models.News;
import com.ccode.osijek031.news.models.NewsWrapper;
import com.ccode.osijek031.volley.VolleyErrorHelper;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Title: CCode Osijek031 <br />
 * Copyright: Copyright @ 2014 <br />
 * 
 * @author Goran Luketic
 * @version 1.0
 */
public class NewsDetailsViewPager extends BaseFragment {

	private static final String STATE_POSITION = "state_position";

	private ViewPager mViewPager;
	private PagerAdapter mPagerAdapter;
	private List<News> mListNews;
	private int mPosition = -1;

	private Bundle mArgs;

	public static NewsDetailsViewPager newInstance(Bundle b) {
		NewsDetailsViewPager f = new NewsDetailsViewPager();
		f.setArguments(b);
		return f;
	}

	public NewsDetailsViewPager() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_news_viewpager, container, false);
		initUi(v);
		return v;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		if (savedInstanceState != null) {
			mPosition = savedInstanceState.getInt(STATE_POSITION, -1);
		}
		initData();
	}

	@Override
	protected void initUi(View parent) {
		mViewPager = (ViewPager) parent.findViewById(R.id.news_details_viewpager);
	}

	@Override
	protected void initListeners() {
		//
	}

	@Override
	protected void initData() {
		mArgs = getArguments();
		if (mArgs == null) {
			return;
		}
		mPagerAdapter = new PagerAdapter(getChildFragmentManager());
		mViewPager.setAdapter(mPagerAdapter);
		NewsDataManager.getInstance(getActivity()).getNews(mNewsLoadedListener, false);

	}

	private OnNewsLoadedListener mNewsLoadedListener = new OnNewsLoadedListener() {

		@Override
		public void onResponse(NewsWrapper news) {
			mListNews = news.getChannel().getNews();

			if (mListNews == null) {
				return;
			}
			setData();
		}

		@Override
		public void onError(VolleyError error) {
			VolleyErrorHelper.handleErrorWithToast(error, getActivity());
		}
	};

	private void setData() {
		mPagerAdapter.setData(mListNews);

		if (mPosition == -1) {
			News newsItem = (News) mArgs.getSerializable(NewsDetailsFragment.KEY_BUNDLE_NEWS);

			if (newsItem == null) {
				mPosition = 0;
			} else {
				for (int i = 0; i < mListNews.size(); i++) {
					if (getNewsId(mListNews.get(i)) == getNewsId(newsItem)) {
						mPosition = i;
					}
				}
			}
			if (mPosition < 0 || mPosition >= mListNews.size()) {
				mPosition = 0;
			}
		}
		mViewPager.setCurrentItem(mPosition);
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt(STATE_POSITION, mPosition);
	}
	
	public long getNewsId(News news){
		String link = news.getNewsUrl();
		if(!TextUtils.isEmpty(link)){
			String[] parts = link.split("topic_id=");
			long id = Long.valueOf(parts[1]);
			return id;
		}
		return 0;
	}

	private class PagerAdapter extends FragmentPagerAdapter {

		private List<News> mNewsList;

		public PagerAdapter(FragmentManager fm) {
			super(fm);
			mNewsList = new ArrayList<News>();
		}

		public void setData(List<News> newsList) {
			mNewsList.clear();
			if (newsList != null) {
				mNewsList = newsList;
			}
			notifyDataSetChanged();
		}

		@Override
		public Fragment getItem(int position) {
			Bundle bundle = new Bundle();
			bundle.putSerializable(NewsDetailsFragment.KEY_BUNDLE_NEWS, mNewsList.get(position));
			return NewsDetailsFragment.newInstance(bundle);
		}

		@Override
		public int getCount() {
			return mNewsList.size();
		}

	}
}
