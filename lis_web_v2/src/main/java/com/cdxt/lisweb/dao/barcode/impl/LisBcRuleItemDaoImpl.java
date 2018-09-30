package com.cdxt.lisweb.dao.barcode.impl;

import org.springframework.stereotype.Repository;

import com.cdxt.lisweb.dao.BaseDaoImpl;
import com.cdxt.lisweb.dao.barcode.LisBcRuleItemDao;
import com.cdxt.lisweb.entity.barcode.LisWebBcruleItem;

/**
 * @author : zhaozeyu 
 * @date 创建时间：2018年1月9日 下午4:14:10
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: //TODO
 */
@Repository
public class LisBcRuleItemDaoImpl extends BaseDaoImpl<LisWebBcruleItem> implements
LisBcRuleItemDao{

	@Override
	public Class<LisWebBcruleItem> getEntityType() {
		return LisWebBcruleItem.class;
	}

	@Override
	public void deleteByRuleId(String id) {
		String sql = "delete from LIS_WEB_BCRULE_ITEM r where r.MANAGE_ID = :id";
		getSession().createSQLQuery(sql).setParameter("id", id).executeUpdate();
	}

}
