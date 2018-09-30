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
import com.cdxt.lisweb.dao.examine.LisAiItemDevLODao;
import com.cdxt.lisweb.entity.examine.LisAiItemDevLO;

/**
 * @author : liushijun
 * @date 创建时间：2018年7月3日 
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: //TODO
 */
@Repository
public class lisAiItemDevLODaoImpl  extends BaseDaoImpl<LisAiItemDevLO> implements
LisAiItemDevLODao{
	
	@Override
	public Class<LisAiItemDevLO> getEntityType() {
		// TODO Auto-generated method stub
		return LisAiItemDevLO.class;
	}

	/**
	 * 用于查找当前项目下对应分类的规则
	 * @param start 前台传过来的页数
	 * @param limit	前台传过来的每页显示条数
	 * @param itemId 项目id
	 * @param typeId 类型id
	 * @return
	 */
	@Override
	public Map<String, Object> findLOJudgeAdded(int start, int limit, String itemId,String typeId) {
		Map<String, Object> queryResult = new HashMap<String, Object>();
		StringBuffer sql = new StringBuffer(" select lidc.item_name,laidlo.* "
				+ "from LIS_AI_ITEM_DEV_LO laidlo "
				+ "left join lis_item_dev_code lidc "
				+ "on lidc.id=laidlo.item_dev_id where 1=1");
		//追加根据分组条件
		if (StringUtils.hasText(itemId)) {
			sql.append(" and laidlo.item_dev_id = ? " );
		}
		//追加条件
		if (StringUtils.hasText(typeId)) {
			sql.append(" and laidlo.TYPE_ID = ? " );
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
				+ "from LIS_AI_ITEM_DEV_LO laidlo "
				+ "left join lis_item_dev_code lidc "
				+ "on lidc.id=laidlo.item_dev_id where 1=1");
		//追加根据分组条件
		if (StringUtils.hasText(itemId)) {
			countsql.append(" and laidlo.item_dev_id = ? " );
		}
		//追加根据分组条件
		if (StringUtils.hasText(typeId)) {
			countsql.append(" and laidlo.TYPE_ID = ? " );
		}
		Query queryCount = getSession().createSQLQuery(countsql.toString());
		queryCount.setString(0, itemId);
		queryCount.setString(1, typeId);
		queryResult.put(CommonConstants.QUERY_PAGE_TOTAL, queryCount.uniqueResult());
		return queryResult;
	}
	
	/**
	 * 用于查询当前选中的项目是否是第一次维护规则。通过typeMark标记，第一次维护typeMark为空
	 * @param start 前台传过来的页数
	 * @param limit	前台传过来的每页显示条数
	 * @param itemId 项目id
	 * @param typeId 类型id
	 * @return
	 */
	@Override
	public String findLOJudgeItem(String itemId,String typeId) {
		StringBuffer sql = new StringBuffer("select laidlo.id, laidlo.TYPE_MARK from LIS_AI_ITEM_DEV_LO laidlo  where 1=1");
		//追加项目id
		if (StringUtils.hasText(itemId)) {
			sql.append(" and laidlo.item_dev_id = ? " );
		}
		//追加条件
		if (StringUtils.hasText(typeId)) {
			sql.append(" and laidlo.TYPE_ID = ? " );
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
	 * 用于查询所有已添加到当前分类的分组项目
	 * @param start 前台传过来的页数
	 * @param limit	前台传过来的每页显示条数
	 * @param groupId 分组id
	 * @param typeId 类型id
	 * @return
	 */
	@Override
	public Map<String, Object> findLOAddedItem(int start, int limit,String groupId, String typeId) {
		Map<String, Object> queryResult = new HashMap<String, Object>();
		StringBuffer sql = new StringBuffer("select distinct(lidc.item_code),lidc.item_name,lidc.item_name_cn,lidc.id,lidi.dev_name,laidlot.type_name,laidlo.type_id,laidlo.TYPE_MARK "
				+ "from lis_item_dev_code lidc "
				+ "left join lis_inspec_dev_info lidi "
				+ "on lidi.id=lidc.dev_code "
				+ "left join LIS_AI_ITEM_DEV_LO laidlo "
				+ "on laidlo.item_dev_id=lidc.id "
				+ "left join LIS_AI_ITEM_DEV_LO_TYPE laidlot "
				+ "on laidlot.id=laidlo.type_id where 1=1 ");
		//追加根据分组条件
		if (StringUtils.hasText(groupId)) {
			sql.append(" and lidi.ID = ? " );
		}
		//追加条件
		if (StringUtils.hasText(typeId)) {
			sql.append(" and laidlo.TYPE_ID = ? " );
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
				+ "left join LIS_AI_ITEM_DEV_LO laidlo "
				+ "on laidlo.item_dev_id=lidc.id "
				+ "left join LIS_AI_ITEM_DEV_LO_TYPE laidlot "
				+ "on laidlot.id=laidlo.type_id where 1=1 ");
		//追加根据分组条件
		if (StringUtils.hasText(groupId)) {
			countsql.append(" and lidi.ID = ? " );
		}
		//追加根据分组条件
		if (StringUtils.hasText(typeId)) {
			countsql.append(" and laidlo.TYPE_ID = ? " );
		}
		Query queryCount = getSession().createSQLQuery(countsql.toString());
		queryCount.setString(0, groupId);
		queryCount.setString(1, typeId);
		queryResult.put(CommonConstants.QUERY_PAGE_TOTAL, queryCount.uniqueResult());
		return queryResult;
	}

	@Override
	public List<LisAiItemDevLO> findLOJudgeItemObj(String typeId, String itemId) {
		StringBuffer hql = new StringBuffer("from LisAiItemDevLO O where 1=1 ");
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
	public List<LisAiItemDevLO> findLOByItemDevId(String itemDevId) {
		StringBuffer hql =new StringBuffer("from LisAiItemDevLO o where 1=1 ");
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
