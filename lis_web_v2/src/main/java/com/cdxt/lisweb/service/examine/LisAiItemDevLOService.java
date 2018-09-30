package com.cdxt.lisweb.service.examine;

import java.util.List;
import java.util.Map;

import com.cdxt.lisweb.entity.examine.LisAiItemDevLO;
import com.cdxt.lisweb.service.BaseService;

/**
 * @author : liushijun
 * @date 创建时间：2018年8月7日 
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: 
 */
public interface LisAiItemDevLOService extends BaseService<LisAiItemDevLO>{
	/**
	 * 用于通过项目id查询添加判断的项目数据
	 * @param start
	 * @param limit
	 * @param itemId
	 * @return
	 */
	public Map<String, Object> findLOJudgeAdded(int start,int limit,String itemId,String typeId);
	
	/**
	 * 用于通过项目id和类型id查询对象
	 * @param itemId
	 * @return
	 */
	public String findLOJudgeItem(String itemId,String typeId);


	/**
	 * 根据分组查询添加类型后的项目
	 * @param start
	 * @param limit
	 * @param typeId 类型Id
	 * @return
	 */
	public Map<String,Object> findLOAddedItem(int start,int limit,String groupId ,String typeId);
	
	public List<LisAiItemDevLO> findLOJudgeItemObj(String typeId, String itemId);
	
	/**
	 * 根据项目id 查询该项目下所有逻辑运算规则
	 * @param itemDevId 项目id
	 * @return
	 */
	public List<LisAiItemDevLO> findLOByItemDevId(String itemDevId);
}
