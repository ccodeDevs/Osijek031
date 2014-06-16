package com.ccode.osijek031.splash.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ccode.osijek031.R;
import com.ccode.osijek031.base.fragments.BaseFragment;

/**
 * Title: CCode Osijek031 <br />
 * Copyright: Copyright @ 2014 <br />
 * 
 * @author Josip Jurisic
 * @version 1.0
 */

public class SplashFragment extends BaseFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View parent = inflater.inflate(R.layout.fragment_splash, null);
		return parent;
	}

	@Override
	protected void initUi(View parent) {
		// ok nothing here
	}

	@Override
	protected void initListeners() {
		// ok nothing here
	}

	@Override
	protected void initData() {
		// ok nothing here
	}

	public static BaseFragment newInstance() {
		return new SplashFragment();
	}
}