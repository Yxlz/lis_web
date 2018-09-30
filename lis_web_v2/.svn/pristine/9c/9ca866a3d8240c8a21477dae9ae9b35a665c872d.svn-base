package com.cdxt.lisweb.service.examine;

import java.util.List;
import java.util.Map;

import com.cdxt.lisweb.entity.examine.LisAiItemDevICD;
import com.cdxt.lisweb.service.BaseService;

/**
 * @author : liushijun
 * @date 创建时间：2018年8月8日 
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: 
 */
public interface LisAiItemDevICDService extends BaseService<LisAiItemDevICD>{
	
	public Map<String,Object> findICDInfo(int start,int limit,String itemDevId);
	
	public Map<String, Object> findItemInfo(int start, int limit,String groupId);
	
	/**
	 * 根据项目id获取获取关键词数据
	 * @param itemDevId
	 * @return
	 */
	public List<LisAiItemDevICD> findKeyWords(String itemDevId );
}
