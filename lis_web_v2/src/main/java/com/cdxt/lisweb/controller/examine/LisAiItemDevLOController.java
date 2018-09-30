package com.cdxt.lisweb.controller.examine;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cdxt.lisweb.entity.examine.LisAiItemDevLO;
import com.cdxt.lisweb.service.examine.LisAiItemDevLOService;
import com.cdxt.lisweb.utils.IDCreateUtils;

/**
 * @author : liushijun
 * @date 创建时间：2018年8月7日 
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: //用于逻辑运算判断规则
 */
@Controller
@RequestMapping("/LOJudge")
public class LisAiItemDevLOController {
	
	@Autowired
	LisAiItemDevLOService lisAiItemDevLOService;
	/**
	 * 为添加到分类的项目维护对应分类的规则
	 * @param data  前台模态框封装的对象
	 * @return
	 */
	@RequestMapping(value = "addLOInfo.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public String addLOInfo(@RequestBody LisAiItemDevLO data) {
		String id ="";
		//通过项目id 和类型id查询 是否是初次添加到类型的项目，如果是初次添加返回对应项目判断规则的id
		String judgeItemId = lisAiItemDevLOService.findLOJudgeItem(data.getItemDevId(), data.getTypeId());
		//判断查询的判断id是有值，若有，则是初次添加规则，直接通过id获取这条规则，设置参数，并且设置初次设置规则的参数TYPE_MARK。
		//若无值，那么该项目是二次添加规则则新增一条规则。设置标记字段
		if(StringUtils.hasText(judgeItemId)){
			LisAiItemDevLO lisAiItemDevLO = lisAiItemDevLOService.queryById(judgeItemId);
			lisAiItemDevLO.setTypeMark("ADDED");
			if(StringUtils.hasText(data.getIsOpenLO())){
				lisAiItemDevLO.setIsOpenLO(data.getIsOpenLO());
			}
			if(StringUtils.hasText(data.getIsOpenLOT())){
				lisAiItemDevLO.setIsOpenLOT(data.getIsOpenLOT());
			}
			if(StringUtils.hasText(data.getLogicalOperationType())){
				lisAiItemDevLO.setLogicalOperationType(data.getLogicalOperationType());
			}
			if(StringUtils.hasText(data.getLogicalOperator())){
				lisAiItemDevLO.setLogicalOperator(data.getLogicalOperator());
			}
			lisAiItemDevLOService.update(lisAiItemDevLO);
			return  "{success:true}";
		}else{
			id = IDCreateUtils.getLogID();
			data.setId(id);
			data.setTypeMark("ADDED");
			lisAiItemDevLOService.save(data);
			return  "{success:true}";
		}
	}
	
	/**
	 * 通过项目id和类型id查询判断规则数据
	 * @return
	 */
	@RequestMapping(value = "getLOJudgeData.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public Map<String,Object> getLOJudgeData(int start, int limit,String itemId,String typeId) {
		Map<String, Object> objToMap = new HashMap<String, Object>();
		objToMap = lisAiItemDevLOService.findLOJudgeAdded(start,limit,itemId,typeId);
		return objToMap;
	}
	/**
	 * 查询已经添加到类型的项目 用于加载已添加到类型项目表格
	 * @param start 前台传来的页码
	 * @param limit	前台传来的每页展示数目
	 * @return
	 */
	@RequestMapping(value = "getLOItemAdded.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public Map<String, Object> queryLOItemAddedByPage(int start, int limit,String groupId,String typeId) {
		Map<String, Object> addedItems = lisAiItemDevLOService.findLOAddedItem(start,limit,groupId, typeId);
		return addedItems;
	}
	
	/**
	 * 用于为类型添加项目
	 * @param data
	 * @return
	 */
	@RequestMapping(value = "addLOItemToType.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public String addLOItemToType(@RequestBody List<LisAiItemDevLO> data) {
		String id = "";
			for (LisAiItemDevLO lisAiItemDevLO : data) {
				id = IDCreateUtils.getLogID();
				lisAiItemDevLO.setId(id);
				lisAiItemDevLOService.save(lisAiItemDevLO);
			}
			return "{success:true}";
		}
	/**
	 * 用于改变该判断规则是否启用的按钮，犹豫一条数据对应类型的开启关闭只有一种。所以做如下判断
	 * @param 
	 * @param 
	 * @throws IOException
	 */
	@RequestMapping(value = "exchangeLOJudgeIsOpen.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public String exchangeLOJudgeIsOpen(String id) {
		LisAiItemDevLO lisAiItemDevLO = lisAiItemDevLOService.queryById(id);
		if(StringUtils.hasText(lisAiItemDevLO.getIsOpenLO())){
			if(lisAiItemDevLO.getIsOpenLO().equals("0")){
				lisAiItemDevLO.setIsOpenLO("1");
			}else if(lisAiItemDevLO.getIsOpenLO().equals("1")){
				lisAiItemDevLO.setIsOpenLO("0");
			}else{
				return "{success:false}";
			}
			lisAiItemDevLOService.update(lisAiItemDevLO);
			return "{success:true}";
		}
		else if(StringUtils.hasText(lisAiItemDevLO.getIsOpenLOT())){
			if(lisAiItemDevLO.getIsOpenLOT().equals("0")){
				lisAiItemDevLO.setIsOpenLOT("1");
			}else if(lisAiItemDevLO.getIsOpenLOT().equals("1")){
				lisAiItemDevLO.setIsOpenLOT("0");
			}else{
				return "{success:false}";
			}
			lisAiItemDevLOService.update(lisAiItemDevLO);
			return "{success:true}";
		}
		else{
			return "{success:false}";
		}
	}
	
	/**
	 * 用于删除当前类型已添加的项目
	 */
	@RequestMapping(value = "deleteLOAddedItem.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public String deleteLOAddedItem(String typeId,String itemId) {
		//通过项目id 和类型id 查询出对象
		List<LisAiItemDevLO> lisAiItemDevLOs = lisAiItemDevLOService.findLOJudgeItemObj(typeId, itemId);
		//删除当前对象
		lisAiItemDevLOService.deleteAll(lisAiItemDevLOs);
		
		return "{success:true}";
	}
	
	/**
	 * 修改判断规则
	 * @param data  前台模态框封装的对象
	 * @return
	 */
	@RequestMapping(value = "editLOInfo.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public String editHistInfo(@RequestBody LisAiItemDevLO data) {
		LisAiItemDevLO lisAiItemDevLO = lisAiItemDevLOService.queryById(data.getId());
		if(StringUtils.hasText(data.getIsOpenLO())){
			lisAiItemDevLO.setIsOpenLO(data.getIsOpenLO());
		}
		if(StringUtils.hasText(data.getIsOpenLOT())){
			lisAiItemDevLO.setIsOpenLOT(data.getIsOpenLOT());
		}
		if(StringUtils.hasText(data.getLogicalOperationType())){
			lisAiItemDevLO.setLogicalOperationType(data.getLogicalOperationType());
		}
		if(StringUtils.hasText(data.getLogicalOperator())){
			lisAiItemDevLO.setLogicalOperator(data.getLogicalOperator());
		}
		lisAiItemDevLOService.update(lisAiItemDevLO);
		return "{success:true}";
	}
	
	/**
	 * 用于删除选中的判断规则数据
	 */
	@RequestMapping(value = "deleteLOJudge.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public String deleteLOJudge(@RequestBody List<LisAiItemDevLO> judgeIdList) {
		for (LisAiItemDevLO data : judgeIdList) {
			lisAiItemDevLOService.delete(lisAiItemDevLOService.queryById(data.getId()));
		}
		return "{success:true}";
	}
}
