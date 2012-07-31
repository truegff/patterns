package ge.lanmaster.pattern.Strategy;

import java.util.Date;

/**
 * @author alexander
 */
public interface HolidaySetIF {
    public String[] NO_HOLIDAY = new String[0];

    /**
     * Return array of strings describing holidays falling on
     * given date. If no holidays on the given date, returns
     * NO HOLIDAY.
     */
    public String[] getHolidays(Date dt);
} // interface HolidaySetIF
