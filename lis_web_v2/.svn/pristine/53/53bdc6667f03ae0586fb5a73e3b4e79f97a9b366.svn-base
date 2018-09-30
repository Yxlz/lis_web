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

import com.cdxt.lisweb.entity.examine.LisAiItemCheckReferenceTy;
import com.cdxt.lisweb.service.examine.LisAiItemCheckReferenceTyService;
import com.cdxt.lisweb.utils.IDCreateUtils;

/**
 * @author : liushijun
 * @date 创建时间：2018年7月3日 
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: //用于智能审核范围类型的展示 操作的一些功能方法
 */
@Controller
@RequestMapping("/referenceType")
public class LisAiItemCheckReferenceTyController {
	
	@Autowired
	LisAiItemCheckReferenceTyService lisAiItemCheckReferenceTyService;
	
	/**
	 * 用于通过分组，或者直接展示整个类型表格数据
	 * @param start 前台传来的页码
	 * @param limit	前台传来的每页展示数目
	 * @param groupId 分组id
	 * @return
	 */
	@RequestMapping(value = "getReferenceTypeInfo.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public Map<String, Object> queryReferenceTypeByPage(int start, int limit,String groupId) {
		Map<String, Object> findAICRTByPage = lisAiItemCheckReferenceTyService.findAICRTByPage(start, limit,groupId);
		return findAICRTByPage;
	}
	/**
	 * 保存智能审核范围类型
	 * @param 
	 * @param 
	 * @throws IOException
	 */
	@RequestMapping(value = "addReferenceTypeInfo.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public String addReferenceTypeInfo(@RequestBody LisAiItemCheckReferenceTy data) {
		List<String> aiItemGroupType = lisAiItemCheckReferenceTyService.findAiItemGroupType(data.getGroupId(), data.getTypeName());
			if(StringUtils.hasText(data.getId())){
				data.setRemark(data.getRemark());
				data.setTypeName(data.getTypeName());
				data.setGroupId(data.getGroupId());
				data.setIsOpen(data.getIsOpen());
				data.setIsDelete("0");
				lisAiItemCheckReferenceTyService.update(data);
				return "{success:true}";
			}else{
				String id = IDCreateUtils.getTypeID();
				data.setId(id);
				data.setRemark(data.getRemark());
				data.setTypeName(data.getTypeName());
				data.setGroupId(data.getGroupId());
				data.setIsOpen(data.getIsOpen());
				data.setIsDelete("0");
				if(aiItemGroupType.size()<=0){
					lisAiItemCheckReferenceTyService.save(data);
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
	@RequestMapping(value = "exchangeIsOpen.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public String exchangeIsOpen(@RequestBody LisAiItemCheckReferenceTy dataOpenState) {
		String isOpen=dataOpenState.getIsOpen();
		if(isOpen.equals("0")){
			dataOpenState.setIsOpen("1");
			lisAiItemCheckReferenceTyService.update(dataOpenState);
			return "{success:true}";
		}else if(isOpen.equals("1")){
			dataOpenState.setIsOpen("0");
			lisAiItemCheckReferenceTyService.update(dataOpenState);
			return "{success:true}";
		}else{
			return "{success:false}";
		}
	}

	/**
	 * 根据双击的分类行查询所有该行的分组对应的项目
	 * @param start 前台传来的页码
	 * @param limit	前台传来的每页展示数目
	 * @param groupId 分组id
	 * @return
	 */
	@RequestMapping(value = "getItemNotAdd.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public Map<String, Object> getItemNotAddList(int start, int limit,String groupId,String typeId) {
		Map<String, Object> itemList = lisAiItemCheckReferenceTyService.findItemNotAdd(start, limit,groupId,typeId);
		return itemList;
	}
	
	/**
	 * 获取的下拉标本数据
	 * @param aiQcList
	 * @return
	 */	
	@RequestMapping(value = "getSampleInfo.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public List<String>  getSampleNameInfo() {
		List<String>  allSampleName = lisAiItemCheckReferenceTyService.findSampleNameInfo();
		return allSampleName;
	}
	
	/**
	 * 用于删除选中的类型数据
	 */
	@RequestMapping(value = "deleteType.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public String deleteType(@RequestBody List<LisAiItemCheckReferenceTy> typeIdList) {
		LisAiItemCheckReferenceTy queryById = new LisAiItemCheckReferenceTy();
		for (LisAiItemCheckReferenceTy lisAiItemCheckReferenceTy : typeIdList) {
			queryById = lisAiItemCheckReferenceTyService.queryById(lisAiItemCheckReferenceTy.getId());
			queryById.setIsDelete("1");
			lisAiItemCheckReferenceTyService.update(queryById);
		}
		return "{success:true}";
	}

}
