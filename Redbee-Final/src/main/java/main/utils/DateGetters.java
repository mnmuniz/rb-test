package main.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateGetters {
	
	public String getDate(Integer diffDays, String format){
		if (format.equals(null) || "".equals(format))
			format = "yyyy-MM-dd";
		
		Calendar calendar = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat(format);
		
		Date date = new Date();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_YEAR, diffDays);
		
		String now = dateFormat.format(calendar.getTime());
		
		return now;
	}
	
	public String getGuionedYMDDate(Integer diffDays){
		String format = "yyyy-MM-dd";
		
		Calendar calendar = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat(format);
		
		Date date = new Date();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_YEAR, diffDays);
		
		String now = dateFormat.format(calendar.getTime());
		
		return now;
	}
	
	public String getUSDate(String format) {
		if (format.equals(null) || "".equals(format))
			format = "yyyy-MM-dd";
		
		DateFormat dateFormat = new SimpleDateFormat(format);
		Date date = new Date();
		
		TimeZone tzInAmerica = TimeZone.getTimeZone("America/New_York");
		dateFormat.setTimeZone(tzInAmerica);
		
		String now = dateFormat.format(date);
		
		return now;
	}


public String getDateVal(Integer diffDays, String format){
	if (format.equals(null) || "".equals(format))
		format = "yyyy-MM-dd HH:MM:ss";
	
	Calendar calendar = Calendar.getInstance();
	DateFormat dateFormat = new SimpleDateFormat(format);
	
	Date date = new Date();
	calendar.setTime(date);
	calendar.add(Calendar.DAY_OF_YEAR, diffDays);
	
	String now = dateFormat.format(calendar.getTime());
	
	return now;
}
}