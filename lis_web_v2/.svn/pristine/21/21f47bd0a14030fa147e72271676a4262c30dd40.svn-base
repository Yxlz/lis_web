package com.cdxt.lisweb.dao.user.impl;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.cdxt.lisweb.dao.BaseDaoImpl;
import com.cdxt.lisweb.dao.user.LisHospitalDao;
import com.cdxt.lisweb.entity.user.LisHospital;
import com.cdxt.lisweb.constants.CommonConstants;
/**
 * @author : zhaozeyu 
 * @date 创建时间：2018年1月4日 下午1:43:42
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: //TODO
 */
@Repository
public class LisHospitalDaoImpl extends BaseDaoImpl<LisHospital> implements
		LisHospitalDao {

	@Override
	public Class<LisHospital> getEntityType() {
		return LisHospital.class;
	}

	@Override
	public Map<String, Object> queryHosByPage(int start, int limit, String name) {
		Map<String, Object> queryResult = new HashMap<String, Object>();
		StringBuffer hql = new StringBuffer("from LisHospital where 1=1  ");
		if (StringUtils.hasText(name)) {
			hql.append("and hospName like '%" + name + "%'");
		}
		Query query = getSession().createQuery(hql.toString());
		query.setFirstResult(start);
		query.setMaxResults(limit);
		queryResult.put(CommonConstants.QUERY_PAGE_ROWS, query.list());
		
		StringBuffer countHql = new StringBuffer("select count(*) from LisHospital where 1=1  ");
		if (StringUtils.hasText(name)) {
			countHql.append("and hospName like '%" + name + "%'");
		}
		Query queryCount = getSession().createQuery(countHql.toString());
		queryResult.put(CommonConstants.QUERY_PAGE_TOTAL, queryCount.uniqueResult());
		return queryResult;
	}

}
