package com.cdxt.lisweb.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.text.ParseException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Tangxiaohui
 * @date 2017年6月15日 下午2:34:44
 * @company 成都信通网易医疗科技发展有限公司
 * @description //TODO
 * @version 1.0.0
 */
public class FtpUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(FtpUtils.class);
	
	private FTPClient ftpClient;
	private String fileName, strencoding;
	private String ip = "192.168.0.234"; // 服务器IP地址
	private String userName = "lisreport"; // 用户名
	private String userPwd = "1@Lisport"; // 密码
	private int port = 21; // 端口号
	private String path ; // 读取文件的存放目录= "/20170707/"

	/**
	 * init ftp servere
	 */
	public FtpUtils(String filePreName,String pathName) {
		this.path=pathName;
		this.reSet(filePreName);
	}
	
	

	public void reSet(String filePreName) {
		// 以当前系统时间拼接文件名
		fileName = filePreName+".pdf";
		strencoding = "UTF-8";
		this.connectServer(ip, port, userName, userPwd, path);
	}

	/**
	 * @param ip
	 * @param port
	 * @param userName
	 * @param userPwd
	 * @param path
	 * @throws SocketException
	 * @throws IOException
	 *             function:连接到服务器
	 */
	public void connectServer(String ip, int port, String userName, String userPwd, String path) {
		ftpClient = new FTPClient();
		try {
			// 连接
			ftpClient.connect(ip, port);
			// 登录
			ftpClient.login(userName, userPwd);
			if (!FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {  
                logger.debug("未连接到FTP，用户名或密码错误。");  
                ftpClient.disconnect();  
            } else {  
            	logger.debug("FTP连接成功。");  
            }  
			if (path != null && path.length() > 0) {
				// 跳转到指定目录
				ftpClient.changeWorkingDirectory(new String(path.getBytes(),strencoding));
			}
			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @throws IOException
	 *             function:关闭连接
	 */
	public void closeServer() {
		if (ftpClient.isConnected()) {
			try {
				ftpClient.logout();
				ftpClient.disconnect();
				logger.debug("ftp连接关闭");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	

	

	/**
	 * @param fileName
	 * @return function:从服务器上读取指定的文件
	 * @throws ParseException
	 * @throws IOException
	 */
	public byte[] readFile() throws ParseException {
		InputStream ins = null;
		//StringBuilder builder = null;
		try {
			// 从服务器上读取指定的文件
			ins = ftpClient.retrieveFileStream(fileName);
			logger.debug("FTP文件路径 :"+path);
			logger.debug("fileName:"+fileName);
			ByteArrayOutputStream out = new ByteArrayOutputStream(1000);
			byte[] b = new byte[1000];
			int n;
			while ((n = ins.read(b)) != -1)
				out.write(b, 0, n);
			out.close();
			ins.close();
			//ftpClient.completePendingCommand();
			return out.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}finally{
			closeServer();
		}
		
	}

	/**
	 * @param fileName
	 *            function:删除文件
	 */
	public void deleteFile(String fileName) {
		try {
			ftpClient.deleteFile(fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 * @throws ParseException
	 */
	/*public static void main(String[] args) throws ParseException {
		FtpUtils ftp = new FtpUtils();
		String str = ftp.readFile();
		System.out.println(str);
	}*/
}
