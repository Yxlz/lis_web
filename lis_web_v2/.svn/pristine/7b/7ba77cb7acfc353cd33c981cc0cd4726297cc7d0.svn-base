package com.cdxt.lisweb.dao.examine;

import java.util.List;
import java.util.Map;

import com.cdxt.lisweb.dao.BaseDao;
import com.cdxt.lisweb.entity.examine.LisAiItemDevICD;

/**
 * @author : liushijun
 * @date 创建时间：2018年8月8日 
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: //TODO
 */
public interface LisAiItemDevICDDao extends BaseDao<LisAiItemDevICD>{
	
	/**
	 * 用于查询所有项目
	 * @param start
	 * @param limit
	 * @return
	 */
	public Map<String,Object> findItemInfo(int start,int limit,String groupId);
	
	/**
	 * 用于根据项目查询对应的关键字数据
	 * @param start
	 * @param limit
	 * @param itemDevId
	 * @return
	 */
	public Map<String,Object> findICDInfo(int start,int limit,String itemDevId);
	
	/**
	 * 根据项目id获取获取关键词数据
	 * @param itemDevId
	 * @return
	 */
	public List<LisAiItemDevICD> findKeyWords(String itemDevId );
}
