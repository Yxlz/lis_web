package com.cdxt.lisweb.utils;

import java.util.Date;
import java.util.Random;

/**
 * @author : liushijun 
 * @date 创建时间：2018年9月11日 下午3:28:02
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: //TODO
 */
public class IDCreateUtils {
	
	private static final String R_PREFIX = "REF";
	private static final String H_PREFIX = "HIS";
	private static final String I_PREFIX = "ICD";
	private static final String L_PREFIX = "LOG";
	private static final String T_PREFIX = "TYP";
	private static final String Q_PREFIX = "QCC";

	/**
	 * @discription 规则id为JUD+14位当前时间的string和3位随机数  生成范围判断ID
	 * @author liushijun
	 * @created 2018-9-8 下午5:13:26
	 * @param @return
	 * @return String
	 */
	public static String getRefID() {
		String format = "YYYYMMddHHmmss";
		Date date = new Date();
		String id = DateUtils.formatDate(date, format);

		return R_PREFIX +id+ getRandomInt(3);
	}
	/**
	 * @discription 规则id为HIS+14位当前时间的string和3位随机数  生成历史判断ID
	 * @author liushijun
	 * @created 2018-9-8 下午5:13:26
	 * @param @return
	 * @return String
	 */
	public static String getHisID() {
		String format = "YYYYMMddHHmmss";
		Date date = new Date();
		String id = DateUtils.formatDate(date, format);

		return H_PREFIX +id+ getRandomInt(3);
	}
	
	/**
	 * @discription 规则id为ICD+14位当前时间的string和3位随机数  生成关键字判断ID
	 * @author liushijun
	 * @created 2018-9-8 下午5:13:26
	 * @param @return
	 * @return String
	 */
	public static String getIcdID() {
		String format = "YYYYMMddHHmmss";
		Date date = new Date();
		String id = DateUtils.formatDate(date, format);

		return I_PREFIX +id+ getRandomInt(3);
	}
	
	/**
	 * @discription 规则id为LOG+14位当前时间的string和3位随机数  生成逻辑判断ID
	 * @author liushijun
	 * @created 2018-9-8 下午5:13:26
	 * @param @return
	 * @return String
	 */
	public static String getLogID() {
		String format = "YYYYMMddHHmmss";
		Date date = new Date();
		String id = DateUtils.formatDate(date, format);

		return L_PREFIX +id+ getRandomInt(3);
	}
	
	/**
	 * @discription 规则id为LOG+14位当前时间的string和3位随机数  生成类型id
	 * @author liushijun
	 * @created 2018-9-8 下午5:13:26
	 * @param @return
	 * @return String
	 */
	public static String getTypeID() {
		String format = "YYYYMMddHHmmss";
		Date date = new Date();
		String id = DateUtils.formatDate(date, format);

		return T_PREFIX +id+ getRandomInt(3);
	}
	
	/**
	 * @discription 规则id为QCC+14位当前时间的string和3位随机数  生成质控id
	 * @author liushijun
	 * @created 2018-9-8 下午5:13:26
	 * @param @return
	 * @return String
	 */
	public static String getQccID() {
		String format = "YYYYMMddHHmmss";
		Date date = new Date();
		String id = DateUtils.formatDate(date, format);

		return Q_PREFIX +id+ getRandomInt(3);
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
