package com.capital.dragon.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class UtillClass {
	public static Date getDateFromString(String dateStr) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = formatter.parse(dateStr);
		return date;
	}

}
