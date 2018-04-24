package com.goshop.app.utils;

import com.goshop.app.Const;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormater {

    private static final String YYYYMMDD = "yyyy-MM-dd";

    private static final String DDMMYY = "dd/MM/yy";

    private static final String DDMMYYYY = "dd/MM/yyyy";

    private static final String DIAGONAL = "-";

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

    public static String getAbbreviationDate(String time) {
        String[] arrays =   time.split(DIAGONAL);
        int year = Integer.parseInt(arrays[0]);
        int mouth = Integer.parseInt(arrays[1]);
        int day = Integer.parseInt(arrays[2]);
        return getAbbreviationDate(year, mouth, day);
    }

    public static String getAbbreviationDate(int year, int mouth, int day) {
        StringBuilder result = new StringBuilder();
        if (day < 10) {
            result.append(0);
        }
        result.append(day).append("\t\t").append(getMouth(mouth)).append("\t\t").append(year);
        return result.toString();
    }

    private static String getMouth(int mouth) {
        String result = "";
        switch (mouth) {
            case Const.VALUE_JANUARY:
                result = Const.JAN;
                break;
            case Const.VALUE_FEBRUARY:
                result = Const.FEB;
                break;
            case Const.VALUE_MARCH:
                result = Const.MAR;
                break;
            case Const.VALUE_APRIL:
                result = Const.APR;
                break;
            case Const.VALUE_MAY:
                result = Const.MAY;
                break;
            case Const.VALUE_JUNE:
                result = Const.JUN;
                break;
            case Const.VALUE_JULY:
                result = Const.JUL;
                break;
            case Const.VALUE_AUGUST:
                result = Const.AUG;
                break;
            case Const.VALUE_SEPTEMBER:
                result = Const.SEP;
                break;
            case Const.VALUE_OCTOBER:
                result = Const.OCT;
                break;
            case Const.VALUE_NOVEMBER:
                result = Const.NOV;
                break;
            case Const.VALUE_DECEMBER:
                result = Const.DEC;
                break;
        }
        return result;
    }
}