package com.gan.wcarewebservice.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    static String patternMMMYYYY = "MMM yyyy";

    public static String convertMMMYYY(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patternMMMYYYY);
        String dateString = simpleDateFormat.format(new Date());
        System.out.println(date);
        return dateString;
    }
    //If the date coversion fails, it will return date by adding yeartoAdd years in today's date
    public static Date getDateDefaultToNYear(String dateString, int yearToAdd) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        try {
            date = formatter.parse(dateString);
        } catch (Exception e) {
            e.printStackTrace();
            date = addYearToToday(yearToAdd);
        }
        return date;
    }


    public static Date addYearToToday(int yearToAdd) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, yearToAdd);
        return c.getTime();
    }

}
