package com.cdxt.lisweb.controller.examine;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cdxt.lisweb.entity.examine.LisAiItemDevICD;
import com.cdxt.lisweb.service.examine.LisAiItemDevICDService;
import com.cdxt.lisweb.utils.IDCreateUtils;
/**
 * @author : liushijun
 * @date 创建时间：2018年8月8日 
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: //用于关键词判断页面的一些操作方法
 */
@Controller
@RequestMapping("/ICD")
public class LisAiItemDevICDController {
	@Autowired
	LisAiItemDevICDService lisAiItemDevICDService;
	
	/**
	 * 用于分页查询数据
	 * @param start 前台传来的页码
	 * @param limit	前台传来的每页展示数目
	 * @return
	 */
	@RequestMapping(value = "getItemInfo.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public Map<String, Object> getItemInfoByPage(int start, int limit,String groupId) {
		Map<String, Object> findItemInfo = lisAiItemDevICDService.findItemInfo(start, limit,groupId);
		return findItemInfo;
	}
	
	/**
	 * 用于分页查询数据
	 * @param start 前台传来的页码
	 * @param limit	前台传来的每页展示数目
	 * @param groupId 前台传来下拉设备名字
	 * @return
	 */
	@RequestMapping(value = "getICDInfo.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public Map<String, Object> getICDInfoByPage(int start, int limit, String itemDevId) {
		Map<String, Object> findICDInfo = lisAiItemDevICDService.findICDInfo(start,limit,itemDevId);
		return findICDInfo;
	}

	/**
	 * 保存关键字判断信息
	 * @param data 	关键字数据对象
	 * @return
	 */
	@RequestMapping(value = "saveICDInfo.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public String saveICD(@RequestBody LisAiItemDevICD data) {
		if(StringUtils.hasText(data.getId())){
			LisAiItemDevICD editObj = lisAiItemDevICDService.queryById(data.getId());
			editObj.setLogic(data.getLogic());
			editObj.setcRUX(data.getcRUX());
			editObj.setContent(data.getContent());
			editObj.setAdopt(data.getAdopt());
			lisAiItemDevICDService.update(editObj);
		}else{
			String id = IDCreateUtils.getIcdID();
			data.setId(id);
			lisAiItemDevICDService.save(data);
		}
		return  "{success:true}";
	}
	/**
	 * 更改审核状态
	 * @param data 	当前选中数据对象
	 * @return
	 */
	@RequestMapping(value = "exchangeAdoptICDInfo.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public String exchangeAdopt(String id) {
		LisAiItemDevICD lisAiItemDevICD = lisAiItemDevICDService.queryById(id);
		if(lisAiItemDevICD.getAdopt().equals("1")){
			lisAiItemDevICD.setAdopt("0");
		}else{
			lisAiItemDevICD.setAdopt("1");
		}
		lisAiItemDevICDService.update(lisAiItemDevICD);
		return  "{success:true}";
	}
	
	/**
	 * 删除关键词数据
	 * @return
	 */
	@RequestMapping(value = "deleteKeyWords.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public String deleteKeyWords(String id) {
		if(StringUtils.hasText(id)){
			LisAiItemDevICD obj = lisAiItemDevICDService.queryById(id);
			if(!StringUtils.isEmpty(obj)){
				lisAiItemDevICDService.delete(lisAiItemDevICDService.queryById(id));
				return  "{success:true}";
			}else{
				return  "{success:false}";
			}
		}else{
			return  "{success:false}";
		}
	}
}
