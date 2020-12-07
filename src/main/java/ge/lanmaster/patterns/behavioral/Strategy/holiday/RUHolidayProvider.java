package ge.lanmaster.patterns.behavioral.Strategy.holiday;

import java.util.Date;

public class RUHolidayProvider implements HolidayProvider {

	public String[] getHolidays(Date dt) {

		String[] holidays = HolidayProvider.NO_HOLIDAY;

		if (holidays.length == 0) {
			holidays = new String[2];
		}
		holidays[0] = dt.toString();
		holidays[1] = "ololo";

		return holidays;

	}
}
