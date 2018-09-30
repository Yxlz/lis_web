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
import com.cdxt.lisweb.dao.examine.LisAiItemCheckReferenceDao;
import com.cdxt.lisweb.entity.examine.LisAiItemCheckReference;

/**
 * @author : liushijun
 * @date 创建时间：2018年7月3日 
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: //TODO
 */
@Repository
public class LisAiItemCheckReferenceDaoImpl extends BaseDaoImpl<LisAiItemCheckReference> implements
LisAiItemCheckReferenceDao{
	
	@Override
	public Class<LisAiItemCheckReference> getEntityType() {
		// TODO Auto-generated method stub
		return LisAiItemCheckReference.class;
	}
	
	/**
	 * 用于查找规则
	 */
	@Override
	public Map<String, Object> findJudgeAdded(int start, int limit, String itemId,String typeId) {
		Map<String, Object> queryResult = new HashMap<String, Object>();
		StringBuffer sql = new StringBuffer(" select lidc.item_name,laicr.* "
				+ "from lis_ai_item_check_ref laicr "
				+ "left join lis_item_dev_code lidc "
				+ "on lidc.id=laicr.item_dev_id where 1=1");
		//追加根据分组条件
		if (StringUtils.hasText(itemId)) {
			sql.append(" and laicr.item_dev_id = ? " );
		}
		//追加条件
		if (StringUtils.hasText(typeId)) {
			sql.append(" and laicr.TYPE_ID = ? " );
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
				+ "from lis_ai_item_check_ref laicr "
				+ "left join lis_item_dev_code lidc "
				+ "on lidc.id=laicr.item_dev_id   where 1=1");
		//追加根据分组条件
		if (StringUtils.hasText(itemId)) {
			countsql.append(" and laicr.item_dev_id = ? " );
		}
		//追加根据分组条件
		if (StringUtils.hasText(typeId)) {
			countsql.append(" and laicr.TYPE_ID = ? " );
		}
		Query queryCount = getSession().createSQLQuery(countsql.toString());
		queryCount.setString(0, itemId);
		queryCount.setString(1, typeId);
		queryResult.put(CommonConstants.QUERY_PAGE_TOTAL, queryCount.uniqueResult());
		return queryResult;
	}
	@Override
	public String findJudgeItem(String itemId,String typeId) {
		StringBuffer sql = new StringBuffer("select laicr.id, laicr.TYPE_MARK from lis_ai_item_check_ref laicr  where 1=1");
		//追加项目id
		if (StringUtils.hasText(itemId)) {
			sql.append(" and laicr.item_dev_id = ? " );
		}
		//追加条件
		if (StringUtils.hasText(typeId)) {
			sql.append(" and laicr.TYPE_ID = ? " );
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
	public Map<String, Object> findAddedItem(int start, int limit,String groupId, String typeId) {
		Map<String, Object> queryResult = new HashMap<String, Object>();
		StringBuffer sql = new StringBuffer("select distinct(lidc.item_code),lidc.item_name,lidc.item_name_cn,lidc.id,lidi.dev_name,laicrt.type_name,laicr.type_id,laicr.TYPE_MARK "
				+ "from lis_item_dev_code lidc "
				+ "left join lis_inspec_dev_info lidi "
				+ "on lidi.id=lidc.dev_code "
				+ "left join lis_ai_item_check_ref laicr "
				+ "on laicr.item_dev_id=lidc.id "
				+ "left join lis_ai_item_check_ref_ty laicrt "
				+ "on laicrt.id=laicr.type_id   where 1=1");
		//追加根据分组条件
		if (StringUtils.hasText(groupId)) {
			sql.append(" and lidi.ID = ? " );
		}
		//追加条件
		if (StringUtils.hasText(typeId)) {
			sql.append(" and laicr.TYPE_ID = ? " );
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
				+ "left join lis_ai_item_check_ref laicr "
				+ "on laicr.item_dev_id=lidc.id "
				+ "left join lis_ai_item_check_ref_ty laicrt "
				+ "on laicrt.id=laicr.type_id   where 1=1");
		//追加根据分组条件
		if (StringUtils.hasText(groupId)) {
			countsql.append(" and lidi.ID = ? " );
		}
		//追加根据分组条件
		if (StringUtils.hasText(typeId)) {
			countsql.append(" and laicr.TYPE_ID = ? " );
		}
		Query queryCount = getSession().createSQLQuery(countsql.toString());
		queryCount.setString(0, groupId);
		queryCount.setString(1, typeId);
		queryResult.put(CommonConstants.QUERY_PAGE_TOTAL, queryCount.uniqueResult());
		return queryResult;
	}
	
	@Override
	public List<LisAiItemCheckReference> findScopeJudgeItemObj(String typeId, String itemId) {
		StringBuffer hql = new StringBuffer("from LisAiItemCheckReference O where 1=1 ");
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
	public List<LisAiItemCheckReference> findRefByItemDevId(String itemDevId) {
		StringBuffer hql =new StringBuffer("from LisAiItemCheckReference o where 1=1 ");
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
	@Override
	public String findItemIdByItemCode(String itemCode) {
		StringBuffer hql =new StringBuffer("select t.id from LIS_ITEM_DEV_CODE t where 1=1 ");
		//追加项目编码
		if (StringUtils.hasText(itemCode)) {
			hql.append(" and t.ITEM_CODE = ? " );
		}
		Query query = getSession().createSQLQuery(hql.toString());
		//追加项目编码
		if (StringUtils.hasText(itemCode)) {
			query.setParameter(0, itemCode);
		}
		String string = (String) query.uniqueResult();
		return string;
	}
}
