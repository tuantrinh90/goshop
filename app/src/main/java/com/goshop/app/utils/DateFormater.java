package com.goshop.app.utils;

import com.goshop.app.Const;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFormater {

    private static final String YYYYMMDD = "yyyy-MM-dd";

    private static final String DDMMYY = "dd/MM/yy";

    private static final String DDMMYYYY = "dd/MM/yyyy";

    private static final String DDMMMYYYY = "dd MMM yyyy";

    private static final String DIAGONAL = "-";

    private static final String COLON = ":";

    private static final String PM = "PM";

    private static final String AM = "AM";

    /**
     *
     * @param yyyyMMDD
     * @return 31/01/18
     */
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

    /**
     *
     * @param yyyyMMDD
     * @return 31/01/2018
     */
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

    public static String formaterDDMMMYYYY(String yyyyMMDD) {
        SimpleDateFormat fromFormat = new SimpleDateFormat(YYYYMMDD);
        SimpleDateFormat toFormat = new SimpleDateFormat(DDMMMYYYY);
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
        String[] arrays = time.split(DIAGONAL);
        int year = Integer.parseInt(arrays[0]);
        int mouth = Integer.parseInt(arrays[1]);
        int day = Integer.parseInt(arrays[2]);
        return getAbbreviationDate(year, mouth, day);
    }

    public static String getAMPMTime(String time) {
        String[] arrays = time.split(COLON);
        int hh = Integer.parseInt(arrays[0]);
        int mm = Integer.parseInt(arrays[1]);
        return getAMPMTime(hh, mm);
    }

    public static String getAMPMTime(int h, int m) {
        StringBuilder mm = new StringBuilder();
        if(m <10) {
            mm.append(0).append(m);
        }
        StringBuilder result = new StringBuilder();
        if(h >12) {
            if(h -12 <=9) {
                result.append(0).append(h-12);
            } else {
                result.append(h-12);
            }
            result.append(COLON).append(mm).append(PM);
        } else if (h == 12) {
            result.append(h).append(COLON).append(mm).append(PM);
        } else {
            if(h <=9){
                result.append(0).append(h);
            } else {
                result.append(h);
            }
            result.append(COLON).append(mm).append(AM);
        }
        return result.toString();
    }

    /**
     *
     * @param year
     * @param mouth
     * @param day
     * @return 12 Feb 2018
     */
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

    /**
     *
     * @param time
     * @return Demo 12:00PM, 12 July 2018
     */
    public static String formaterISODate(String time) {
        if (!time.matches("\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}Z")) {
            return "";
        }
        time = time.replaceFirst("T", "\t").replaceFirst("Z", "");
        String[] times = time.split("\t");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getAMPMTime(times[1])).append(",\t").append(getAbbreviationDate(times[0]));
        return stringBuilder.toString();
    }

    /**
     *  todo
     * @param time
     * @return Demo 16/01/2018, 06:52 am
     */
    public static String formaterISODateLower(String time) {
        if (!time.matches("\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}Z")) {
            return "";
        }
        time = time.replaceFirst("T", "\t").replaceFirst("Z", "");
        String[] times = time.split("\t");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getAMPMTime(times[1])).append(",\t").append(getAbbreviationDate(times[0]));
        return stringBuilder.toString();
    }

}
