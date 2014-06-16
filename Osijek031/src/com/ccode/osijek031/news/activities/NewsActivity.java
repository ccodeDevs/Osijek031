package com.ccode.osijek031.news.activities;

import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.widget.ListView;

import com.ccode.osijek031.R;
import com.ccode.osijek031.base.activities.BaseActivity;
import com.ccode.osijek031.news.adapters.SideMenuAdapter;
import com.ccode.osijek031.news.fragments.NewsGridFragment;

/**
 * Title: CCode Osijek031 <br />
 * Copyright: Copyright @ 2014 <br />
 * 
 * @author Josip Jurisic
 * @version 1.0
 */

public class NewsActivity extends BaseActivity {

	// navigation drawer
	private DrawerLayout mDrawerLayout;
	private ListView mSideMenuListView;
	private SideMenuAdapter mSideMenuAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_news);

		ActionBar actionBar = getSupportActionBar();
		if (actionBar != null) {
			configureActionBar(actionBar);
		}

		initUi();
		initListeners();

		if (savedInstanceState == null) {
			showNewsFragment();
		}
	}

	@Override
	protected void initUi() {
		initSideMenu();
	}

	private void initSideMenu() {
		mDrawerLayout = (DrawerLayout) findViewById(R.id.activity_news_drawer_layout);
		mSideMenuListView = (ListView) findViewById(R.id.activity_news_drawer_list);
		mSideMenuAdapter = new SideMenuAdapter(this);
		mSideMenuListView.setAdapter(mSideMenuAdapter);
	}

	private void configureActionBar(ActionBar actionBar) {
		actionBar.setDisplayHomeAsUpEnabled(false);
		actionBar.setDisplayShowHomeEnabled(false);
		actionBar.setDisplayUseLogoEnabled(false);
		actionBar.setHomeButtonEnabled(false);
		actionBar.setDisplayShowTitleEnabled(false);
	}

	@Override
	protected void initListeners() {
		mDrawerLayout.setDrawerListener(new ActionBarDrawerToggle(this,
				mDrawerLayout, R.drawable.ic_drawer, R.string.app_name,
				R.string.app_name));
	}

	private void showNewsFragment() {
		replaceFragment(R.id.activity_news_container,
				NewsGridFragment.newInstance(), true);
	}

	@Override
	protected void initData() {
		// ok nothing
	}
}