package ge.lanmaster.patterns.behavioral.Strategy;

import ge.lanmaster.patterns.behavioral.Strategy.holiday.HolidayProvider;
import ge.lanmaster.patterns.behavioral.Strategy.holiday.RUHolidayProvider;
import ge.lanmaster.patterns.behavioral.Strategy.holiday.USHolidayProvider;
import ge.lanmaster.patterns.behavioral.Strategy.operation.Operation;
import ge.lanmaster.patterns.behavioral.Strategy.operation.UserOperation;

import java.util.Date;

public class App {

	public static void main(String[] args) {
		System.out.println("Strategy Pattern");

		// Demo 1
		HolidayProvider holidayProvider = new USHolidayProvider();
		CalendarDisplay calendarDisplay = new CalendarDisplay();
		calendarDisplay.setHolidayProvider(holidayProvider);
		String[] result = calendarDisplay.display(new Date(299));
		for (String string : result) {
			System.out.println(string);
		}
		System.out.println();
		calendarDisplay.setHolidayProvider(new RUHolidayProvider());
		result = calendarDisplay.display(new Date(299));
		for (String string : result) {
			System.out.println(string);
		}

		// Demo 2
		Operation userOperation = new UserOperation();
		System.out.println();
		System.out.println(userOperation.operation(new Double(4), new Double(3)));
		System.out.println(userOperation.operation(new Double(2), new Double(3)));
	}
}
