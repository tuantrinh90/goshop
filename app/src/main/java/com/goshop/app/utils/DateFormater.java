package com.goshop.app.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormater {

    private static final String YYYYMMDD = "yyyy-MM-dd";

    private static final String DDMMYY = "dd/MM/yy";

    private static final String DDMMYYYY = "dd/MM/yyyy";

    public static String formaterDDMMYY(String yyyyMMDD) {
        SimpleDateFormat fromFormat = new SimpleDateFormat(YYYYMMDD);
        SimpleDateFormat toFormat = new SimpleDateFormat(DDMMYY);
        String result = "";
        try {
            Date date = fromFormat.parse(yyyyMMDD);
            result = toFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }
    public static String formaterDDMMYYYY(String yyyyMMDD) {
        SimpleDateFormat fromFormat = new SimpleDateFormat(YYYYMMDD);
        SimpleDateFormat toFormat = new SimpleDateFormat(DDMMYYYY);
        String result = "";
        try {
            Date date = fromFormat.parse(yyyyMMDD);
            result = toFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }
}
