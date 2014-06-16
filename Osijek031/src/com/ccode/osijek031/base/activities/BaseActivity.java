package com.ccode.osijek031.base.activities;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;

import com.ccode.osijek031.base.fragments.BaseFragment;

/**
 * Title: CCode Osijek031 <br />
 * Copyright: Copyright @ 2014 <br />
 * 
 * @author Josip Jurisic
 * @version 1.0
 */

public abstract class BaseActivity extends ActionBarActivity {

	protected abstract void initUi();

	protected abstract void initListeners();

	protected abstract void initData();

	protected void replaceFragment(int layoutId, BaseFragment fragment,
			boolean addToBackStack) {
		FragmentManager manager = getSupportFragmentManager();
		FragmentTransaction transaction = manager.beginTransaction();
		transaction.replace(layoutId, fragment);
		if (addToBackStack) {
			transaction.addToBackStack(fragment.getTag());
		}
		transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
		transaction.commit();
	}
}