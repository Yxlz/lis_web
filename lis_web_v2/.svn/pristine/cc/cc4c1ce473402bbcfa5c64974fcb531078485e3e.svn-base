package com.cdxt.lisweb.controller.examine;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cdxt.lisweb.entity.examine.LisAiItemDevHistType;
import com.cdxt.lisweb.service.examine.LisAiItemDevHistTypeService;
import com.cdxt.lisweb.utils.IDCreateUtils;

/**
 * @author : liushijun
 * @date 创建时间：2018年7月13日 
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: //用于历史数据类型的一些方法
 */
@Controller
@RequestMapping("/historyDataType")
public class LisAiItemDevHistTypeController {
	@Autowired
	LisAiItemDevHistTypeService lisAiItemDevHistTypeService; 
	/**
	 * 用于通过分组，或者直接展示整个类型表格数据
	 * @param start 前台传来的页码
	 * @param limit	前台传来的每页展示数目
	 * @param groupId 分组id
	 * @return
	 */
	@RequestMapping(value = "getHistTypeInfo.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public Map<String, Object> queryHistTypeByPage(int start, int limit,String groupId) {
		Map<String, Object> findAICRTByPage = lisAiItemDevHistTypeService.findHistByPage(start, limit,groupId);
		return findAICRTByPage;
	}
	/**
	 * 保存智能审核范围类型
	 * @param 
	 * @param 
	 * @throws IOException
	 */
	@RequestMapping(value = "addHistTypeInfo.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public String addHistTypeInfo(@RequestBody LisAiItemDevHistType data) {
		List<String> groupType = lisAiItemDevHistTypeService.findHistGroupType(data.getGroupId(), data.getTypeName());	
			if(StringUtils.hasText(data.getId())){
				data.setRemark(data.getRemark());
				data.setTypeName(data.getTypeName());
				data.setGroupId(data.getGroupId());
				data.setIsDelete("0");
				data.setIsOpen(data.getIsOpen());
				lisAiItemDevHistTypeService.update(data);
				return "{success:true}";
			}else{
				String id = IDCreateUtils.getTypeID();
				data.setId(id);
				data.setRemark(data.getRemark());
				data.setTypeName(data.getTypeName());
				data.setGroupId(data.getGroupId());
				data.setIsOpen(data.getIsOpen());
				data.setIsDelete("0");
				if(groupType.size()<=0){
					lisAiItemDevHistTypeService.save(data);
					return "{success:true}";
				}else{
					return "{success:false}";
				}
			}
		}
	/**
	 * 用于改变该分类是否启用的按钮
	 * @param 
	 * @param 
	 * @throws IOException
	 */
	@RequestMapping(value = "exchangeHistTypeIsOpen.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public String exchangeHistTypeIsOpen(@RequestBody LisAiItemDevHistType dataOpenState) {
		String isOpen=dataOpenState.getIsOpen();
		if(isOpen.equals("0")){
			dataOpenState.setIsOpen("1");
			lisAiItemDevHistTypeService.update(dataOpenState);
			return "{success:true}";
		}else{
			dataOpenState.setIsOpen("0");
			lisAiItemDevHistTypeService.update(dataOpenState);
			return "{success:true}";
		}
	}

	/**
	 * 根据单击的分类行查询所有该行的分组对应的项目
	 * @param start 前台传来的页码
	 * @param limit	前台传来的每页展示数目
	 * @param groupId 分组id
	 * @return
	 */
	@RequestMapping(value = "getHistItemNotAdd.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public Map<String, Object> getHistItemNotAddList(int start, int limit,String groupId,String typeId) {
		Map<String, Object> itemList = lisAiItemDevHistTypeService.findHistItemNotAdd(start, limit,groupId,typeId);
		return itemList;
	}
	
	/**
	 * 获取的下拉标本数据
	 * @param aiQcList
	 * @return
	 */	
	@RequestMapping(value = "getHistSampleInfo.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public List<String>  getHistSampleInfo() {
		List<String>  allSampleName = lisAiItemDevHistTypeService.findHistSampleNameInfo();
		return allSampleName;
	}
	
	/**
	 * 用于删除选中的类型数据
	 */
	@RequestMapping(value = "deleteHistType.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public String deleteType(@RequestBody List<LisAiItemDevHistType> typeIdList) {
		LisAiItemDevHistType queryById = new LisAiItemDevHistType();
		for (LisAiItemDevHistType lisAiItemDevHistType : typeIdList) {
			queryById = lisAiItemDevHistTypeService.queryById(lisAiItemDevHistType.getId());
			queryById.setIsDelete("1");
			lisAiItemDevHistTypeService.update(queryById);
		}
		return "{success:true}";
	}
	
}
