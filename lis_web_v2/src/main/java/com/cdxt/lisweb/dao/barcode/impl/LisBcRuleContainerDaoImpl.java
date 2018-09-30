package com.cdxt.lisweb.dao.barcode.impl;

import org.springframework.stereotype.Repository;

import com.cdxt.lisweb.dao.BaseDaoImpl;
import com.cdxt.lisweb.dao.barcode.LisBcRuleContainerDao;
import com.cdxt.lisweb.entity.barcode.LisWebBcruleContainer;
/**
 * @author : zhaozeyu 
 * @date 创建时间：2018年1月9日 下午4:14:10
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: //TODO
 */
@Repository
public class LisBcRuleContainerDaoImpl extends BaseDaoImpl<LisWebBcruleContainer> implements
LisBcRuleContainerDao{

	@Override
	public Class<LisWebBcruleContainer> getEntityType() {
		return LisWebBcruleContainer.class;
	}

	@Override
	public void deleteByRuleId(String id) {
		String sql = "delete from LIS_WEB_BCRULE_CONTAINER r where r.BARCODE_RULE_ID = :id";
		getSession().createSQLQuery(sql).setParameter("id", id).executeUpdate();
	}

}
