package com.cdxt.lisweb.dao.examine;

import java.util.List;

import com.cdxt.lisweb.dao.BaseDao;
import com.cdxt.lisweb.entity.examine.LisItemDevCode;

/**
 * @author : liushijun
 * @date 创建时间：2018年6月21日 
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: 用于操作LisItemDevCodeDao 项目对象  
 */
public interface LisItemDevCodeDao extends BaseDao<LisItemDevCode>{
	/**
	 * 用于查询下拉设备选择的数据
	 * @return
	 */
	public List<String> getAllEquipment();
	/**
	 * 用于查询下拉设备名字和id
	 * @return
	 */
	public  List<String> getAllEquipmentNameAndId();
	/**
	 * 查询所有项目名称
	 * @return
	 */
	public List<String> findItemName();
}
