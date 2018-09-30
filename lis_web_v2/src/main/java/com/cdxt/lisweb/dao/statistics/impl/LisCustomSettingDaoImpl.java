package com.cdxt.lisweb.dao.statistics.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.cdxt.lisweb.dao.BaseDaoImpl;
import com.cdxt.lisweb.dao.statistics.LisCustomSettingDao;
import com.cdxt.lisweb.entity.statistics.LisCustomSetting;

/**
 * @author : Tangxiaohui 
 * @date 创建时间：2018年1月9日 下午4:14:10
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: //TODO
 */
@Repository
public class LisCustomSettingDaoImpl extends BaseDaoImpl<LisCustomSetting> implements
		LisCustomSettingDao {

	@Override
	public String getUrlByUrlName(String url_name) throws Exception {
		Query query = getSession().createSQLQuery("select distinct t.URL from LIS_CUSTOM_SETTING t where t.MENU_NAME=:urlName").setParameter("urlName", url_name);
		return (String) query.uniqueResult();
	}

	@Override
	public Class<LisCustomSetting> getEntityType() {
		return LisCustomSetting.class;
	}

	
}
