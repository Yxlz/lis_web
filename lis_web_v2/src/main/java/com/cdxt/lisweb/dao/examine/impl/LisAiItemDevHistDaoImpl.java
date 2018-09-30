package com.cdxt.lisweb.dao.examine.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.util.StringUtils;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.cdxt.lisweb.constants.CommonConstants;
import com.cdxt.lisweb.dao.BaseDaoImpl;
import com.cdxt.lisweb.dao.examine.LisAiItemDevHistDao;
import com.cdxt.lisweb.entity.examine.LisAiItemDevHist;

/**
 * @author : liushijun
 * @date 创建时间：2018年7月3日 
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: //TODO
 */
@Repository
public class LisAiItemDevHistDaoImpl  extends BaseDaoImpl<LisAiItemDevHist> implements
LisAiItemDevHistDao{
	
	@Override
	public Class<LisAiItemDevHist> getEntityType() {
		// TODO Auto-generated method stub
		return LisAiItemDevHist.class;
	}

	/**
	 * 用于查找规则
	 */
	@Override
	public Map<String, Object> findHistJudgeAdded(int start, int limit, String itemId,String typeId) {
		Map<String, Object> queryResult = new HashMap<String, Object>();
		StringBuffer sql = new StringBuffer(" select lidc.item_name,laidh.* "
				+ "from lis_ai_item_dev_hist laidh "
				+ "left join lis_item_dev_code lidc "
				+ "on lidc.id=laidh.item_dev_id where 1=1");
		//追加根据分组条件
		if (StringUtils.hasText(itemId)) {
			sql.append(" and laidh.item_dev_id = ? " );
		}
		//追加条件
		if (StringUtils.hasText(typeId)) {
			sql.append(" and laidh.TYPE_ID = ? " );
		}
		Query query = getSession().createSQLQuery(sql.toString()).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		query.setString(0, itemId);
		query.setString(1, typeId);
		query.setFirstResult(start);
		query.setMaxResults(limit);
		List list = query.list();
		queryResult.put(CommonConstants.QUERY_PAGE_ROWS, list);
		//查询总条数
		StringBuffer countsql = new StringBuffer("select count(*)  "
				+ "from lis_ai_item_dev_hist laidh "
				+ "left join lis_item_dev_code lidc "
				+ "on lidc.id=laidh.item_dev_id where 1=1");
		//追加根据分组条件
		if (StringUtils.hasText(itemId)) {
			countsql.append(" and laidh.item_dev_id = ? " );
		}
		//追加根据分组条件
		if (StringUtils.hasText(typeId)) {
			countsql.append(" and laidh.TYPE_ID = ? " );
		}
		Query queryCount = getSession().createSQLQuery(countsql.toString());
		queryCount.setString(0, itemId);
		queryCount.setString(1, typeId);
		queryResult.put(CommonConstants.QUERY_PAGE_TOTAL, queryCount.uniqueResult());
		return queryResult;
	}
	@Override
	public String findHistJudgeItem(String itemId,String typeId) {
		StringBuffer sql = new StringBuffer("select laidh.id, laidh.TYPE_MARK from LIS_AI_ITEM_DEV_HIST laidh  where 1=1");
		//追加项目id
		if (StringUtils.hasText(itemId)) {
			sql.append(" and laidh.item_dev_id = ? " );
		}
		//追加条件
		if (StringUtils.hasText(typeId)) {
			sql.append(" and laidh.TYPE_ID = ? " );
		}
		Query query = getSession().createSQLQuery(sql.toString()).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		query.setString(0, itemId);
		query.setString(1, typeId);
		List<Map<String,String>> jugdeList=query.list();
		for (Map<String, String> map : jugdeList) {
			if(!StringUtils.hasText(map.get("TYPE_MARK"))){
				return map.get("ID");
			}
		}
		return null;
	}
	/**
	 * 用于查询已添加到类型的项目
	 */
	@Override
	public Map<String, Object> findHistAddedItem(int start, int limit,String groupId, String typeId) {
		Map<String, Object> queryResult = new HashMap<String, Object>();
		StringBuffer sql = new StringBuffer("select distinct(lidc.item_code),lidc.item_name,lidc.item_name_cn,lidc.id,lidi.dev_name,laidht.type_name,laidh.type_id,laidh.TYPE_MARK "
				+ "from lis_item_dev_code lidc "
				+ "left join lis_inspec_dev_info lidi "
				+ "on lidi.id=lidc.dev_code "
				+ "left join lis_ai_item_dev_hist laidh "
				+ "on laidh.item_dev_id=lidc.id "
				+ "left join lis_ai_item_dev_hist_type laidht "
				+ "on laidht.id=laidh.type_id where 1=1 ");
		//追加根据分组条件
		if (StringUtils.hasText(groupId)) {
			sql.append(" and lidi.ID = ? " );
		}
		//追加条件
		if (StringUtils.hasText(typeId)) {
			sql.append(" and laidh.TYPE_ID = ? " );
		}
		Query query = getSession().createSQLQuery(sql.toString()).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		query.setString(0, groupId);
		query.setString(1, typeId);
		query.setFirstResult(start);
		query.setMaxResults(limit);
		List list = query.list();
		queryResult.put(CommonConstants.QUERY_PAGE_ROWS, list);
		//查询总条数
		StringBuffer countsql = new StringBuffer("select count(distinct(lidc.item_code))  "
				+ "from lis_item_dev_code lidc "
				+ "left join lis_inspec_dev_info lidi "
				+ "on lidi.id=lidc.dev_code "
				+ "left join lis_ai_item_dev_hist laidh "
				+ "on laidh.item_dev_id=lidc.id "
				+ "left join lis_ai_item_dev_hist_type laidht "
				+ "on laidht.id=laidh.type_id where 1=1 ");
		//追加根据分组条件
		if (StringUtils.hasText(groupId)) {
			countsql.append(" and lidi.ID = ? " );
		}
		//追加根据分组条件
		if (StringUtils.hasText(typeId)) {
			countsql.append(" and laidh.TYPE_ID = ? " );
		}
		Query queryCount = getSession().createSQLQuery(countsql.toString());
		queryCount.setString(0, groupId);
		queryCount.setString(1, typeId);
		queryResult.put(CommonConstants.QUERY_PAGE_TOTAL, queryCount.uniqueResult());
		return queryResult;
	}

	@Override
	public List<LisAiItemDevHist> findHistJudgeItemObj(String typeId, String itemId) {
		StringBuffer hql = new StringBuffer("from LisAiItemDevHist O where 1=1 ");
		//追加根据分组条件
		if (StringUtils.hasText(typeId)) {
			hql.append(" and O.typeId = ? " );
		}
		//追加条件
		if (StringUtils.hasText(itemId)) {
			hql.append(" and O.itemDevId = ? " );
		}
		Query query = getSession().createQuery(hql.toString());
		if(StringUtils.hasText(typeId)){
			query.setString(0, typeId);
		}
		if (StringUtils.hasText(itemId)) {
			query.setString(1, itemId);
		}
		List list = query.list();
		
		return list;
	}

	@Override
	public List<LisAiItemDevHist> findHistByItemDevId(String itemDevId) {
		StringBuffer hql =new StringBuffer("from LisAiItemDevHist o where 1=1 ");
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
