package com.cdxt.lisweb.service.examine;

import java.util.List;
import java.util.Map;

import com.cdxt.lisweb.entity.examine.LisAiItemCheckReferenceTy;
import com.cdxt.lisweb.service.BaseService;

/**
 * @author : liushijun
 * @date 创建时间：2018年7月3日 
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: 
 */
public interface LisAiItemCheckReferenceTyService extends BaseService<LisAiItemCheckReferenceTy>{
	
	
	/**
	 * 用于分页查询数据
	 * @param start
	 * @param limit
	 * @param groupId
	 * @return
	 */
	public Map<String,Object> findAICRTByPage(int start,int limit,String groupId);
	
	/**
	 * 双击分类展示未添加项目
	 * @param start
	 * @param limit
	 * @param groupId
	 * @return
	 */
	public Map<String, Object> findItemNotAdd(int start, int limit, String groupId,String typeId);
	
	/**
	 * 用于标本下拉查询
	 * @return
	 */
	public List<String> findSampleNameInfo();
	
	public List<String> findAiItemGroupType(String groupId,String typeName);
}
