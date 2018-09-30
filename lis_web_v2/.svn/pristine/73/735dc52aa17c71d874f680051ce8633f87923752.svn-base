package com.cdxt.lisweb.utils;

import java.util.Date;
import java.util.Random;

/**
 * @author : Tangxiaohui 
 * @date 创建时间：2018年1月4日 下午3:28:02
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: //TODO
 */
public class UseridUtils {
	
	private static final String L_PREFIX = "LIS";

	/**
	 * @discription 用户ID为LIS开头+14位日期+3位随机数字
	 * @author hezheng
	 * @created 2017-5-8 下午5:13:26
	 * @param @return
	 * @return String
	 */
	public static String getUserID() {
		String format = "YYYYMMddHHmmss";
		Date date = new Date();
		String id = DateUtils.formatDate(date, format);

		return L_PREFIX +id+ getRandomInt(3);
	}

	/**
	 * @discription 获取指定长度的随机数
	 * @author hezheng
	 * @created 2017-5-8 下午5:04:31
	 * @param @param n
	 * @param @return
	 * @return int
	 */
	public static String getRandomInt(int n) {
		int i = 0;
		Random random = new Random();
		StringBuffer buffer = new StringBuffer();
		while (i < n) {
			buffer.append(random.nextInt(10));
			i++;
		}
		return buffer.toString();
	}

}
