package ge.lanmaster.patterns.behavioral.Strategy;

import ge.lanmaster.patterns.behavioral.Strategy.holiday.HolidayProvider;

import java.util.Date;

public class CalendarDisplay {
	private HolidayProvider holiday;

	public void setHolidayProvider(HolidayProvider holidayProvider) {
		this.holiday = holidayProvider;
	}

	/**
	 * Instances of this private class are used to cache
	 * information about dates that are to be displayed.
	 */
	private class DateCache {
		private Date date;
		private String[] holidayStrings;

		DateCache(Date dt) {
			date = dt;

			if (holiday == null) {
				holidayStrings = holiday.NO_HOLIDAY;
			} else {
				holidayStrings = holiday.getHolidays(date);
			}
		}
	}

	public String[] display(Date dt) {
		DateCache dtc = new DateCache(dt);
		return dtc.holidayStrings;
	}
}