package com.ccode.osijek031.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.annotation.SuppressLint;
import android.text.TextUtils;
/**
 * Title: CCode Osijek031 <br />
 * Copyright: Copyright @ 2014 <br />
 * 
 * @author Goran Luketic
 * @version 1.0
 */
public class DateTimeUtils {

	private static final String DATE_FORMAT = "EEE, d MMM yyyy HH:mm:ss Z";

	/**
	 * Retrieve date object from string
	 */
	@SuppressLint("SimpleDateFormat")
	public static Date getDateFromString(String dateString) {
		if (!TextUtils.isEmpty(dateString)) {
			SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
			try {
				return sdf.parse(dateString);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
