package com.ccode.osijek031.news.models;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import com.ccode.osijek031.base.models.BaseModel;

/**
 * Title: CCode Osijek031 <br />
 * Copyright: Copyright @ 2014 <br />
 * 
 * @author Josip Jurisic
 * @version 1.0
 */

@Root(name = "channel")
public class NewsWrapper extends BaseModel {

	@ElementList(entry = "item", data = true, inline = true)
	private List<News> mDataSource;

	public NewsWrapper() {
		initObjects();
	}

	private void initObjects() {
		mDataSource = new ArrayList<News>();
	}

	public List<News> getNews() {
		return mDataSource;
	}

	public News getNews(long id) {
		for (News news : mDataSource) {
			if (news.getId() == id) {
				return news;
			}
		}
		return null;
	}

	public void setNews(List<News> news) {
		this.mDataSource.clear();
		this.mDataSource.addAll(news);
	}

	public void clear() {
		this.mDataSource.clear();
	}
}