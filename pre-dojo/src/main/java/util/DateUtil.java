package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY hh:mm:ss");
	
	public static String getFormattedDate() {
		return sdf.format(Calendar.getInstance().getTime());
	}

	public static Calendar stringToCalendar(String date) {
		Calendar calendar = Calendar.getInstance();
		
		try {
			Date d = sdf.parse(date);
			calendar.setTime(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return calendar;
	}
	
}
