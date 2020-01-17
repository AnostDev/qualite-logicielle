package agenda;


import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public class Date implements Comparable<Date> {

    private int day;
    private int month;
    private int year;

    Date(int day, int month, int year) throws DateError {

        if( isInvalidYear(year) ) {
            throw new DateError("Year must be greater or equals to 1990");
        }
        else if(isLeap(year)) { // Is a leap year
            if(isInvalidMonth(month)) {
                throw new DateError("Month must be between 1 and 12");
            }
            else  {
                if( month == 2 ) { // is february on leap year
                    if (!isValid29Day(day)) {
                        throw new DateError("Day must be between 1 and 28");
                    }
                }
                else if(is31Month(month) && !isValid31Day(day)) { // Day can go up to 31
                        throw new DateError("Day must be between 1 and 31");
                }

                else if(is30Month(month) && isValid30Day(day))// Day can go up to 30
                        throw new DateError("Day must be between 1 and 30");
            }
        }
        else { // Is not a leap year
            if(isInvalidMonth(month)) {
                throw new DateError("Month must be between 1 and 12");
            }
            else  {
                if( month == 2 ) { // is february on leap year
                    if (!isValid28Day(day))
                        throw new DateError("Day must be between 1 and 28");
                }
                else if (is31Month(month) && !isValid31Day(day)) { // Day can go up to 31
                        throw new DateError("Day must be between 1 and 31");
                }

                else if(is30Month(month) && isValid30Day(day)) // Day can go up to 30
                        throw new DateError("Day must be between 1 and 30");
            }
        }
        this.day = day;
        this.month = month;
        this.year = year;
    }


    private boolean isLeap(int year) {
        boolean response = false;
        response = year % 4 == 0;
                if( year % 100 == 0 )
                    response = year  % 400 == 0;
                return response;
    }

    private List<Integer> MONTH_31 = new ArrayList<Integer> (Arrays.asList(1, 3, 5, 7, 8, 10, 12));
    private List<Integer> MONTH_30 = new ArrayList<Integer> (Arrays.asList(4,6,9,112));
    private static final int IS_MONTH_31 = 31;

    boolean is31Month(int month) {
        return MONTH_31.contains(month);
    }

    boolean isInvalidMonth(int month) {
        return month <= 0 || month > 12;
    }

    boolean isInvalidYear(int year) {
        return year < 1990;
    }

    boolean is30Month(int month) {
        return MONTH_30.contains(month);
    }

    boolean isValid28Day(int day) {
        return day > 0 && day <= 28;
    }

    boolean isValid29Day(int day) {
        return day > 0 && day <= 29;
    }

    boolean isValid30Day(int day) {
        return day <= 0 || day > 30;
    }

    boolean isValid31Day(int day) {
        return day > 0 && day <= 31;
    }


    @Override
    public String toString() {
        return String.format("%02d-%02d-%04d", day, month, year);
    }

    @Override
    public int compareTo(Date o) {
        if(o.getYear() == year && o.getMonth() == month && o.getDay() == day)
            return 0;
        if(year > o.getYear() || (year == o.year && month > o.month ) || (month == o.month && day > o.day))
            return 1;
        return -1;
    }

    boolean isGreater(Date date) {
        return compareTo(date) > 0;
    }
}
