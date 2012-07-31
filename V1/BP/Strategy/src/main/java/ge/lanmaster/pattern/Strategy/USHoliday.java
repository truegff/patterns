package ge.lanmaster.pattern.Strategy;

import java.util.Date;

/**
 * @author alexander
 */
public class USHoliday implements HolidaySetIF {

    public String[] getHolidays(Date dt) {

        String[] holidays = HolidaySetIF.NO_HOLIDAY;

        if (holidays.length == 0)
        holidays = new String[1];
        holidays[0] = dt.toString();

        return holidays;
    } // getHolidays(Date)
} // class USHoliday
