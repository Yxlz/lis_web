package com.cdxt.lisweb.dao.examine.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.cdxt.lisweb.constants.CommonConstants;
import com.cdxt.lisweb.dao.BaseDaoImpl;
import com.cdxt.lisweb.dao.examine.LisItemDevCodeDao;
import com.cdxt.lisweb.entity.examine.LisItemDevCode;
/**
 * @author : liushijun
 * @date 创建时间：2018年6月21日 
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: //TODO
 */
@Repository
public class LisItemDevCodeDaoImpl extends BaseDaoImpl<LisItemDevCode> implements
LisItemDevCodeDao{

	@Override
	public Class<LisItemDevCode> getEntityType() {
		// TODO Auto-generated method stub
		return LisItemDevCode.class;
	}
	/**
	 * 用于查询下拉设备选择的数据
	 * @return
	 */
	@Override
	public List<String> getAllEquipment() {
		List<String> queryResult = new ArrayList<String>();
		StringBuffer sql = new StringBuffer("select distinct(DEV_NAME)from lis_inspec_dev_info");
		Query query = getSession().createSQLQuery(sql.toString());
		queryResult = query.list();
		return queryResult;
	}
	@Override
	public List<String> getAllEquipmentNameAndId() {
		//查询指控页面展示的数据
		StringBuffer sql = new StringBuffer("select distinct(DEV_NAME),ID from lis_inspec_dev_info");
		Query query = getSession().createSQLQuery(sql.toString()).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		List list = query.list();
		return list;
	}
	@Override
	public List<String> findItemName() {
		//查询指控页面展示的数据
		StringBuffer sql = new StringBuffer("select distinct(lidc.item_name) from lis_item_dev_code lidc ");
		Query query = getSession().createSQLQuery(sql.toString());
		List list = query.list();
		return list;
	}

}
