package com.cdxt.lisweb.dao.examine.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.util.StringUtils;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.cdxt.lisweb.constants.CommonConstants;
import com.cdxt.lisweb.dao.BaseDaoImpl;
import com.cdxt.lisweb.dao.examine.LisAiItemDevICDDao;
import com.cdxt.lisweb.entity.examine.LisAiItemDevICD;
import com.cdxt.lisweb.entity.examine.LisAiItemDevLO;

/**
 * @author : liushijun
 * @date 创建时间：2018年7月3日 
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: //TODO
 */
@Repository
public class lisAiItemDevICDDaoImpl  extends BaseDaoImpl<LisAiItemDevICD> implements
LisAiItemDevICDDao{
	
	@Override
	public Class<LisAiItemDevICD> getEntityType() {
		// TODO Auto-generated method stub
		return LisAiItemDevICD.class;
	}
	
	@Override
	public Map<String, Object> findICDInfo(int start, int limit, String itemDevId) {
		Map<String, Object> queryResult = new HashMap<String, Object>();
		//查询智能审核范围分类页面展示的数据
		StringBuffer sql = new StringBuffer("select * from LIS_AI_ITEM_DEV_ICD laidi where 1=1");
		//追加根据分组条件
		if (StringUtils.hasText(itemDevId)) {
			sql.append(" and laidi.ITEM_DEV_ID = ? " );
		}
		Query query = getSession().createSQLQuery(sql.toString()).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		
		if(StringUtils.hasText(itemDevId)){
			query.setString(0, itemDevId);
		}
		query.setFirstResult(start);
		query.setMaxResults(limit);
		List list = query.list();
		queryResult.put(CommonConstants.QUERY_PAGE_ROWS, list);
		//查询总条数
		StringBuffer countsql = new StringBuffer("select count(*) from LIS_AI_ITEM_DEV_ICD laidi where 1=1");
		//追加根据分组条件
		if (StringUtils.hasText(itemDevId)) {
			countsql.append(" and laidi.ITEM_DEV_ID = ?  " );
		}
		Query queryCount = getSession().createSQLQuery(countsql.toString());
		if(StringUtils.hasText(itemDevId)){
			queryCount.setString(0, itemDevId);
		}
		queryResult.put(CommonConstants.QUERY_PAGE_TOTAL, queryCount.uniqueResult());
		return queryResult;
	}

	@Override
	public Map<String, Object> findItemInfo(int start, int limit,String groupId) {
		Map<String, Object> queryResult = new HashMap<String, Object>();
		//查询智能审核范围分类页面展示的数据
		StringBuffer sql = new StringBuffer("select lidc.item_code,lidi.dev_name,lidc.item_name_cn,lidc.item_name,lidc.id,lidc.dev_code "
				+ "from lis_item_dev_code lidc "
				+ "left join lis_inspec_dev_info lidi "
				+ "on lidc.dev_code=lidi.id  where 1=1");
		if(StringUtils.hasText(groupId)){
			sql.append(" and lidc.dev_code = ? " );
		}
		Query query = getSession().createSQLQuery(sql.toString()).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		query.setFirstResult(start);
		query.setMaxResults(limit);
		if(StringUtils.hasText(groupId)){
			query.setString(0, groupId);
		}
		List list = query.list();
		queryResult.put(CommonConstants.QUERY_PAGE_ROWS, list);
		//查询总条数
		StringBuffer countsql = new StringBuffer("select count(*) "
				+ "from lis_item_dev_code lidc "
				+ "left join lis_inspec_dev_info lidi "
				+ "on lidc.dev_code=lidi.id  where 1=1");
		if(StringUtils.hasText(groupId)){
			countsql.append(" and lidc.dev_code = ? " );
		}
		Query queryCount = getSession().createSQLQuery(countsql.toString());
		if(StringUtils.hasText(groupId)){
			queryCount.setString(0, groupId);
		}
		queryResult.put(CommonConstants.QUERY_PAGE_TOTAL, queryCount.uniqueResult());
		return queryResult;
	}

	@Override
	public List<LisAiItemDevICD> findKeyWords(String itemDevId) {
		StringBuffer hql =new StringBuffer("from LisAiItemDevICD o where 1=1 ");
		//追加项目编码
		if (StringUtils.hasText(itemDevId)) {
			hql.append(" and o.itemDevId = ? " );
		}
		Query query = getSession().createQuery(hql.toString());
		//追加项目编码
		if (StringUtils.hasText(itemDevId)) {
			query.setParameter(0, itemDevId);
		}
		List list = query.list();
		return list;
	}

}
