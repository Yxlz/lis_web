package com.cdxt.lisweb.service.examine;

import java.util.Map;

import com.cdxt.lisweb.entity.examine.LisAiQcItemDevCode;
import com.cdxt.lisweb.service.BaseService;

/**
 * @author : liushijun
 * @date 创建时间：2018年6月21日 
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: 
 */
public interface LisAiQcItemDevCodeService extends BaseService<LisAiQcItemDevCode>{
	public Map<String, Object> findAiQcByPage(int start, int limit, String name);
	public String findAiQcByItemDevId(String id);
}
