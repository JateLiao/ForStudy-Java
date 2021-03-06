package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 描述：时间格式转换.
 * 
 * @version v1.0
 */
public class DateUtil {
    /**
     * 默认格式.
     */
    private static String patterns = "yyyy-MM-dd HH:mm:ss";

    /**
     * . 描述：日期转换格式
     * 
     * @param date
     *            riqi
     * @param pattern
     *            wu
     * @return string
     * @version v1.0
     * @date 2013-3-20 下午04:27:21
     */
    public static String dateToString(Date date, String pattern) {
        String temp = "";
        if (pattern != null && !"".equals(pattern)) {
            temp = pattern;
        } else {
            temp = patterns;
        }
        SimpleDateFormat df = new SimpleDateFormat(temp);
        try {
            String str = df.format(date);
            return str;
        } catch (Exception e) {
            System.out.println("时间格式转换异常" + e.getMessage());
            return null;
        }
    }

    /**
     * TODO Date=>String.
     * 
     * @param date
     *            时间
     * @return String
     */
    public static String dateToString(Date date) {
        String temp = patterns;
        SimpleDateFormat df = new SimpleDateFormat(temp);
        try {
            String str = df.format(date);
            return str;
        } catch (Exception e) {
            System.out.println("时间格式转换异常" + e.getMessage());
            return null;
        }
    }

    /**
     * . 描述：日期转换格式
     * 
     * @param time
     *            时间戳
     * @param pattern
     *            wu
     * @return string
     * @version v1.0
     * @date 2013-3-20 下午04:27:21
     */
    public static String dateToString(Long time, String pattern) {
        String temp = "";
        if (pattern != null && !"".equals(pattern)) {
            temp = pattern;
        } else {
            temp = patterns;
        }
        if (time == 0) {
            return "";
        }
        SimpleDateFormat df = new SimpleDateFormat(temp);
        try {
            String str = df.format(time);
            return str;
        } catch (Exception e) {
            System.out.println("时间格式转换异常" + e.getMessage());
            return null;
        }
    }

    /**
     * . 描述:String类型转换为Date类型
     * 
     * @param date
     *            时间类型 @return Calendar 当前时间 @exception 异常 @param pattern 字符串模型 @throws
     */
    public static Calendar stringToCalendar(String date, String pattern) {
        String temp = "";
        if (pattern != null && !"".equals(pattern)) {
            temp = pattern;
        } else {
            temp = patterns;
        }
        SimpleDateFormat format = new SimpleDateFormat(temp);
        try {
            Date tempDate = format.parse(date);
            Calendar cal = Calendar.getInstance();
            cal.setTime(tempDate);
            return cal;
        } catch (ParseException e) {
            System.out.println("时间格式转换异常" + e.getMessage());
            return null;
        }
    }

    /**
     * TODO String => Calendar.
     * 
     * @param date
     *            date
     * @return Calendar
     */
    public static Calendar stringToCalendar(String date) {
        String temp = patterns;
        SimpleDateFormat format = new SimpleDateFormat(temp);
        try {
            Date tempDate = format.parse(date);
            Calendar cal = Calendar.getInstance();
            cal.setTime(tempDate);
            return cal;
        } catch (ParseException e) {
            System.out.println("时间格式转换异常" + e.getMessage());
            return null;
        }
    }

    /**
     * TODO Calendar => Integer.
     * 
     * @param cal
     *            当前时间
     * @return 返回值为Integer
     */
    public static Integer calendarToInteger(Calendar cal) {
        String year = cal.get(Calendar.YEAR) + "";
        String month = "";
        String day = "";
        if (cal.get(Calendar.MONTH) < 9) {
            month = "0" + (cal.get(Calendar.MONTH) + 1);
        } else {
            month = "" + (cal.get(Calendar.MONTH) + 1);
        }
        if (cal.get(Calendar.DATE) < 10) {
            day = "0" + cal.get(Calendar.DATE) + "";
        } else {
            day = cal.get(Calendar.DATE) + "";
        }
        return Integer.parseInt(year + month + day);
    }

    // public static String dateToString(Date date, String pattern) {
    // String temp = "";
    // if (pattern != null && !"".equals(pattern))
    // temp = pattern;
    // else
    // temp = "yyyy-MM-dd HH:mm:ss";
    // SimpleDateFormat df = new SimpleDateFormat(temp);
    // try {
    // String str = df.format(date);
    // return str;
    // } catch (Exception e) {
    // throw new RuntimeException((new StringBuilder()).append("\u65F6\u95F4\u683C\u5F0F\u8F6C\u6362\u5F02\u5E38").append(e.getMessage()).toString());
    // }
    // }
}
