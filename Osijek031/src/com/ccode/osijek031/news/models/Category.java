package com.ccode.osijek031.news.models;

import com.ccode.osijek031.R;

/**
 * Title: CCode Osijek031 <br />
 * Copyright: Copyright @ 2014 <br />
 * 
 * @author Josip Jurisic
 * @version 1.0
 */

public enum Category {

	OSIJEK031(R.string.osijek031), CULTURE(R.string.culture), EDUCATION(
			R.string.education), NIGHTLIFE(R.string.nightlife), LIFE(
			R.string.life), COMMUNIS(R.string.communis), ECONOMY(
			R.string.economy), CYBER(R.string.cyber), POLITICS(
			R.string.politics), SPORT(R.string.sport);

	public int name;

	Category(int name) {
		this.name = name;
	}

	public int getName() {
		return name;
	}
}