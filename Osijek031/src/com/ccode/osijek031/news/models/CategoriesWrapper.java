package com.ccode.osijek031.news.models;

import java.util.ArrayList;
import java.util.List;

import com.ccode.osijek031.base.models.BaseModel;

/**
 * Title: CCode Osijek031 <br />
 * Copyright: Copyright @ 2014 <br />
 * 
 * @author Josip Jurisic
 * @version 1.0
 */

public class CategoriesWrapper extends BaseModel {

	private List<Category> mDataSource;

	public CategoriesWrapper() {
		initObjects();
	}

	private void initObjects() {
		mDataSource = new ArrayList<Category>();
	}

	public List<Category> getCategories() {
		return mDataSource;
	}

	public Category getCategory(long id) {
		for (Category category : mDataSource) {
			if (category.getId() == id) {
				return category;
			}
		}
		return null;
	}

	public void setCategories(List<Category> category) {
		this.mDataSource.clear();
		this.mDataSource.addAll(category);
	}

	public void clear() {
		this.mDataSource.clear();
	}
}