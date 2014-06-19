package com.ccode.osijek031.news.activities;

import android.os.Bundle;
import android.view.MenuItem;

import com.ccode.osijek031.R;
import com.ccode.osijek031.base.activities.BaseActivity;
import com.ccode.osijek031.news.fragments.NewsDetailsViewPager;
/**
 * Title: CCode Osijek031 <br />
 * Copyright: Copyright @ 2014 <br />
 * 
 * @author Goran Luketic
 * @version 1.0
 */
public class NewsDetailsActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_container);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		Bundle b = getIntent().getExtras();

		if (b == null) {
			finish();
			return;
		}

		NewsDetailsViewPager f = NewsDetailsViewPager.newInstance(b);
		getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, f).commit();

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case android.R.id.home:
				this.finish();
				break;
			default:
				return super.onOptionsItemSelected(item);
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void initUi() {
		//
	}

	@Override
	protected void initListeners() {
		//
	}

	@Override
	protected void initData() {
		//
	}

}
