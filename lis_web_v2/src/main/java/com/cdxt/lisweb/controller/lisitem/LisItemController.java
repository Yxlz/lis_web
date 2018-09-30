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
import com.cdxt.lisweb.entity.inspec.LisRequestionItem;
import com.cdxt.lisweb.service.lisitem.LisReqItemService;
import com.cdxt.lisweb.utils.UseridUtils;

/**
 * @author : zhaozeyu
 * @date 创建时间：2018年1月23日 10:46:36
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: //TODO
 */
@Controller
@RequestMapping("/item")
public class LisItemController extends BaseController {

	private Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private LisReqItemService reqItemService;

	/**
	 * 获取所有项目 分页
	 * 
	 * @return
	 */
	@RequestMapping(value = "getItemByPage.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public Map<String, Object> getItemByPage(int start, int limit,
			String inspecName, String requestionName) {
		Map<String, Object> query = new HashMap<String, Object>();
		if (StringUtils.hasText(inspecName)) {
			try {
				query.put("inspecName", new String(inspecName.getBytes("ISO8859-1"), "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				logger.info("项目查询失败"+e.getMessage());
				e.printStackTrace();
			}
		}
		if (StringUtils.hasText(requestionName)) {
			try {
				query.put("requestionName", new String(requestionName.getBytes("ISO8859-1"), "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				logger.info("项目查询失败"+e.getMessage());
				e.printStackTrace();
			}
		}
		Map<String,Object> map = reqItemService.queryAllByPageMh(start, limit, query);
		return map;
	}

	/**
	 * 获取所有项目
	 * 
	 * @return
	 */
	@RequestMapping(value = "getAllItem.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public List<LisRequestionItem> getAllItem() {
		List<LisRequestionItem> list = reqItemService.queryAll();
		return list;
	}

	/**
	 * 根据ID查询容器
	 * 
	 * @return
	 */
	@RequestMapping(value = "getItemById.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public LisRequestionItem getItemById(String id) {
		LisRequestionItem result = reqItemService.queryById(id);
		return result;
	}
	
	/**
	 * 保存或更新项目
	 * 
	 * @return
	 */
	@RequestMapping(value = "saveOrUpdateItem.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public String saveOrUpdateItem(@RequestBody LisRequestionItem item) {
		try {
			if (StringUtils.hasText(item.getId())) {
				reqItemService.update(item);
			} else {
				String id = UseridUtils.getUserID();
				item.setId(id);
				item.setRequestionCode(id);
				reqItemService.save(item);
			}
		} catch (Exception e) {
			logger.info("项目保存失败"+e.getMessage());
			return this.createResJson(CommonConstants.INTEGER_ONE, "项目保存失败"+e.getMessage());
		}
		return this.createResJson(CommonConstants.INTEGER_ZERO, "success");
	}
	
	/**
	 * 删除项目
	 * 
	 * @return
	 */
	@RequestMapping(value = "deleteItem.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public String delCons(@RequestBody List<LisRequestionItem> items){
		try {
			reqItemService.deleteAll(items);
		} catch (Exception e) {
			logger.info("项目删除失败"+e.getMessage());
			return this.createResJson(CommonConstants.INTEGER_ONE, "删除失败."+e.getMessage());
		}
		return this.createResJson(CommonConstants.INTEGER_ZERO, "success");
	}
}
