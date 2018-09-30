package com.cdxt.lisweb.service.examine;

import java.util.List;
import java.util.Map;

import com.cdxt.lisweb.entity.examine.LisAiItemCheckReference;
import com.cdxt.lisweb.service.BaseService;

/**
 * @author : liushijun
 * @date 创建时间：2018年7月3日 
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: 
 */
public interface LisAiItemCheckReferenceService extends BaseService<LisAiItemCheckReference>{
	/**
	 * 用于通过项目id查询添加判断的项目数据
	 * @param start
	 * @param limit
	 * @param itemId
	 * @return
	 */
	public Map<String, Object> findJudgeAdded(int start,int limit,String itemId,String typeId);
	
	/**
	 * 用于通过项目id和类型id查询对象
	 * @param itemId
	 * @return
	 */
	public String findJudgeItem(String itemId,String typeId);


	/**
	 * 根据分组查询添加类型后的项目
	 * @param start
	 * @param limit
	 * @param typeId 类型Id
	 * @return
	 */
	public Map<String,Object> findAddedItem(int start,int limit,String groupId ,String typeId);
	
	public List<LisAiItemCheckReference> findScopeJudgeItemObj(String typeId, String itemId);
	
	/**
	 * 根据项目id获取范围判断规则数据
	 * @param itemDevId
	 * @return
	 */
	public List<LisAiItemCheckReference> findRefByItemDevId(String itemDevId);
	
	/**
	 * 根据项目唯一编号获取项目数据
	 * @param itemCode
	 * @return
	 */
	public String findItemIdByItemCode(String itemCode );
}