package com.cdxt.lisweb.dao.examine;

import java.util.List;
import java.util.Map;

import com.cdxt.lisweb.dao.BaseDao;
import com.cdxt.lisweb.entity.examine.LisAiItemCheckReferenceTy;
/**
 * @author : liushijun
 * @date 创建时间：2018年7月23日 
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: //用于对范围类型做操作
 */
public interface LisAiItemCheckReferenceTyDao extends BaseDao<LisAiItemCheckReferenceTy>{
	
	/**
	 * 根据分组查询分类
	 * @param start
	 * @param limit
	 * @param groupId 分组Id
	 * @return
	 */
	public Map<String,Object> findAICRTByPage(int start,int limit,String groupId);
	
	/**
	 * 根据双击的分类行查询所有该行的分组和未添加该分类对应的项目
	 * @param start
	 * @param limit
	 * @param groupId
	 * @return
	 */
	public Map<String,Object> findItemNotAdd(int start,int limit,String groupId,String typeId);
	
	/**
	 * 查询标本下拉的数据
	 * @return
	 */
	public List<String> findSampleNameInfo();
	
	/**
	 * 通过分组id 和历史数据类型名称查询 该条数据是否存在
	 * @return
	 */
	public List<String> findAiItemGroupType(String groupId,String typeName);
}
