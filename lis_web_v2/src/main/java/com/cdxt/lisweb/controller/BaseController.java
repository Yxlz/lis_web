package com.cdxt.lisweb.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cdxt.lisweb.constants.CommonConstants;
import com.cdxt.lisweb.entity.user.LisInspecRole;
import com.cdxt.lisweb.entity.user.LisInspecUser;
import com.cdxt.lisweb.utils.DateUtils;
import com.cdxt.lisweb.utils.JsonUtils;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * 拦截所有Controller调用中的异常情况，统一处理为json返回
 * 
 * @author lixying
 * @date 2017年4月20日 下午2:34:48
 * @since 1.0.0
 */
@ControllerAdvice(/* value = {"com.cdxt.regionlis.controller.test"} */)
public class BaseController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/*@Autowired
	protected  HttpServletRequest request;
	
	@Autowired
	protected HttpServletResponse response;
	
	@Autowired
	protected HttpSession session;*/

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public String exceptionHandler(Exception e) {

		Throwable root = e;

		while (root.getCause() != null) {
			root = root.getCause();
		}

	//	logger.error("Controller 统一异常处理", root);
		return String.format("{'success' : false,'msg':'%s'}", root
				.getMessage().trim());
	}
	
	
	/**
	* @Title: authenticationException 
	* @Description: 用户未登陆
	* @最后修改人：hezheng
	* @最后修改时间：2017-5-2 下午4:42:38
	* @param request
	* @param response
	* @return 对方法的参数进行描述
	* @return String 返回类型
	* @throws
	 */
    @ExceptionHandler({ UnauthenticatedException.class, AuthenticationException.class })
    public String authenticationException(HttpServletRequest request, HttpServletResponse response) {
    	logger.warn("用户未登陆！");
        if (isAjaxRequest(request)) {
            // 输出JSON
        	resJsonMessage(response, 2, "您还未登陆！");
            return null;
        } else {
            return "/login/login";
        }
    }

    /**
    * @Title: authorizationException 
    * @Description: 用户无权访问目标资源
    * @最后修改人：hezheng
    * @最后修改时间：2017-5-2 下午4:42:59
    * @param request
    * @param response
    * @return 对方法的参数进行描述
    * @return String 返回类型
    * @throws
     */
    @ExceptionHandler({ UnauthorizedException.class, AuthorizationException.class })
    public String authorizationException(HttpServletRequest request, HttpServletResponse response) {
    	logger.warn("用户无权访问目标资源！");
    	if (isAjaxRequest(request)) {
            // 输出JSON
            resJsonMessage(response, 3, "您无权访问该资源！");
            return null;
        } else {
        	//不是ajax请求的跳转至403页面
            return "/error/403";
        }
    }

	/**
	 * 获取HTTP request中body字符串内容
	 * @param request
	 * @return
	 * @throws Exception
	 */
	protected String getRequestBody(HttpServletRequest request) throws Exception{
		BufferedReader br = null;
		try {
			br = request.getReader();
			String str = "";
			StringBuffer buffer = new StringBuffer();
			while((str = br.readLine()) != null){
				buffer.append(str);
			}
			return buffer.toString();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}finally{
			if(br!=null){
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * @Title: resJsonMessage
	 * @Description: 返回JSON字符串
	 * @最后修改人：hezheng
	 * @最后修改时间：2017-4-24 上午10:45:16
	 * @param response
	 *            HttpServletResponse对象
	 * @param code
	 *            返回代码
	 * @param message
	 *            返回说明
	 * @return void 返回类型
	 * @throws
	 */
	protected void resJsonMessage(HttpServletResponse response, int code,
			String message) {
		//application/json
		response.setContentType("text/plain;charset=utf-8");
		PrintWriter pw = null;
		try {
			pw = response.getWriter();
			pw.write(createResJson(code, message));
			pw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pw != null) {
				pw.close();
			}
		}
	}
	
	/**
	* @Title: resJsonMessage 
	* @Description: 返回JSON字符串
	* @最后修改人：hezheng
	* @最后修改时间：2017-5-4 上午9:55:14
	* @param response
	* @param code
	* @param message 对方法的参数进行描述
	* @return void 返回类型
	* @throws
	 */
	protected void resJsonMessage(HttpServletResponse response, Object obj) {
		try {
			resJsonMessage(response, JsonUtils.parseToJson(obj));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			logger.error("Json转换失败！"+e.getMessage(), e);
		}
	}
	
	/**
	* @Title: resJsonMessage 
	* @Description: 返回字符串
	* @最后修改人：hezheng
	* @最后修改时间：2017-5-4 上午9:55:14
	* @param response
	* @param code
	* @param message 对方法的参数进行描述
	* @return void 返回类型
	* @throws
	 */
	protected void resJsonMessage(HttpServletResponse response, String str) {
		response.setContentType("text/plain;charset=utf-8");
		PrintWriter pw = null;
		try {
			pw = response.getWriter();
			pw.print(str);
			pw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pw != null) {
				pw.close();
			}
		}
	}
	
	
	protected void resJsonMessage(HttpServletResponse response,int code,String message,Object obj,String appNo) {
		response.setContentType("text/plain;charset=utf-8");
		PrintWriter pw = null;
		try {
			pw = response.getWriter();
			pw.write(createResJson(code, message,appNo,obj));
			pw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pw != null) {
				pw.close();
			}
		}
	}
	
	protected String createResJson(int code, String message,String appNo,Object obj) throws JsonProcessingException{
		/*Map<String,Object> map = new HashMap<String, Object>();
		map.put("code", code);
		map.put("msg", message);
		map.put("msgcreatetime", DateUtils.formatDate(new Date()));
		map.put("appno", appNo);
		map.put("items", JsonUtils.parseToJson(obj));
		return JSONObject.fromObject(map).toString();*/
		return "{\"code\":\"" + code + "\",\"msg\":\"" + message + "\",\"msgcreatetime\":\"" + DateUtils.formatDate(new Date()) +"\",\"appno\":\""+appNo+"\",\"items\":"+JsonUtils.parseToJson(obj)+"}";
	}
	/**
	 * @discription 创建返回的JSON字符串
	 * @author hezheng       
	 * @created 2017-5-8 下午4:35:01
	 * @param @param code
	 * @param @param message
	 * @param @return
	 * @return String
	 */
	protected String createResJson(int code, String message){
		return "{\"code\":\"" + code + "\",\"msg\":\"" + message + "\",\"msgcreatetime\":\"" + DateUtils.formatDate(new Date()) +"\"}";
	}
	
	/**
	 * @discription 创建分页返回的JSON字符串
	 * @author hezheng       
	 * @created 2017-5-8 下午4:35:01
	 * @param @param code
	 * @param @param message
	 * @param @return
	 * @return String
	 * @throws JsonProcessingException 
	 */
	protected String createPageJson(int total,Object obj) throws JsonProcessingException{
		return "{\"total\":\"" + total + "\",\"items\":\"" + JsonUtils.parseToJson(obj) + "\",\"msgcreatetime\":\"" + DateUtils.formatDate(new Date()) +"\"}";
	}
	
	/**
	 * @discription 将对象转成JSON字符串
	 * @author hezheng       
	 * @created 2017-5-8 下午4:35:01
	 * @param @param code
	 * @param @param message
	 * @param @return
	 * @return String
	 * @throws JsonProcessingException 
	 */
	protected String createResJson(int code, String message, Object obj) throws JsonProcessingException{
		return "{\"code\":\"" + code + "\",\"msg\":\"" + message + "\",\"items\":"+JsonUtils.parseToJson(obj)+",\"msgcreatetime\":\"" + DateUtils.formatDate(new Date()) +"\"}";
	}
	
	/**
	* @Title: isAjaxRequest 
	* @Description: 判断请求是否是ajax请求
	* @最后修改人：hezheng
	* @最后修改时间：2017-5-2 下午3:41:35
	* @param request
	* @return 对方法的参数进行描述
	* @return boolean 返回类型
	* @throws
	 */
	protected boolean isAjaxRequest(HttpServletRequest request) {
        String requestedWith = request.getHeader("x-requested-with");
        if (requestedWith != null && requestedWith.equalsIgnoreCase("XMLHttpRequest")) {
            return true;
        } else {
            return false;
        }
    }
	
	/**
	 * @discription 判断用户是否包含管理员权限
	 * @author hezheng       
	 * @created 2017-5-19 下午4:51:03
	 * @param user
	 * @return boolean  true：包含  false：不包含
	 */
	protected boolean isAdmin(LisInspecUser user){
		LisInspecRole role = user.getLisInspecRole();
		/*for(Role role:roles){
			if(CommonConstants.REGION_LIS_ADMIN.equals(role.getPinyin())) 
				return true; 
		}*/
		if(CommonConstants.REGION_LIS_ADMIN.equals(role.getRoleName())){
			return true; 
		}else{
			return false;
		}
	}
}
