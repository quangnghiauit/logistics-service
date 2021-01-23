package com.dacn.logicsticservice.utils;

import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DateTimeUtils {

  public static final String DATE_TIME_FORMAT = "dd/MM/yyyy HH:mm:ss";
  public static final String DATE_TIME_FORMAT_YEAR = "yyyy/MM/dd HH:mm:ss";
  public static final String DATE_FORMAT = "dd/MM/yyyy";
  public static final String YYYYMMDDHHMMSSSSS = "yyyy-MM-dd HH:mm:ss.SSS";
  public static final String DATE_YYYY_MM_DD_HH_MM_SS_FORMAT = "yyyy-MM-dd HH:mm:ss";
  public static final String DATE_YYYY_MM_DD = "yyyy-MM-dd";
  public static final String DATE_YYYY_MM_DD_T_HH_MM_SS_SSS_Z_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
  private static final Logger logger = LoggerFactory.getLogger(DateTimeUtils.class);
  public static TimeZone GMT7TimeZone = TimeZone.getTimeZone("Asia/Ho_Chi_Minh");

  public static String formatDateToString(Date date) {
    if (date == null) {
      return "";
    }

    SimpleDateFormat outputDateFormat = new SimpleDateFormat(YYYYMMDDHHMMSSSSS);
    return outputDateFormat.format(date);
  }

  public static String formatDateToString(Date date, String format) {
    if (date == null) {
      return "";
    }
    SimpleDateFormat outputDateFormat = new SimpleDateFormat(format);
    return outputDateFormat.format(date);
  }

//  public static String formatDate(String inDate, String inFormat, String outFormat)
//      throws ParseException {
//    SimpleDateFormat inSDF = new SimpleDateFormat(inFormat);
//    SimpleDateFormat outSDF = new SimpleDateFormat(outFormat);
//    String outDate = "";
//    if (!StringUtils.isEmpty(inDate)) {
//      Date date = inSDF.parse(inDate);
//      outDate = outSDF.format(date);
//    } else {
//      return "";
//    }
//    return outDate;
//  }

  public static String getCurrentDateTime() {
    DateFormat dateFormat = new SimpleDateFormat(DATE_YYYY_MM_DD_HH_MM_SS_FORMAT);
    dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
    Date date = new Date();
    return dateFormat.format(date);
  }

  public static String convertDateToCurrentDateTime(String dateInput) {
    DateFormat dateFormat = new SimpleDateFormat(DATE_YYYY_MM_DD_HH_MM_SS_FORMAT);
    dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
    Date date = convertDate(dateInput, DATE_FORMAT);
    return dateFormat.format(date);
  }

  public static String getCurrentDateTime(String format) {
    DateFormat dateFormat = new SimpleDateFormat(format);
    Date date = new Date();
    return dateFormat.format(date);
  }

  public static Date getCurDateWithMilisec() throws ParseException {
    SimpleDateFormat formatSDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    formatSDF.setTimeZone(GMT7TimeZone);

    SimpleDateFormat parseSDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    Date date = new Date(System.currentTimeMillis());

    return parseSDF.parse(formatSDF.format(date));
  }

  public static Date convertDate(String dateStr) {
    return convertDate(dateStr, DATE_TIME_FORMAT);
  }

  public static Date convertDate(String dateStr, String format) {
    try {
      DateFormat dateFormat;
      if (format != null) {
        dateFormat = new SimpleDateFormat(format);

      } else {
        dateFormat = new SimpleDateFormat(DATE_TIME_FORMAT);
      }

      return dateFormat.parse(dateStr);
    } catch (ParseException ex) {
      logger.error("{} convertDate exception: {}", dateStr, ex.getMessage(), ex);
    }
    return null;
  }

  public static String second2DateStr(long timeStamp, String format) {
    DateFormat dateFormat;
    if (format == null) {
      dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    } else {
      dateFormat = new SimpleDateFormat(format);
    }
    return dateFormat.format(new Date(timeStamp * 1000));
  }

  public static String milisecond2DateStr(long timeStamp, String format) {
    DateFormat dateFormat;
    if (format == null) {
      dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    } else {
      dateFormat = new SimpleDateFormat(format);
    }
    return dateFormat.format(new Date(timeStamp));
  }

  public static long convertTimeStampMilisecond(String dateStr, String format) {
    try {
      DateFormat dateFormat;
      if (format == null) {
        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
      } else {
        dateFormat = new SimpleDateFormat(format);
      }
      Date date = dateFormat.parse(dateStr);
      return date.getTime();
    } catch (Exception ex) {
      return 0;
    }
  }

  public static String getCurrentTime(String format) {
    SimpleDateFormat formatSDF = new SimpleDateFormat(format);
    Date date = new Date(System.currentTimeMillis());
    return formatSDF.format(date);
  }

//  public static String getYYYYMMDDDayNow() {
//    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
//    return simpleDateFormat.format(new Date());
//  }
//
//  public static String getCurrentDate(String format) {
//    DateFormat dateFormat = new SimpleDateFormat(format);
//    Date date = new Date();
//    return dateFormat.format(date);
//  }
//
//  public static String convertString(Date date, String format) {
//    try {
//      if (date == null) {
//        return null;
//      }
//      DateFormat dateFormat;
//      if (format == null) {
//        dateFormat = new SimpleDateFormat(DATE_TIME_FORMAT);
//      } else {
//        dateFormat = new SimpleDateFormat(format);
//      }
//      return dateFormat.format(date);
//    } catch (Exception e) {
//      logger.warn("error convert datetime: {}, error: {}", date.toString(), e.getMessage());
//    }
//    return null;
//  }
//
//  public static String timeStamp2DateStr(long timestamp) {
//    if (timestamp == 0) {
//      return "";
//    }
//    try {
//      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//      return sdf.format(new Date(timestamp));
//    } catch (Exception ex) {
//      return "";
//    }
//  }
//
//  public static String convertTimeStamp2Date(long timeStamp, String format) {
//    DateFormat dateFormat;
//    if (format == null) {
//      dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//      dateFormat.setTimeZone(GMT7TimeZone);
//    } else {
//      dateFormat = new SimpleDateFormat(format);
//    }
//    dateFormat.setTimeZone(GMT7TimeZone);
//    return dateFormat.format(new Date(timeStamp));
//  }
//
//  public static String convertTimeStamp2DateGMT7(long timeStamp, String format) {
//    DateFormat dateFormat;
//    if (format == null) {
//      dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//    } else {
//      dateFormat = new SimpleDateFormat(format);
//    }
//    dateFormat.setTimeZone(GMT7TimeZone);
//    return dateFormat.format(new Date(timeStamp));
//  }
//
//  public static Date add(Date date, int year, int month, int day, int hour, int minute,
//                         int second) {
//    Calendar cal = Calendar.getInstance();
//    cal.setTime(date);
//
//    cal.add(Calendar.YEAR, year);
//    cal.add(Calendar.MONTH, month);
//    cal.add(Calendar.DATE, day);
//    cal.add(Calendar.HOUR, hour);
//    cal.add(Calendar.MINUTE, minute);
//    cal.add(Calendar.SECOND, second);
//
//    return cal.getTime();
//  }
//
//  public static int getCurrentDayOfYear() {
//    Calendar calendar = Calendar.getInstance();
//    return calendar.get(Calendar.DAY_OF_YEAR);
//  }
//
//  public static String fomartDate(SimpleDateFormat simpleDateFormat, long time) {
//    if (time > 0) {
//      return simpleDateFormat.format(new Date(time));
//    }
//    return "";
//  }
//
//  public static String getDate(int delDay, String format) {
//    Calendar toDay = Calendar.getInstance();
//    toDay.add(Calendar.DATE, delDay);
//    Date dt = toDay.getTime();
//    DateFormat dateFormat = new SimpleDateFormat(format);
//    return dateFormat.format(dt);
//  }
//
//  public static String convertFormat(String dateStr, String oldFormat, String newFormat) {
//    Date date = convertDate(dateStr, oldFormat);
//    return convertString(date, newFormat);
//  }
//
//  /**
//   * @param date input day with format yyyy-MM-dd HH:mm:ss.SSS
//   * @param format format to yyyy-MM-dd HH:mm:ss.SSS
//   * @param firstOrLast true -> first date of month ; false -> last day of month
//   */
//  public static String getDateOfMonth(String date, String format, boolean firstOrLast) {
//    DateFormat dateFormat;
//    if (StringUtils.isEmpty(format)) {
//      dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//    } else {
//      dateFormat = new SimpleDateFormat(format);
//    }
//
//    LocalDate convertedDate = LocalDate.parse(date, DateTimeFormatter.ofPattern(format));
//    if (firstOrLast) {
//      convertedDate = convertedDate.withDayOfMonth(1);
//    } else {
//      convertedDate = convertedDate.withDayOfMonth(
//          convertedDate.getMonth().length(convertedDate.isLeapYear()));
//    }
//
//    return dateFormat.format(java.sql.Date.valueOf(convertedDate));
//  }
//
//  public static String getDateByDateOfYear(String dateOfYear, String format) {
//    DateFormat dateFormat;
//    if (format == null) {
//      dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//    } else {
//      dateFormat = new SimpleDateFormat(format);
//    }
//    Calendar calendar = Calendar.getInstance();
//    calendar.set(Calendar.DAY_OF_YEAR, Integer.parseInt(dateOfYear));
//    return dateFormat.format(calendar.getTime());
//  }
//
//  public static Date yesterday() {
//    final Calendar cal = Calendar.getInstance();
//    cal.add(Calendar.DATE, -1);
//    return cal.getTime();
//  }
//
//  public static int getYmd() {
//
//    Date date = new Date();
//    DateFormat format = new SimpleDateFormat("YYMMdd");
//    format.setTimeZone(GMT7TimeZone);
//
//    return NumberUtils.toInt(format.format(date));
//  }
//
//  public static int getYmd(Date date) {
//
//    DateFormat format = new SimpleDateFormat("YYMMdd");
//    format.setTimeZone(GMT7TimeZone);
//
//    return NumberUtils.toInt(format.format(date));
//  }
//
//  public static LocalDateTime getLocalDateTime(String dateTime) {
//    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
//    if (!StringUtils.isEmpty(dateTime)) {
//      return LocalDateTime.parse(dateTime);
//    }
//    return null;
//  }
//
//  public static LocalDateTime convertToLocalDateTime(String dateTime, String format) {
//    if (org.apache.commons.lang3.StringUtils.isBlank(dateTime)) {
//      logger.warn("convert date at convertToLocalDateTime return null because dateTime is empty");
//      return null;
//    }
//    try {
//      String pattern = StringUtils.isEmpty(format) ? "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'" : format;
//      DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
//      if (!StringUtils.isEmpty(dateTime)) {
//        return LocalDateTime.parse(dateTime, formatter);
//      }
//      return null;
//    } catch (Exception e) {
//      logger.error(e.getMessage(), e);
//      return null;
//    }
//  }
//
//  public static LocalDateTime getFirstDateTimeOfMonth(String month, String format) {
//    try {
//      String pattern = StringUtils.isEmpty(format) ? "dd/MM/yyyy" : "dd-" + format;
//      DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
//      if (!StringUtils.isEmpty(month)) {
//        return LocalDate.parse("01-" + month, formatter).atStartOfDay();
//      }
//      return null;
//    } catch (Exception e) {
//      return null;
//    }
//  }
//
//  public static LocalDateTime getLastDateOfMonthExcludeTime(String month, String format) {
//    try {
//      return Objects
//          .requireNonNull(getFirstDateOfNextMonth(month, format))
//          .plusDays(-1);
//    } catch (Exception e) {
//      logger.error(e.getMessage());
//      return null;
//    }
//  }
//
//  public static LocalDateTime getFirstDateOfNextMonth(String month, String format) {
//    try {
//      String pattern = StringUtils.isEmpty(format) ? "dd/MM/yyyy" : "dd-" + format;
//      DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
//      if (!StringUtils.isEmpty(month)) {
//        return LocalDate.parse("01-" + month, formatter).plusMonths(1).atStartOfDay();
//      }
//      return null;
//    } catch (Exception e) {
//      return null;
//    }
//  }
//
//  public static String getDateInLocalDatetime(LocalDateTime dateTime, String format) {
//    try {
//      String pattern = StringUtils.isEmpty(format) ? "dd/MM/yyyy" : format;
//      DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
//      if (dateTime != null) {
//        return dateTime.format(formatter);
//      }
//      return null;
//    } catch (Exception e) {
//      return null;
//    }
//  }
//
//  //format date: yyyy-mm-dd
//  public static boolean isCurrentDate(String date) {
//    LocalDate localDate = LocalDate.now();
//    return localDate.toString().equals(date);
//  }
//
//  public static boolean isYesterday(String date) {
//    LocalDate today = LocalDate.now();
//    LocalDate yesterday = today.minusDays(1);
//    return yesterday.toString().equals(date);
//  }
//
//
//  public static String date2Str(Date date, String format) {
//    DateFormat dateFormat;
//    if (format == null) {
//      dateFormat = new SimpleDateFormat(DATE_FORMAT);
//    } else {
//      dateFormat = new SimpleDateFormat(format);
//    }
//    return dateFormat.format(date);
//
//  }
//
//  public static String timestamp2Str(long timestamp, String format) {
//    DateFormat dateFormat;
//    Timestamp ts = new Timestamp(timestamp);
//    Date date = ts;
//    if (format == null) {
//      dateFormat = new SimpleDateFormat(DATE_FORMAT);
//    } else {
//      dateFormat = new SimpleDateFormat(format);
//    }
//    return dateFormat.format(date);
//
//  }
//
//  public static String str2FormatDate(String dateStr, String inputFormat, String outputFormat)
//      throws ParseException {
//    SimpleDateFormat inSDF = new SimpleDateFormat(inputFormat);
//    SimpleDateFormat outSDF = new SimpleDateFormat(outputFormat);
//    String outDate = "";
//    if (dateStr != null) {
//      Date date = inSDF.parse(dateStr);
//      outDate = outSDF.format(date);
//    }
//    return outDate;
//  }
//
//
//  public static LocalDateTime dateToLocalDateTime(Date date) {
//    return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
//  }
//
//
//  public static Date getFirstDateOfMonth() {
//    final Calendar cal = Calendar.getInstance();
//    cal.set(Calendar.DAY_OF_MONTH, 1);
//    return cal.getTime();
//  }
//
//  public static Date str2Date(String dateStr, String format) throws ParseException {
//    DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
//    if (org.apache.commons.lang3.StringUtils.isNoneBlank(format)) {
//      dateFormat = new SimpleDateFormat(format);
//    }
//
//    return dateFormat.parse(dateStr);
//  }
//
//  public static String str2Date(long dateStr, String format) {
//    SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
//    if (format != null) {
//      dateFormat = new SimpleDateFormat(format);
//    }
//
//    dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
//    return dateFormat.format(dateStr * 1000);
//  }
//
//  public static String getCurrentDate() {
//    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//    Date date = new Date();
//    return dateFormat.format(date);
//  }
//
//  public static String convertEpochTimeToDate(long epochTime, String zoneOffset,
//                                              String formatPattern) {
//    String format =
//        org.apache.commons.lang.StringUtils.isBlank(formatPattern) ? "dd/MM/yyyy" : formatPattern;
//    try {
//      long epochTimeLong = epochTime / 1000;
//      LocalDateTime dateTime = LocalDateTime.ofEpochSecond(epochTimeLong, 0,
//          org.apache.commons.lang.StringUtils.isBlank(zoneOffset) ? ZoneOffset.of("+00:00")
//              : ZoneOffset.of(zoneOffset));
//
//      DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format, Locale.ENGLISH);
//      return dateTime.format(formatter);
//    } catch (NumberFormatException e) {
//      logger.error(e.getMessage());
//      return "";
//    }
//  }
//
//  public static String convertEpochTimeToDate(long epochTime) {
//    try {
//      LocalDateTime dateTime = LocalDateTime.ofEpochSecond(epochTime, 0, ZoneOffset.of("+00:00"));
//      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);
//
//      return dateTime.format(formatter);
//    } catch (NumberFormatException e) {
//      return "N/A";
//    }
//  }
//
//  private static Date localDateTimeToDate(LocalDateTime localDateTime) {
//    return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
//  }
//
//  public static Date atEndOfDay(Date date) {
//    LocalDateTime localDateTime = dateToLocalDateTime(date);
//    LocalDateTime endOfDay = localDateTime.with(LocalTime.MAX);
//    return localDateTimeToDate(endOfDay);
//  }
//
//  public static Date paraDate(String strDate, String format) throws ParseException {
//    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
//    return simpleDateFormat.parse(strDate);
//  }
//
//  public static Date parseDate(String dateStr, String format) throws ParseException {
//    DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
//    if (format != null) {
//      dateFormat = new SimpleDateFormat(format);
//    }
//    dateFormat.setLenient(false);
//    return dateFormat.parse(dateStr);
//  }
//
//  public static Date atStartOfDay(Date date) {
//    LocalDateTime localDateTime = dateToLocalDateTime(date);
//    LocalDateTime startOfDay = localDateTime.with(LocalTime.MIN);
//    return localDateTimeToDate(startOfDay);
//  }
//
//
//  public static String convertPartitionToStringDate(int partition) {
//
//    String tableSuffix = String.valueOf(partition);
//    String year = tableSuffix.substring(0, 4);
//    String month = tableSuffix.substring(4, 6);
//    String date = "01"; //begin date;
//
//    return date + "/" + month + "/" + year;
//  }
//
//  public static String getStrTimeZuluTime(String dateStr) {
//    String converted_date = "";
//    try {
//      DateFormat utcFormat = new SimpleDateFormat(DATE_YYYY_MM_DD_T_HH_MM_SS_SSS_Z_FORMAT);
//      utcFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
//
//      Date date = utcFormat.parse(dateStr);
//
//      DateFormat currentTFormat = new SimpleDateFormat(DATE_YYYY_MM_DD_HH_MM_SS_FORMAT);
//      currentTFormat.setTimeZone(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
//      converted_date = currentTFormat.format(date);
//
//      return converted_date;
//    } catch (Exception ex) {
//      logger.info("getStrTimeZuluTime exception", ex);
//      return dateStr;
//    }
//
//  }
//
//  public static String getCurrentDateYYYYMMDD() {
//    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//    Date date = new Date();
//    return dateFormat.format(date);
//  }
//
//  public static String getLastMonthYYYYMMDD() {
//    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//    LocalDate today = LocalDate.now();
//    Date date = getFirstDateOfMonth();
//    return dateFormat.format(date);
//  }
}
