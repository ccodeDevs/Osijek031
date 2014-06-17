package com.ccode.osijek031.news.models;

import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "channel")
public class Channel {

	@ElementList(inline = true, entry = "item")
	private List<News> news;

	public List<News> getNews() {
		return news;
	}
}