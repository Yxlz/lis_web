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

import com.cdxt.lisweb.entity.examine.LisAiItemDevHist;
import com.cdxt.lisweb.service.examine.LisAiItemDevHistService;
import com.cdxt.lisweb.utils.IDCreateUtils;

/**
 * @author : liushijun
 * @date 创建时间：2018年7月13日 
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: //用于历史数据判断的一些方法
 */
@Controller
@RequestMapping("/historyDataJudge")
public class LisAiItemDevHistController {
	
	@Autowired
	LisAiItemDevHistService lisAiItemDevHistService;
	/**
	 * 为添加到分类的项目维护对应分类的规则
	 * @param data  前台模态框封装的对象
	 * @return
	 */
	@RequestMapping(value = "addHistInfo.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public String addHistInfo(@RequestBody LisAiItemDevHist data) {
		String id ="";
		//通过项目id 和类型id查询 是否是初次添加到类型的项目，如果是初次添加返回对应项目判断规则的id
		String judgeItemId = lisAiItemDevHistService.findHistJudgeItem(data.getItemDevId(), data.getTypeId());
		//判断查询的判断id是有值，若有，则是初次添加规则，直接通过id获取这条规则，设置参数，并且设置初次设置规则的参数TYPE_MARK。
		//若无值，那么该项目是二次添加规则则新增一条规则。设置标记字段
		if(StringUtils.hasText(judgeItemId)){
			LisAiItemDevHist lisAiItemDevHist = lisAiItemDevHistService.queryById(judgeItemId);
			lisAiItemDevHist.setTypeMark("ADDED");
			if(StringUtils.hasText(data.getAbs())){
				lisAiItemDevHist.setAbs(data.getAbs());
			}
			if(StringUtils.hasText(data.getAbsoluteIsOpen())){
				lisAiItemDevHist.setAbsoluteIsOpen(data.getAbsoluteIsOpen());
			}
			if(StringUtils.hasText(data.getHistoryDay())){
				lisAiItemDevHist.setHistoryDay(data.getHistoryDay());
			}
			if(StringUtils.hasText(data.getPercentage())){
				lisAiItemDevHist.setPercentage(data.getPercentage());
			}
			if(StringUtils.hasText(data.getPercentIsOpen())){
				lisAiItemDevHist.setPercentIsOpen(data.getPercentIsOpen());
			}
			lisAiItemDevHistService.update(lisAiItemDevHist);
			return  "{success:true}";
		}else{
			id = IDCreateUtils.getHisID();
			data.setId(id);
			data.setTypeMark("ADDED");
			lisAiItemDevHistService.save(data);
			return  "{success:true}";
		}
	}
	
	/**
	 * 通过项目id和类型id查询判断规则数据
	 * @return
	 */
	@RequestMapping(value = "getHistJudgeData.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public Map<String,Object> getHistJudgeData(int start, int limit,String itemId,String typeId) {
		Map<String, Object> objToMap = new HashMap<String, Object>();
		objToMap = lisAiItemDevHistService.findHistJudgeAdded(start,limit,itemId,typeId);
		return objToMap;
	}
	/**
	 * 查询已经添加到类型的项目 用于加载已添加到类型项目表格
	 * @param start 前台传来的页码
	 * @param limit	前台传来的每页展示数目
	 * @return
	 */
	@RequestMapping(value = "getHistItemAdded.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public Map<String, Object> queryHistItemAddedByPage(int start, int limit,String groupId,String typeId) {
		Map<String, Object> addedItems = lisAiItemDevHistService.findHistAddedItem(start,limit,groupId, typeId);
		return addedItems;
	}
	
	/**
	 * 用于为类型添加项目
	 * @param data
	 * @return
	 */
	@RequestMapping(value = "addHistItemToType.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public String addHistItemToType(@RequestBody List<LisAiItemDevHist> data) {
		String id = "";
			for (LisAiItemDevHist lisAiItemDevHist : data) {
				id = IDCreateUtils.getHisID();
				lisAiItemDevHist.setId(id);
				lisAiItemDevHistService.save(lisAiItemDevHist);
			}
			return "{success:true}";
		}
	/**
	 * 用于改变该判断规则是否启用的按钮，犹豫一条数据对应类型的开启关闭只有一种。所以做如下判断
	 * @param 
	 * @param 
	 * @throws IOException
	 */
	@RequestMapping(value = "exchangeHistJudgeIsOpen.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public String exchangeHistJudgeIsOpen(String id) {
		LisAiItemDevHist lisAiItemDevHist = lisAiItemDevHistService.queryById(id);
		if(StringUtils.hasText(lisAiItemDevHist.getAbsoluteIsOpen())){
			if(lisAiItemDevHist.getAbsoluteIsOpen().equals("0")){
				lisAiItemDevHist.setAbsoluteIsOpen("1");
			}else if(lisAiItemDevHist.getAbsoluteIsOpen().equals("1")){
				lisAiItemDevHist.setAbsoluteIsOpen("0");
			}else{
				return "{success:false}";
			}
			lisAiItemDevHistService.update(lisAiItemDevHist);
			return "{success:true}";
		}
		else if(StringUtils.hasText(lisAiItemDevHist.getPercentIsOpen())){
			if(lisAiItemDevHist.getPercentIsOpen().equals("0")){
				lisAiItemDevHist.setPercentIsOpen("1");
			}else if (lisAiItemDevHist.getPercentIsOpen().equals("1")){
				lisAiItemDevHist.setPercentIsOpen("0");
			}else{
				return "{success:false}";
			}
			lisAiItemDevHistService.update(lisAiItemDevHist);
			return "{success:true}";
		}
		else{
			return "{success:false}";
		}
	}
	/**
	 * 用于删除当前类型已添加的项目
	 */
	@RequestMapping(value = "deleteAddedItem.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public String deleteAddedItem(String typeId,String itemId) {
		//通过项目id 和类型id 查询出对象
		List<LisAiItemDevHist> histJudgeItemObj = lisAiItemDevHistService.findHistJudgeItemObj(typeId, itemId);
		//删除当前对象
		lisAiItemDevHistService.deleteAll(histJudgeItemObj);
		
		return "{success:true}";
	}
	
	/**
	 * 修改判断规则
	 * @param data  前台模态框封装的对象
	 * @return
	 */
	@RequestMapping(value = "editHistInfo.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public String editHistInfo(@RequestBody LisAiItemDevHist data) {
		LisAiItemDevHist lisAiItemDevHist = lisAiItemDevHistService.queryById(data.getId());
		if(StringUtils.hasText(data.getAbs())){
			lisAiItemDevHist.setAbs(data.getAbs());
		}
		if(StringUtils.hasText(data.getAbsoluteIsOpen())){
			lisAiItemDevHist.setAbsoluteIsOpen(data.getAbsoluteIsOpen());
		}
		if(StringUtils.hasText(data.getHistoryDay())){
			lisAiItemDevHist.setHistoryDay(data.getHistoryDay());
		}
		if(StringUtils.hasText(data.getPercentage())){
			lisAiItemDevHist.setPercentage(data.getPercentage());
		}
		if(StringUtils.hasText(data.getPercentIsOpen())){
			lisAiItemDevHist.setPercentIsOpen(data.getPercentIsOpen());
		}
		lisAiItemDevHistService.update(lisAiItemDevHist);
		return "{success:true}";
	}
	/**
	 * 用于删除选中的判断规则数据
	 */
	@RequestMapping(value = "deleteHistJudge.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public String deleteHistJudge(@RequestBody List<LisAiItemDevHist> judgeIdList) {
		for (LisAiItemDevHist data : judgeIdList) {
			lisAiItemDevHistService.delete(lisAiItemDevHistService.queryById(data.getId()));
		}
		return "{success:true}";
	}
}
