package ge.lanmaster.pattern.Strategy;

import java.util.Date;

/**
 * @author alexander
 */
public class RUHoliday implements HolidaySetIF {

    public String[] getHolidays(Date dt) {

        String[] holidays = HolidaySetIF.NO_HOLIDAY;

        if (holidays.length == 0)
        holidays = new String[2];
        holidays[0] = dt.toString();
        holidays[1] = "ololo";

        return holidays;
    } // getHolidays(Date)
} // class USHoliday
