package com.cdxt.lisweb.common;

import java.io.ByteArrayOutputStream;

/**
 * 自定义Base64加解密
 * 
 * @author Administrator
 */
public class Base64Util {
	public static final int RANGE = 0xff;
	// 自定义码表 可随意变换字母排列顺序，然后会自动生成解密表
	public static byte[] StrToBase64Byte = new byte[128];

	public static void generateDecoder(char[] Base64ByteToStr ) throws Exception {
		for (int i = 0; i <= StrToBase64Byte.length - 1; i++) {
			StrToBase64Byte[i] = -1;
		}
		for (int i = 0; i <= Base64ByteToStr.length - 1; i++) {
			StrToBase64Byte[Base64ByteToStr[i]] = (byte) i;
		}
	}

	/**
	 * 加密
	 * @param bytes
	 * @return
	 * @throws Exception
	 */
	public static String Base64Encode(byte[] bytes,String key) throws Exception {
		char[] Base64ByteToStr = key.toCharArray();
		Base64Util.generateDecoder(Base64ByteToStr);
		StringBuilder res = new StringBuilder();
		// per 3 bytes scan and switch to 4 bytes
		for (int i = 0; i <= bytes.length - 1; i += 3) {
			byte[] enBytes = new byte[4];
			byte tmp = (byte) 0x00;// save the right move bit to next position's
									// bit
			// 3 bytes to 4 bytes
			for (int k = 0; k <= 2; k++) {// 0 ~ 2 is a line
				if ((i + k) <= bytes.length - 1) {
					enBytes[k] = (byte) (((((int) bytes[i + k] & RANGE) >>> (2 + 2 * k))) | (int) tmp);// note
					tmp = (byte) (((((int) bytes[i + k] & RANGE) << (2 + 2 * (2 - k))) & RANGE) >>> 2);
				} else {
					enBytes[k] = tmp;
					tmp = (byte) 64;// if tmp > 64 then the char is '=' hen '='
									// -> byte is -1 , so it is EOF or not print
									// char
				}
			}
			enBytes[3] = tmp;// forth byte
			// 4 bytes to encode string
			for (int k = 0; k <= 3; k++) {
				if ((int) enBytes[k] <= 63) {
					res.append(Base64ByteToStr[(int) enBytes[k]]);
				} else {
					res.append('=');
				}
			}
		}
		return res.toString();
	}
    /**
     * 解密
     * @param val
     * @return
     * @throws Exception
     */
	public static String Base64Decode(String val, String key) throws Exception {
		Base64Util.generateDecoder(key.toCharArray());
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		byte[] srcBytes = val.getBytes();
		byte[] base64bytes = new byte[srcBytes.length];
		// get the base64 bytes (the value is -1 or 0 ~ 63)
		for (int i = 0; i <= srcBytes.length - 1; i++) {
			int ind = (int) srcBytes[i];
			base64bytes[i] = StrToBase64Byte[ind];
		}
		// base64 bytes (4 bytes) to normal bytes (3 bytes)
		for (int i = 0; i <= base64bytes.length - 1; i += 4) {
			byte[] deBytes = new byte[3];
			int delen = 0;// if basebytes[i] = -1, then debytes not append this
							// value
			byte tmp;
			for (int k = 0; k <= 2; k++) {
				if ((i + k + 1) <= base64bytes.length - 1
						&& base64bytes[i + k + 1] >= 0) {
					tmp = (byte) (((int) base64bytes[i + k + 1] & RANGE) >>> (2 + 2 * (2 - (k + 1))));
					deBytes[k] = (byte) ((((int) base64bytes[i + k] & RANGE) << (2 + 2 * k) & RANGE) | (int) tmp);
					delen++;
				}
			}
			for (int k = 0; k <= delen - 1; k++) {
				bos.write((int) deBytes[k]);
			}
		}
		return new String(bos.toByteArray());
	}

	public static void main(String[] args) throws Exception {
		String key = "SCHYDRegionUsr2017ZEOFvl3byLdWANGKk89caupP456wQhMBJTXfIVjmqtxz+/";
		String srcStr = "008@xj\n123456111";
		System.out.println(" source:" + srcStr);
		String enStr = Base64Util.Base64Encode(srcStr.getBytes(), key);
		System.out.println("encoder:" + enStr);
		String deStr = new String(Base64Util.Base64Decode(enStr, key));
		System.out.println("decoder:" + deStr);
	}
}
