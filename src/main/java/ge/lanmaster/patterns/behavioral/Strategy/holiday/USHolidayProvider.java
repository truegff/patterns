package ge.lanmaster.patterns.behavioral.Strategy.holiday;

import java.util.Date;

public class USHolidayProvider implements HolidayProvider {

	public String[] getHolidays(Date dt) {

		String[] holidays = HolidayProvider.NO_HOLIDAY;

		if (holidays.length == 0) {
			holidays = new String[1];
		}

		holidays[0] = dt.toString();

		return holidays;

	}

}
