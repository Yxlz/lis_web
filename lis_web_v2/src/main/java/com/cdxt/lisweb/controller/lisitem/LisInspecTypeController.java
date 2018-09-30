package com.cdxt.lisweb.controller.lisitem;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cdxt.lisweb.constants.CommonConstants;
import com.cdxt.lisweb.controller.BaseController;
import com.cdxt.lisweb.entity.inspec.LisInspecTypeName;
import com.cdxt.lisweb.service.lisitem.LisInspecTypeService;
import com.cdxt.lisweb.utils.UseridUtils;

/**
 * @author : zhaozeyu
 * @date 创建时间：2018年1月23日 10:46:36
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: //TODO
 */
@Controller
@RequestMapping("/inspecType")
public class LisInspecTypeController extends BaseController {
	
	private Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private LisInspecTypeService lisInspecTypeService;
	
	/**
	 * 获取所有检验类别
	 * 
	 * @return
	 */
	@RequestMapping(value = "getAllType.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public List<LisInspecTypeName> getAllType(){
		 List<LisInspecTypeName> list = lisInspecTypeService.queryAll();
		 return list;
	}
	
	/**
	 * 保存或更新检验类别
	 * 
	 * @return
	 */
	@RequestMapping(value = "saveOrUpdateType.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public String saveOrUpdateType(@RequestBody LisInspecTypeName type){
		try {
			if (StringUtils.hasText(type.getId())) {
				lisInspecTypeService.update(type);
			} else {
				String id = UseridUtils.getUserID();
				type.setId(id);
				type.setCode(id);
				lisInspecTypeService.save(type);
			}
		} catch (Exception e) {
			logger.info("检验类别保存失败"+e.getMessage());
			return this.createResJson(CommonConstants.INTEGER_ONE, "保存失败");
		}
		return this.createResJson(CommonConstants.INTEGER_ZERO, "success");
	}
	
	/**
	 * 删除类别
	 * 
	 * @return
	 */
	@RequestMapping(value = "deleteType.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public String delCons(@RequestBody List<LisInspecTypeName> types){
		try {
			lisInspecTypeService.deleteAll(types);
		} catch (Exception e) {
			logger.info("检验类别删除失败"+e.getMessage());
			return this.createResJson(CommonConstants.INTEGER_ONE, "删除失败."+e.getMessage());
		}
		return this.createResJson(CommonConstants.INTEGER_ZERO, "success");
	}
	
	/**
	 * 查询标本类型
	 * 
	 * @return
	 */
	@RequestMapping(value = "getSampleType.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public List<String> getSampleType(){
		return lisInspecTypeService.querySampleType();
	}
}

