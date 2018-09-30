package com.cdxt.lisweb.service.examine;

import java.util.List;
import java.util.Map;

import com.cdxt.lisweb.entity.examine.LisAiItemDevHistType;
import com.cdxt.lisweb.service.BaseService;

/**
 * @author : liushijun
 * @date 创建时间：2018年7月6日 
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: 
 */
public interface LisAiItemDevHistTypeService extends BaseService<LisAiItemDevHistType>{
	/**
	 * 根据分组查询分类
	 * @param start
	 * @param limit
	 * @param groupId 分组Id
	 * @return
	 */
	public Map<String,Object> findHistByPage(int start,int limit,String groupId);
	
	/**
	 * 根据双击的分类行查询所有该行的分组和未添加该分类对应的项目
	 * @param start
	 * @param limit
	 * @param groupId
	 * @return
	 */
	public Map<String,Object> findHistItemNotAdd(int start,int limit,String groupId,String typeId);
	
	/**
	 * 查询标本下拉的数据
	 * @return
	 */
	public List<String> findHistSampleNameInfo();
	
	/**
	 * 用于判断新建的该分组类型是否存在
	 * @param groupId
	 * @param typeName
	 * @return
	 */
	public List<String> findHistGroupType(String groupId,String typeName);
}
