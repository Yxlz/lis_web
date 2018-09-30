package com.cdxt.lisweb.controller.statistics;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cdxt.lisweb.controller.BaseController;
import com.cdxt.lisweb.service.statistics.LisCustomSettingService;

/**
 * @author : Tangxiaohui
 * @date 创建时间：2018年1月9日 下午3:52:17
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: LisCustomSetting为原数据库中的配置文件，主要配置菜单的路径
 */
@Controller
@RequestMapping("/statistics")
public class LisCustomSettingController extends BaseController {

	private static final Logger logger = LoggerFactory
			.getLogger(LisCustomSettingController.class);

	@Autowired
	private LisCustomSettingService lisCustomSettingService;

	@RequestMapping(value = "getUrl.do", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public void getUrl(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String url = null;
		String dataStr = "";
		try {
			dataStr = getRequestBody(request);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		logger.info("请求数据：" + dataStr);
		JSONObject datas = JSONObject.fromObject(dataStr);
		String url_name = (String) datas.get("url_name");
		try {
			url = lisCustomSettingService.getUrlByUrlName(url_name);
		} catch (Exception e) {
			e.printStackTrace();
			this.resJsonMessage(response,url);
		}
		this.resJsonMessage(response, url);
	}
}
