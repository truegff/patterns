package ge.lanmaster.pattern.Strategy;

import java.util.Date;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        System.out.println("Strategy Pattern");

        // Demo 1
        HolidaySetIF hsif = new USHoliday();
        CalendarDisplay cd = new CalendarDisplay();
        cd.setHolidayProvider(hsif);
        String[] result = cd.display(new Date(299));
        for (String string : result) {
            System.out.println(string);
        }
        System.out.println();
        cd.setHolidayProvider(new RUHoliday());
        result = cd.display(new Date(299));
        for (String string : result) {
            System.out.println(string);
        }

        // Demo 2
        OperationUser ou = new OperationUser();
        System.out.println();
        System.out.println(ou.doSomething(new Double(4), new Double(3)));
        System.out.println(ou.doSomething(new Double(2), new Double(3)));
    }
}
