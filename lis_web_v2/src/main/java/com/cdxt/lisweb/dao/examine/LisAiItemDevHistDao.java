package com.cdxt.lisweb.dao.examine;

import java.util.List;
import java.util.Map;

import com.cdxt.lisweb.dao.BaseDao;
import com.cdxt.lisweb.entity.examine.LisAiItemDevHist;

/**
 * @author : liushijun
 * @date 创建时间：2018年7月3日 
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: //TODO
 */
public interface LisAiItemDevHistDao extends BaseDao<LisAiItemDevHist>{
	/**
	 * 通过项目id查询当前设置判断规则的项目的判断规则
	 * @param itemId 项目id
	 * @return
	 */
	public Map<String, Object> findHistJudgeAdded(int start, int limit, String itemId,String typeId);
	
	/**
	 * 通过项目id 查询项目对象
	 * @param itemId
	 * @param typeId 
	 * @return
	 */
	public String findHistJudgeItem(String itemId, String typeId);

	/**
	 * 根据分组查询添加类型后的项目
	 * @param start
	 * @param limit
	 * @param typeId 类型Id
	 * @return
	 */
	public Map<String,Object> findHistAddedItem(int start,int limit,String groupId ,String typeId);
	
	/**
	 * 根据类型id和项目id查询所有项目
	 * @param start
	 * @param limit
	 * @param typeId 类型Id
	 * @return
	 */
	public List<LisAiItemDevHist> findHistJudgeItemObj(String typeId,String itemId);
	
	/**
	 * 根据项目id获取历史规则数据
	 * @param itemDevId
	 * @return
	 */
	public List<LisAiItemDevHist> findHistByItemDevId(String itemDevId);
	
}
