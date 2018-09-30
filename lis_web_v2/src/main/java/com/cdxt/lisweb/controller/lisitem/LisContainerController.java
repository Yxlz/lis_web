package com.cdxt.lisweb.controller.lisitem;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cdxt.lisweb.constants.CommonConstants;
import com.cdxt.lisweb.controller.BaseController;
import com.cdxt.lisweb.entity.inspec.LisInspecContainer;
import com.cdxt.lisweb.service.lisitem.LisContainerService;
import com.cdxt.lisweb.utils.UseridUtils;

/**
 * @author : zhaozeyu
 * @date 创建时间：2018年1月23日 10:46:36
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: //TODO
 */
@Controller
@RequestMapping("/container")
public class LisContainerController extends BaseController{

	private Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private LisContainerService containerService;

	/**
	 * 获取所有容器
	 * 
	 * @return
	 */
	@RequestMapping(value = "getAllContainer.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public List<LisInspecContainer> getAllContainer() {
		List<LisInspecContainer> list = containerService.queryAll();
		return list;
	}
	
	/**
	 * 根据ID查询容器
	 * 
	 * @return
	 */
	@RequestMapping(value = "getContainerById.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public LisInspecContainer getContainerById(String id) {
		LisInspecContainer result = containerService.queryById(id);
		return result;
	}
	
	/**
	 * 根据Name查询容器 分页  模糊
	 * 
	 * @return
	 */
	@RequestMapping(value = "getContainerByPage.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public Map<String, Object> getContainerByPage(int start, int limit, String name) {
		Map<String, Object> query = new HashMap<String, Object>();
		if (StringUtils.hasText(name)) {
			try {
				query.put("name", new String(name.getBytes("ISO8859-1"), "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				logger.info("容器查询失败："+e.getMessage());
			}
		}
		Map<String, Object> cons = containerService.queryAllByPageMh(start, limit, query);
		return cons;
	}
	
	/**
	 * 保存新增容器容器
	 * 
	 * @return
	 */
	@RequestMapping(value = "saveOrUpdateContainer.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public String saveOrUpdateContainer(@RequestBody LisInspecContainer con) {
		try {
			if (StringUtils.hasText(con.getId())) {
				containerService.update(con);
			} else {
				String id = UseridUtils.getUserID();
				con.setId(id);
				con.setCode(id);
				containerService.save(con);
			}
			return this.createResJson(CommonConstants.INTEGER_ZERO, "success");
		} catch (Exception e) {
			logger.info("容器保存或更新失败："+e.getMessage());
			return this.createResJson(CommonConstants.INTEGER_ONE, e.getMessage());
		}
		
	}
	
	/**
	 * 删除容器
	 * 
	 * @return
	 */
	@RequestMapping(value = "delCons.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public String delCons(@RequestBody List<LisInspecContainer> cons){
		try {
			containerService.deleteAll(cons);
		} catch (Exception e) {
			logger.info("容器删除失败："+e.getMessage());
			return this.createResJson(CommonConstants.INTEGER_ONE, "删除失败.");
		}
		return this.createResJson(CommonConstants.INTEGER_ZERO, "success");
	}
}
