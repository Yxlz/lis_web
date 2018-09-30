package com.cdxt.lisweb.dao.examine;

import java.util.Map;

import com.cdxt.lisweb.dao.BaseDao;
import com.cdxt.lisweb.entity.examine.LisAiQcItemDevCode;

/**
 * @author : liushijun
 * @date 创建时间：2018年6月21日 
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: //TODO
 */
public interface LisAiQcItemDevCodeDao extends BaseDao<LisAiQcItemDevCode>{
	/**
	 * 用于分页查询数据
	 * @param start
	 * @param limit
	 * @param name
	 * @return
	 */
	public Map<String,Object> findAiQcByPage(int start,int limit,String name);
	/**
	 * 用于根据页面传过来的项目id查询 质控表的该项目id下这条数据的id
	 * @param id
	 * @return
	 */
	public String findAiQcByItemDevId(String id);
}
