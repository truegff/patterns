package ge.lanmaster.patterns.behavioral.Strategy.holiday;

import java.util.Date;

public interface HolidayProvider {
	String[] NO_HOLIDAY = new String[0];

	/**
	 * Return array of strings describing holidays falling on
	 * given date. If no holidays on the given date, returns
	 * NO HOLIDAY.
	 */
	String[] getHolidays(Date dt);
}
