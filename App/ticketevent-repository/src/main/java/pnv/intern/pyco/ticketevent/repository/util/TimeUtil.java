package pnv.intern.pyco.ticketevent.repository.util;

import java.util.Calendar;
import java.util.Date;

public class TimeUtil {
	private static final Calendar INSTANT  = new Calendar.Builder().build();;
	public static Calendar convertDateToCalendar(Date date) {
		INSTANT.setTime(date);
		return INSTANT;
	}
}
