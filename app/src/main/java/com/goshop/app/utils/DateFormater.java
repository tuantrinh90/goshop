package com.goshop.app.utils;

import com.goshop.app.Const;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormater {

    private static final String YYYYMMDD = "yyyy-MM-dd";

    private static final String DDMMYY = "dd/MM/yy";

    private static final String DDMMYYYY = "dd/MM/yyyy";

    private static final String DDMMMYYYY = "dd MMM yyyy";

    private static final String DIAGONAL = "-";

    private static final String COLON = ":";

    private static final String PM = " PM";

    private static final String AM = " AM";

    private static final String PM_LOWER = " pm";

    private static final String AM_LOWER = " am";

    /**
     *
     * @param "2018-01-31"
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
     * @param "2018-01-31"
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

    /**
     *
     * @param "2018-01-31"
     * @return 31/01/2018
     */
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
        result.append(day).append(" ").append(getMouth(mouth)).append(" ").append(year);
        return result.toString();
    }

    /**
     *
     * @param "2018-04-05T00:42:09Z"
     * @return  12:00PM, 12 July 2018
     */
    public static String formaterISODate(String time) {
        if (!time.matches("\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}Z")) {
            return "";
        }
        time = time.replaceFirst("T", " ").replaceFirst("Z", "");
        String[] times = time.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getAMPMTime(times[1])).append(", ").append(getAbbreviationDate(times[0]));
        return stringBuilder.toString();
    }

    /**
     *
     * @param "2018-04-05T00:42:09Z"
     * @return  05/04/2018, 00:42 am
     */
    public static String formaterISODateLower(String time) {
        if (!time.matches("\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}Z")) {
            return "";
        }
        time = time.replaceFirst("T", " ").replaceFirst("Z", "");
        String[] times = time.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(formaterDDMMYYYY(times[0])).append(", ").append(getAPLowerTime(times[1]));
        return stringBuilder.toString();
    }

    /**
     *
     * @param startTime"2018-04-05"
     * @param endTime"2018-04-05"
     * @return 05 Apr 2018 - 05 Apr 2018
     */
    public static String getDealTimePeriod(String startTime, String endTime){
        String start = getAbbreviationDate(startTime);
        String end = getAbbreviationDate(endTime);
        StringBuilder result = new StringBuilder();
        result.append(start).append(" ").append(DIAGONAL).append(" ").append(end);
        return result.toString();
    }

    /**
     *
     * @param "2018-04-05"
     * @return 05 Apr 2018
     */
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

    public static String getAPLowerTime(String time) {
        String[] arrays = time.split(COLON);
        int hh = Integer.parseInt(arrays[0]);
        int mm = Integer.parseInt(arrays[1]);
        return getAPLowerTime(hh, mm);
    }

    public static String getAMPMTime(int h, int m) {
        StringBuilder mm = new StringBuilder();
        if(m <10) {
            mm.append(0).append(m);
        } else {
            mm.append(m);
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

    public static String getAPLowerTime(int h, int m) {
        StringBuilder mm = new StringBuilder();
        if(m <10) {
            mm.append(0).append(m);
        } else {
            mm.append(m);
        }
        StringBuilder result = new StringBuilder();
        if(h >12) {
            if(h -12 <=9) {
                result.append(0).append(h-12);
            } else {
                result.append(h-12);
            }
            result.append(COLON).append(mm).append(PM_LOWER);
        } else if (h == 12) {
            result.append(h).append(COLON).append(mm).append(PM_LOWER);
        } else {
            if(h <=9){
                result.append(0).append(h);
            } else {
                result.append(h);
            }
            result.append(COLON).append(mm).append(AM_LOWER);
        }
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
