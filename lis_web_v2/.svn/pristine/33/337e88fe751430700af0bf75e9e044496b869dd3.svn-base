package com.cdxt.lisweb.utils;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类
 * 
 * @author hezheng
 *
 */
public class DateUtils {

	/**
	 * 默认的日期格式化格式
	 */
	public static final String DEFAUL_TIME_FORMATER = "yyyy-MM-dd HH:mm:ss";
	
	private static SimpleDateFormat sdf = new SimpleDateFormat(DEFAUL_TIME_FORMATER);
	
	/**
	 * 日期加减操作
	 * 
	 * @param date 进行加减的日期
	 * @param dateType 加减的类型  比如天、小时、分钟、秒等  详见Calendar类
	 * @param adder 加上的天数、小时数、分钟数等  减去时为负数
	 * @return
	 */
	public static Date getAddSubDate(Date date,int dateType,int adder){
		Calendar calendar=Calendar.getInstance();  
		calendar.setTime(date);
		calendar.add(dateType, adder);
		return calendar.getTime();
	}
	
	/**
	 * 使用给定的格式对日期进行格式化
	 * 
	 * @param date
	 * @param formater
	 * @return String
	 */
	public static String formatDate(Date date,String formater){
		SimpleDateFormat sdf = new SimpleDateFormat(formater);
		try {
			return sdf.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	/**
	 * 使用默认的格式进行日期格式化
	 * 
	 * @param date
	 * @param formater
	 * @return String
	 */
	public static String formatDate(Date date){
		return DateUtils.formatDate(date, DEFAUL_TIME_FORMATER);
	}
	
	/**
	 * 使用默认的格式进行日期格式化
	 * 
	 * @param date
	 * @param formater
	 * @return String
	 */
	public static Date parseDate(String dateStr){
		if(dateStr==null) return null;
		try {
			return sdf.parse(dateStr);
		} catch (ParseException e) {
		}
		return null;
	}
	
	/**
	 * 通过身份证号 获取出生日期
	 * @return
	 */
	public static String getDateOfBirth(String idcard){
		if (idcard==null) {
			return "";
		}
		if (idcard.equals("")||idcard.length()<18) {
			return "";
		}
		StringBuffer sb = new StringBuffer();
		sb.append(idcard.substring(6, 10));
		sb.append("-");
		sb.append(idcard.substring(10, 12));
		sb.append("-");
		sb.append(idcard.substring(12, 14));
		return sb.toString();
	}
	
	/**
	 * 获取pdf文件目录
	 * @return
	 */
	public static String getPathName(){
		Date d = new Date();  
        System.out.println(d);  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
        String dateNowStr = sdf.format(d); 
        String[] dateArray = dateNowStr.split("-");
        String pathName="/";
        for (String string : dateArray) {
			pathName+=string;
		}
        return pathName+"/";
	}
	 /**
	  * 获取现在时间
	  * 
	  * @return 返回时间类型 yyyy-MM-dd HH:mm:ss
	  */
	 public static Date getNowDate() {
	  Date currentTime = new Date();
	  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	  String dateString = formatter.format(currentTime);
	  ParsePosition pos = new ParsePosition(8);
	  Date currentTime_2 = formatter.parse(dateString, pos);
	  return currentTime_2;
	 }
	 /**
	  * 在日期上增加数个整日
	  * @param date
	  * @param n
	  * @return
	  */
	 public static Date addDays(Date date, int n){
	        Calendar cal = Calendar.getInstance();  
	        cal.setTime(date);  
	        cal.add(Calendar.DATE, n);  
	        return cal.getTime();  
	 }
	 /**
	  * 传入字符串  转换为date
	  * @param dateString
	  * @return
	  */
	 public static Date getDateFromString(String dateString){
		 	Date date = null; 
		    try {
				date = sdf.parse(dateString.toString());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		    return date;
	 }
	 
	 public static String changeDateFomdate(String dateString){
	        String[] dateArray = dateString.split("-");
	        String pathName="";
	        for (String string : dateArray) {
				pathName+=string;
			}
	        return pathName;
	 }
}
