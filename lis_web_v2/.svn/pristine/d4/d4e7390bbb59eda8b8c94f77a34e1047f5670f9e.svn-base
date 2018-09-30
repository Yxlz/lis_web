package com.cdxt.lisweb.utils;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * 系统文件读取工具类
 * 
 * @author hezheng
 */
public class SysPropertyUtils {
	private static Logger logger = Logger.getLogger(SysPropertyUtils.class);
	private static Properties properties = new Properties();

	static {
		try {
			properties.load(SysPropertyUtils.class.getClassLoader().getResourceAsStream("system.properties"));
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("系统配置文件加载失败！"+e.getMessage());
		}
	}

	/**
	 * 配置属性值读取
	 * 
	 * @param key
	 * @return
	 */
	public static String getValue(String key) {
		String value = (String) properties.get(key);
		return value.trim();
	}
}
