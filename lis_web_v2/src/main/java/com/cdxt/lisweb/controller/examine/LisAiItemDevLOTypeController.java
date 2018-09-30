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

import com.cdxt.lisweb.entity.examine.LisAiItemDevLOType;
import com.cdxt.lisweb.service.examine.LisAiItemDevLOTypeService;
import com.cdxt.lisweb.utils.IDCreateUtils;

/**
 * @author : liushijun
 * @date 创建时间：2018年8月7日 
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: //用于逻辑判断类型的一些方法
 */
@Controller
@RequestMapping("/LOType")
public class LisAiItemDevLOTypeController {
	@Autowired
	LisAiItemDevLOTypeService lisAiItemDevLOTypeService; 
	/**
	 * 用于通过分组，或者直接展示整个类型表格数据
	 * @param start 前台传来的页码
	 * @param limit	前台传来的每页展示数目
	 * @param groupId 分组id
	 * @return
	 */
	@RequestMapping(value = "getLOTypeInfo.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public Map<String, Object> queryLOTypeByPage(int start, int limit,String groupId) {
		Map<String, Object> findLOTypeByPage = lisAiItemDevLOTypeService.findLOTypeByPage(start, limit,groupId);
		return findLOTypeByPage;
	}
	/**
	 * 保存智能审核范围类型
	 * @param 
	 * @param 
	 * @throws IOException
	 */
	@RequestMapping(value = "addLOTypeInfo.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public String addLOTypeInfo(@RequestBody LisAiItemDevLOType data) {
		List<String> lOTGroupType = lisAiItemDevLOTypeService.findLOTGroupType(data.getGroupId(), data.getTypeName());
			if(StringUtils.hasText(data.getId())){
				data.setRemarkTypeLO(data.getRemarkTypeLO());
				data.setTypeName(data.getTypeName());
				data.setGroupId(data.getGroupId());
				data.setIsOpenTypeLO(data.getIsOpenTypeLO());
				data.setIsDelete("0");
				lisAiItemDevLOTypeService.update(data);
				return "{success:true}";
			}else{
				String id =IDCreateUtils.getTypeID();
				data.setId(id);
				data.setRemarkTypeLO(data.getRemarkTypeLO());
				data.setTypeName(data.getTypeName());
				data.setGroupId(data.getGroupId());
				data.setIsOpenTypeLO(data.getIsOpenTypeLO());
				data.setIsDelete("0");
				if(lOTGroupType.size()<=0){
					lisAiItemDevLOTypeService.save(data);
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
	@RequestMapping(value = "exchangeLOTypeIsOpen.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public String exchangeLOTypeIsOpen(@RequestBody LisAiItemDevLOType dataOpenState) {
		String isOpen=dataOpenState.getIsOpenTypeLO();
		if(isOpen.equals("0")){
			dataOpenState.setIsOpenTypeLO("1");
			lisAiItemDevLOTypeService.update(dataOpenState);
			return "{success:true}";
		}else{
			dataOpenState.setIsOpenTypeLO("0");
			lisAiItemDevLOTypeService.update(dataOpenState);
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
	@RequestMapping(value = "getLOItemNotAdd.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public Map<String, Object> getLOTypeItemNotAddList(int start, int limit,String groupId,String typeId) {
		Map<String, Object> itemList = lisAiItemDevLOTypeService.findLOTypeItemNotAdd(start, limit,groupId,typeId);
		return itemList;
	}
	
	/**
	 * 获取的下拉标本数据
	 * @param aiQcList
	 * @return
	 */	
	@RequestMapping(value = "getLOTypeSampleInfo.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public List<String>  getLOSampleInfo() {
		List<String>  allSampleName = lisAiItemDevLOTypeService.findLOTypeSampleNameInfo();
		return allSampleName;
	}
	
	/**
	 * 用于删除选中的类型数据
	 */
	@RequestMapping(value = "deleteLOTType.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public String deleteType(@RequestBody List<LisAiItemDevLOType> typeIdList) {
		LisAiItemDevLOType queryById = new LisAiItemDevLOType();
		for (LisAiItemDevLOType lisAiItemDevLOType : typeIdList) {
			queryById = lisAiItemDevLOTypeService.queryById(lisAiItemDevLOType.getId());
			queryById.setIsDelete("1");
			lisAiItemDevLOTypeService.update(queryById);
		}
		return "{success:true}";
	}
}
