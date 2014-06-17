package com.ccode.osijek031.news.models;

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

@Root
public class NewsWrapper extends BaseModel {

	@Element(name = "channel")
	private Channel channel;

	public Channel getChannel() {
		return channel;
	}
}