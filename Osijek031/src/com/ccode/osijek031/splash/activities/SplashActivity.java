package com.ccode.osijek031.splash.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.view.View;

import com.ccode.osijek031.R;
import com.ccode.osijek031.base.activities.BaseActivity;
import com.ccode.osijek031.news.activities.NewsActivity;
import com.ccode.osijek031.splash.fragments.SplashFragment;
import com.ccode.osijek031.utils.SystemUiHider;

/**
 * Title: CCode Osijek031 <br />
 * Copyright: Copyright @ 2014 <br />
 * 
 * @author Josip Jurisic
 * @version 1.0
 */

public class SplashActivity extends BaseActivity {

	private SystemUiHider mSystemUiHider;

	private Handler mNextActivityHandler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);

		ActionBar actionBar = getSupportActionBar();
		if (actionBar != null) {
			configureActionBar(actionBar);
		}

		initUi();

		if (savedInstanceState == null) {
			addSplashFragment();
		}
	}

	private void configureActionBar(ActionBar actionBar) {
		actionBar.hide();
	}

	private void addSplashFragment() {
		replaceFragment(R.id.activity_splash_content_container,
				SplashFragment.newInstance(), false);
	}

	@Override
	protected void initUi() {
		mNextActivityHandler = new Handler();
		initUiHider();
	}

	private void initUiHider() {
		View anchorView = findViewById(R.id.ui_hider_anchor);
		mSystemUiHider = SystemUiHider.getInstance(this, anchorView,
				SystemUiHider.FLAG_HIDE_NAVIGATION);
		mSystemUiHider.setup();
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);

		mSystemUiHider.hide();
	}

	@Override
	protected void onStop() {
		super.onStop();
		cancelNextActivityOpeningTask();
	}

	private void cancelNextActivityOpeningTask() {
		mNextActivityHandler.removeCallbacks(mRunnable);
	}

	@Override
	protected void onStart() {
		super.onStart();
		startNextActivityTask();
	}

	private void startNextActivityTask() {
		mNextActivityHandler.postDelayed(mRunnable, 2000);
	}

	private Runnable mRunnable = new Runnable() {

		@Override
		public void run() {
			startNextActivity();
		}
	};

	private void startNextActivity() {
		Intent intent = new Intent(this, NewsActivity.class);
		startActivity(intent);
		finish();
	}

	@Override
	protected void initListeners() {
		// ok nothing
	}

	@Override
	protected void initData() {
		// ok nothing
	}
}