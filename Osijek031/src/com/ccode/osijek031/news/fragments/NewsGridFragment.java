package com.ccode.osijek031.news.fragments;

import uk.co.senab.actionbarpulltorefresh.extras.actionbarcompat.PullToRefreshLayout;
import uk.co.senab.actionbarpulltorefresh.library.ActionBarPullToRefresh;
import uk.co.senab.actionbarpulltorefresh.library.listeners.OnRefreshListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import com.android.volley.VolleyError;
import com.ccode.osijek031.R;
import com.ccode.osijek031.base.fragments.BaseFragment;
import com.ccode.osijek031.news.adapters.NewsGridAdapter;
import com.ccode.osijek031.news.managers.NewsDataManager;
import com.ccode.osijek031.news.managers.NewsDataManager.OnNewsLoadedListener;
import com.ccode.osijek031.news.models.News;
import com.ccode.osijek031.news.models.NewsWrapper;
import com.ccode.osijek031.volley.VolleyErrorHelper;

/**
 * Title: CCode Osijek031 <br />
 * Copyright: Copyright @ 2014 <br />
 * 
 * @author Josip Jurisic
 * @version 1.0
 */

public class NewsGridFragment extends BaseFragment implements OnRefreshListener {

	// Pull to refresh
	private PullToRefreshLayout mPullToRefreshLayout;

	// UI Widgets
	private GridView mListView;

	// Adapter
	private NewsGridAdapter mListAdapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View parent = inflater.inflate(R.layout.fragment_news_grid, null);
		initUi(parent);
		return parent;
	}

	@Override
	protected void initUi(View parent) {
		mListView = (GridView) parent
				.findViewById(R.id.fragment_news_grid_gridview);
		mListAdapter = new NewsGridAdapter(getActivity());
		mListView.setAdapter(mListAdapter);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		ViewGroup viewGroup = (ViewGroup) view;
		mPullToRefreshLayout = new PullToRefreshLayout(viewGroup.getContext());
		ActionBarPullToRefresh.from(getActivity()).insertLayoutInto(viewGroup)
				.listener(this).setup(mPullToRefreshLayout);
		initListeners();
		initData();
	}

	@Override
	protected void initListeners() {
		mListView.setOnItemClickListener(mOnItemClickListener);
	}

	private OnItemClickListener mOnItemClickListener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			handleNewsItemClick(position);
		}
	};

	private void handleNewsItemClick(int position) {
		News news = mListAdapter.getItem(position);
		if (news != null) {
			replaceFragment(R.id.activity_news_container,
					NewsDetailsFragment.newInstance(news), true);
		}
	}

	@Override
	protected void initData() {
		refreshData(false);
	}

	private void refreshData(boolean forceNetwork) {
		mPullToRefreshLayout.setRefreshing(true);
		NewsDataManager.getInstance(getActivity()).getNews(mNewsLoadedListener,
				forceNetwork);
	}

	private OnNewsLoadedListener mNewsLoadedListener = new OnNewsLoadedListener() {

		@Override
		public void onResponse(NewsWrapper news) {
			mPullToRefreshLayout.setRefreshComplete();
			handleNewsResponse(news);
		}

		@Override
		public void onError(VolleyError error) {
			mPullToRefreshLayout.setRefreshComplete();
			VolleyErrorHelper.handleErrorWithToast(error, getActivity());
		}
	};

	private void handleNewsResponse(NewsWrapper news) {
		if (news == null) {
			return;
		}

		mListAdapter.setData(news.getChannel().getNews());
	}

	@Override
	public void onRefreshStarted(View view) {
		refreshData(true);
	}

	public static BaseFragment newInstance() {
		return new NewsGridFragment();
	}

}