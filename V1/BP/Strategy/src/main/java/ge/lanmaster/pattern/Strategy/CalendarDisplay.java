package ge.lanmaster.pattern.Strategy;

import java.util.Date;

/**
 * @author alexander
 */
public class CalendarDisplay {
    private HolidaySetIF holiday;

    public void setHolidayProvider(HolidaySetIF hsif) {
        this.holiday = hsif;
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
            } // if
        } // constructor(Date)
    } // class DateCache

    public String[] display(Date dt) {
        DateCache dtc = new DateCache(dt);
        return dtc.holidayStrings;
    }
} // class CalendarDisplay