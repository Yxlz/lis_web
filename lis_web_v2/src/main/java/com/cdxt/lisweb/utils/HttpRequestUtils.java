package com.cdxt.lisweb.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

import org.apache.log4j.Logger;

/**
* @ClassName: HttpRequestUtils 
* @Description: HTTP 请求工具类
* @author hezheng
* @date 2017-4-24 下午1:43:43
* @最后修改人：hezheng
* @最后修改时间：2017-4-24 下午1:43:43
*/
public class HttpRequestUtils {
	
	private static Logger logger = Logger.getLogger(HttpRequestUtils.class);
	
	
	 public static String sendPostN(String url, String param) {
	        PrintWriter out = null;
	        BufferedReader in = null;
	        String result = "";
	        try {
	            URL realUrl = new URL(url);
	            // 打开和URL之间的连接
	            URLConnection conn = realUrl.openConnection();
	            // 设置通用的请求属性
	            conn.setRequestProperty("accept", "*/*");
	            conn.setRequestProperty("connection", "Keep-Alive");
	            conn.setRequestProperty("user-agent",
	                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
	            // 发送POST请求必须设置如下两行
	            conn.setDoOutput(true);
	            conn.setDoInput(true);
	            // 获取URLConnection对象对应的输出流
	            out = new PrintWriter(conn.getOutputStream());
	            // 发送请求参数
	            out.print(param);
	            // flush输出流的缓冲
	            out.flush();
	            // 定义BufferedReader输入流来读取URL的响应
	            in = new BufferedReader(
	                    new InputStreamReader(conn.getInputStream(),"utf-8"));
	            String line;
	            while ((line = in.readLine()) != null) {
	                result += line;
	            }
	        } catch (Exception e) {
	            System.out.println("发送 POST 请求出现异常！"+e);
	            e.printStackTrace();
	        }
	        //使用finally块来关闭输出流、输入流
	        finally{
	            try{
	                if(out!=null){
	                    out.close();
	                }
	                if(in!=null){
	                    in.close();
	                }
	            }
	            catch(IOException ex){
	                ex.printStackTrace();
	            }
	        }
	        return result;
	    }    
	
	/**
	 * 向指定URL发送GET方法的请求
	 * 
	 * @param url
	 *            发送请求的URL
	 * @param param
	 *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return URL 所代表远程资源的响应结果
	 * @throws Exception 
	 */
	public static String sendGet(String url, String param) throws Exception {
		String result = "";
		BufferedReader in = null;
		try {
			String urlNameString = url + "?" + param;
			logger.debug("正在发送HTTP GET请求：" + urlNameString);
			URL realUrl = new URL(urlNameString);
			// 打开和URL之间的连接
			HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
			// 设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			connection.setRequestMethod("GET");
			// 建立实际的连接
			connection.connect();
			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader( connection.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
			logger.info("发送HTTP GET请求成功！");
		} catch (Exception e) {
			logger.error("发送 HTTP GET请求失败！" +e.getMessage(), e);
			e.printStackTrace();
			throw new Exception(e);
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
	
	/**
	* @Title: sendPost 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @最后修改人：hezheng
	* @最后修改时间：2017-4-25 下午4:08:45
	* @param url 请求HTTP地址
	* @param param 发送的post内容体信息
	* @param headers 请求头参数列表
	* @return
	* @throws Exception 对方法的参数进行描述
	* @return String 返回类型
	* @throws
    */
	public static String sendPost(String url, String param, Map<String,String> headers) throws Exception {
		OutputStream out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			logger.info("正在发送HTTP POST请求：" + url + "| param：" + param);
			// 打开和URL之间的连接
			HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("Accept", "*/*");
			conn.setRequestProperty("Accept-Charset", "UTF-8");
			conn.setRequestProperty("connection", "keep-alive");
			conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");
			conn.setRequestMethod("POST");
			//conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			//请求头参数设置
			if(headers!=null){
				for(String key:headers.keySet()){
					conn.setRequestProperty(key, headers.get(key));
				}
			}
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			// 获取URLConnection对象对应的输出流
			out = conn.getOutputStream();
			logger.debug("HTTP POST参数:"+param);
			// 发送请求参数
			out.write(param.getBytes("UTF-8"));
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
			logger.info("发送HTTP POST请求成功！返回信息："+result);
		} catch (Exception e) {
			logger.error("发送HTTP POST请求失败！" +e.getMessage(), e);
			e.printStackTrace();
			throw new Exception(e);
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 向指定 URL 发送POST方法的请求
	 * 
	 * @param url
	 *            发送请求的 URL
	 * @param param
	 *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return 所代表远程资源的响应结果
	 * @throws Exception 
	 */
	public static String sendPost(String url, String param) throws Exception {
		return sendPost(url, param, null);
	}
	
	public static void main(String[] args) {
		try {
			//用户同步
			String aa = "{\"cd\":\"00003000000005\",\"deptcd\":\"00001000000204\",\"deptname\":\"收费室2\",\"loginname\":\"121\",\"msgcreatetime\":\"2017-05-12 09:48:26\",\"orgcd\":\"PXXFYBJY\",\"orgname\":\"收费室\",\"pwd\":\"123456\",\"truename\":\"周巍2\",\"usercd\":\"00002000000005\",\"companynum\":\"hxnet\",\"hash\":\"1ijm6J\",\"sign\":\"A6E64AC78634BC13370D0F7341348101\"}";
			//收费后申请单同步
			//String bb = "{\"appchargetime\":\"2017-04-27 16:28:35\",\"applicationtime\":\"2017-05-12 10:43:00\",\"appno\":\"L20170512104\",\"apporganid\":\"apporganid\",\"apporganname\":\"apporganname\",\"apptime\":\"2017-04-27 16:28:35\",\"apptype\":\"区域LIS\",\"doctorid\":\"00012\",\"doctorname\":\"XXX\",\"msgcreatetime\":\"2017-05-12 10:43:00\",\"orderamount\":\"98.6\",\"servicedoctorid\":\"servicedoctorid\",\"servicedoctorname\":\"servicedoctorname\",\"serviceorganid\":\"serviceorganid\",\"serviceorganname\":\"serviceorganname\",\"admno\":\"000998\",\"bedcode\":\"000098\",\"patage\":\"22\",\"patclinicalhistory\":\"病情介绍、病史及体征\",\"patdiagnosis\":\"诊断\",\"patid\":\"000056\",\"patidno\":\"测试病人\",\"patname\":\"测试病人\",\"patphone\":\"22\",\"patsex\":\"男\",\"pattype\":\"OP\",\"appparts\":null,\"apppurpose\":null,\"items\":[{\"itemid\":\"1\",\"itemname\":\"1\",\"itemnum\":\"1\",\"itemtotalamount\":\"1\",\"itemtype\":\"区域LIS\",\"itemunitprice\":\"1\",\"sampleid\":\"sample1\",\"samplename\":\"samplename1\",\"sampletypeid\":\"sampletypeid1\",\"sampletypename\":\"sampletypename1\"},{\"itemid\":\"2\",\"itemname\":\"2\",\"itemnum\":\"2\",\"itemtotalamount\":\"2\",\"itemtype\":\"区域LIS\",\"itemunitprice\":\"2\",\"sampleid\":\"sample2\",\"samplename\":\"samplename2\",\"sampletypeid\":\"sampletypeid2\",\"sampletypename\":\"sampletypename2\"}],\"labclassname\":\"labclassname\",\"specimanname\":\"specimanname\",\"head\":{\"companynum\":\"0002\",\"hash\":\"123456\",\"sign\":\"8417F7E9CE2C7E3F8C141DB86A48C3DA\"}}";
			sendPost("http://192.168.1.103/region_lis/reqOrder/SyncUserInfo.do",aa);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
