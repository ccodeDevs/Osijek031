package com.ccode.osijek031.news.models;

import java.io.Serializable;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import com.ccode.osijek031.base.models.BaseModel;

/**
 * Title: CCode Osijek031 <br />
 * Copyright: Copyright @ 2014 <br />
 * 
 * @author Josip Jurisic
 * @version 1.0
 */

@Root(name = "item")
public class News extends BaseModel implements Serializable {

	private static final long serialVersionUID = -6320967448496535280L;

	private long id;

	@Element(required = false)
	private String title;

	@Element(required = false)
	private String description;

	private String thumbnailPath;

	private String imagePath;

	@Element(name = "pubDate", required = false)
	private String publishedDate;

	@Element(name = "link", required = false)
	private String newsUrl;

	@Element(required = false)
	private String category;

	@Element(name = "comments", required = false)
	private String commentsUrl;

	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getThumbnailPath() {
		return thumbnailPath;
	}

	public String getImagePath() {
		return imagePath;
	}

	public String getPublishedDate() {
		return publishedDate;
	}

	public String getNewsUrl() {
		return newsUrl;
	}

	public String getCategory() {
		return category;
	}

	public String getCommentsUrl() {
		return commentsUrl;
	}
}