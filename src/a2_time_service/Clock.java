package a2_time_service;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Clock {
	private static SimpleDateFormat timeFormatter = new SimpleDateFormat("kk:mm:ss");
	private static SimpleDateFormat dateFormatter = new SimpleDateFormat("dd.MM.yyyy");
	private static Date now = new Date();
	
	public static String getDate() {
		now.setTime(System.currentTimeMillis());
		return dateFormatter.format(now);
	}
	
	public static String getTime() {
		now.setTime(System.currentTimeMillis());
		return timeFormatter.format(now);
	}

	
}
