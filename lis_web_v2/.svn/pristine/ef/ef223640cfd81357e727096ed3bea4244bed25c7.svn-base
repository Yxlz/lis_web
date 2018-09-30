package com.cdxt.lisweb.manager.api;

import java.util.List;

import com.cdxt.lisweb.entity.examine.LisAiItemCheckReference;
import com.cdxt.lisweb.entity.examine.LisAiItemDevHist;
import com.cdxt.lisweb.entity.examine.LisAiItemDevICD;
import com.cdxt.lisweb.entity.examine.LisAiItemDevLO;

public interface LisWeb {
	
	/**
	 * 项目id获取范围规则数据
	 * @param itemDevId
	 * @return
	 */
	public List<LisAiItemCheckReference> getRefByItemDevId(String itemDevId );
	
	/**
	 * 根据项目唯一编号获取项目数据
	 * @param itemCode
	 * @return
	 */
	public String getItemIdByItemCode(String itemCode );
	
	/**
	 * 项目id获取逻辑运算规则数据
	 * @param itemDevId
	 * @return
	 */
	public List<LisAiItemDevLO> getLOByItemDevId(String itemDevId );
	
	/**
	 * 根据项目id获取历史规则数据
	 * @param itemDevId
	 * @return
	 */
	public List<LisAiItemDevHist> getHistByItemId(String itemDevId );
	
	/**
	 * 根据项目id获取获取关键词数据
	 * @param itemDevId
	 * @return
	 */
	public List<LisAiItemDevICD> getKeyWords(String itemDevId );
	
}
