package com.cdxt.lisweb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 系统通用错误提示控制器
 * 
 * Title: ErrorController.java Description: 描述
 * 
 * @author hezheng
 * @created 2017-5-4 下午6:25:49
 */
@Controller
@RequestMapping("/error")
public class ErrorController extends BaseController {
	private Logger logger = Logger.getLogger(getClass());

	@RequestMapping(value = "/403")
	public void logout(HttpServletRequest request, HttpServletResponse response) {
		try {
			Object user = SecurityUtils.getSubject().getPrincipal();
			logger.warn("用户["+user+"]无权访问目标资源！");
			this.resJsonMessage(response, 3, "您无权访问该资源！");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
