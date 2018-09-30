package com.cdxt.lisweb.dao.examine.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.util.StringUtils;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.cdxt.lisweb.constants.CommonConstants;
import com.cdxt.lisweb.dao.BaseDaoImpl;
import com.cdxt.lisweb.dao.examine.LisAiItemDevHistTypeDao;
import com.cdxt.lisweb.entity.examine.LisAiItemCheckReference;
import com.cdxt.lisweb.entity.examine.LisAiItemDevHistType;

/**
 * @author : liushijun
 * @date 创建时间：2018年7月3日 
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: //TODO
 */
@Repository
public class LisAiItemDevHistTypeDaoImpl  extends BaseDaoImpl<LisAiItemDevHistType> implements
LisAiItemDevHistTypeDao{
	
	@Override
	public Class<LisAiItemDevHistType> getEntityType() {
		// TODO Auto-generated method stub
		return LisAiItemDevHistType.class;
	}

	/**
	 * 用于分页查询数据
	 * @param start 前台传过来的页数
	 * @param limit	前台传过来的每页显示条数
	 * @param groupId 前台传过来的分组id
	 * @return
	 */
	@Override
	public Map<String, Object> findHistByPage(int start, int limit,String groupId) {
		Map<String, Object> queryResult = new HashMap<String, Object>();
		//查询智能审核范围分类页面展示的数据
		StringBuffer sql = new StringBuffer("select laidht.*,lidi.dev_name from Lis_Ai_Item_Dev_Hist_Type laidht left join Lis_Inspec_Dev_Info lidi on  laidht.GROUP_ID=lidi.id  where 1=1");
		//追加根据分组条件
		if (!groupId.equals("null")&&!"".equals(groupId)) {
			sql.append(" and laidht.GROUP_ID = ? " );
		}
		//查询未删除的类型
		sql.append(" and laidht.IS_DELETE = '0' " );
		
		sql.append(" order by laidht.ID desc ");
		Query query = getSession().createSQLQuery(sql.toString()).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		if(!groupId.equals("null")&&!"".equals(groupId)){
			query.setString(0, groupId);
		}
		query.setFirstResult(start);
		query.setMaxResults(limit);
		List list = query.list();
		queryResult.put(CommonConstants.QUERY_PAGE_ROWS, list);
		//查询总条数
		StringBuffer countsql = new StringBuffer("select count(*) from Lis_Ai_Item_Dev_Hist_Type laidht left join Lis_Inspec_Dev_Info lidi on  laidht.GROUP_ID=lidi.id   where 1=1");
		//追加根据分组条件
		if (!groupId.equals("null")&&!"".equals(groupId)) {
			countsql.append(" and laidht.GROUP_ID=  ? " );
		}
		//查询未删除的类型
		countsql.append(" and laidht.IS_DELETE = '0' " );
		Query queryCount = getSession().createSQLQuery(countsql.toString());
		if(!groupId.equals("null")&&!"".equals(groupId)){
			queryCount.setString(0, groupId);
		}
		queryResult.put(CommonConstants.QUERY_PAGE_TOTAL, queryCount.uniqueResult());
		return queryResult;
	}
	
	/**
	 * 首先查询当前分组下已添加当前类型的项目唯一编码，之后通过查询结果拼接 not in 中的字符串，之后查询未添加到当前类型的项目
	 * @param start 前台传过来的页数
	 * @param limit	前台传过来的每页显示条数
	 * @param groupId 前台传过来的分组id
	 * @param typeId 类型id
	 * @return
	 */
	@Override
	public Map<String, Object> findHistItemNotAdd(int start, int limit,String groupId, String typeId) {
		Map<String, Object> queryResult = new HashMap<String, Object>();
		
		//查询该分组下已添加的项目的id用作拼接的sql条件
		StringBuffer sqlAdded = new StringBuffer("select distinct(lidc.item_code)"
				+ " from lis_item_dev_code lidc  "
				+ "left join lis_inspec_dev_info lidi  "
				+ "on lidi.id=lidc.dev_code "
				+ "left join lis_ai_item_dev_hist laidh "
				+ "on laidh.item_dev_id=lidc.id where 1=1 ");
		//追加根据分组条件
		if (StringUtils.hasText(groupId)) {
			sqlAdded.append(" and lidi.ID = ? " );
		}
		//追加条件
		if (StringUtils.hasText(typeId)) {
			sqlAdded.append(" and laidh.TYPE_ID = ? " );
		}
		Query queryAdded = getSession().createSQLQuery(sqlAdded.toString()).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		if (StringUtils.hasText(groupId)) {
			queryAdded.setString(0, groupId);
		}
		if (StringUtils.hasText(typeId)) {
			queryAdded.setString(1, typeId);
		}
		String queryString ="";
		String string="";
		int count=0;
		List<Map<String,String>> listAdded = queryAdded.list();
		if(listAdded.size()>0){
			for (Map<String, String> map : listAdded) {
				count++;
				string = map.get("ITEM_CODE");
				if(count==listAdded.size()){
					queryString=queryString+"'"+string+"'";
				}else{
				queryString=queryString+"'"+string+"',";
				}
			}
		}
		
		//查询未添加分组的项目
		StringBuffer sqlBefAdd=new StringBuffer("select distinct(lidc.item_code),lidc.item_name,lidc.item_name_cn,lidc.id,lidi.dev_name,lidi.id devId "
				+ "from lis_item_dev_code lidc "
				+ "left join lis_inspec_dev_info lidi "
				+ "on lidi.id=lidc.dev_code  where 1=1 ");
		//追加根据分组条件
		if (StringUtils.hasText(groupId)) {
			sqlBefAdd.append(" and lidi.ID = ? " );
		}
		if(StringUtils.hasText(queryString)){
			sqlBefAdd.append("and lidc.item_code not in ("+queryString+")");			
		}
		Query queryBefAdd = getSession().createSQLQuery(sqlBefAdd.toString()).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		if (StringUtils.hasText(groupId)) {
			queryBefAdd.setString(0, groupId);
		}
		queryBefAdd.setFirstResult(start);
		queryBefAdd.setMaxResults(limit);
		List listBefAdd = queryBefAdd.list();
		

		queryResult.put(CommonConstants.QUERY_PAGE_ROWS, listBefAdd);
	    //查询总条数

		StringBuffer countSqlBefAdd=new StringBuffer("select count(distinct(lidc.item_code)) "
				+ "from lis_item_dev_code lidc "
				+ "left join lis_inspec_dev_info lidi "
				+ "on lidi.id=lidc.dev_code  where 1=1 ");
		//追加根据分组条件
		if (StringUtils.hasText(groupId)) {
			countSqlBefAdd.append(" and lidi.ID = ? " );
		}
		if (StringUtils.hasText(queryString)) {
		countSqlBefAdd.append("and lidc.item_code not in ("+queryString+")");
		}
		Query queryCount = getSession().createSQLQuery(countSqlBefAdd.toString());
		if (StringUtils.hasText(groupId)) {
			queryCount.setString(0, groupId);
		}
		queryResult.put(CommonConstants.QUERY_PAGE_TOTAL, queryCount.uniqueResult());
		return queryResult;
	}
	
	//用于查询标本名称下拉
	@Override
	public List<String> findHistSampleNameInfo() {
		List<String> sampleList =new ArrayList<String>();
		StringBuffer sql = new StringBuffer("select distinct(SAMPLE_NAME) from LIS_INSPEC_SAMPLE_TYPE");
		SQLQuery sqlQuery = getSession().createSQLQuery(sql.toString());
		List list = sqlQuery.list();
		return list;
	}
	
	/**
	 * 通过分组id 和历史数据类型名称查询 该条数据是否存在
	 * @return
	 */
	public List<String> findHistGroupType(String groupId,String typeName){
		List<String> list =new ArrayList<String>();
		StringBuffer sql = new StringBuffer("select laidht.id from lis_ai_item_dev_hist_type laidht where 1=1");
		//追加根据分组条件
		if (StringUtils.hasText(groupId)) {
			sql.append(" and laidht.GROUP_ID = ? " );
		}
		//追加条件
		if (StringUtils.hasText(typeName)) {
			sql.append(" and laidht.TYPE_NAME = ? " );
		}
		
		sql.append(" and laidht.IS_DELETE = '0' ");
		
		SQLQuery sqlQuery = getSession().createSQLQuery(sql.toString());
		if (StringUtils.hasText(groupId)) {
			sqlQuery.setString(0, groupId);
		}
		if (StringUtils.hasText(typeName)) {
			sqlQuery.setString(1, typeName);
		}
		list = sqlQuery.list();
		return list;
		
	}
}
