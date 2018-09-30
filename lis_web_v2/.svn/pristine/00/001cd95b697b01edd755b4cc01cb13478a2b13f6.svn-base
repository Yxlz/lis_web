package com.cdxt.lisweb.dao.examine.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.cdxt.lisweb.constants.CommonConstants;
import com.cdxt.lisweb.dao.BaseDaoImpl;
import com.cdxt.lisweb.dao.examine.LisAiQcItemDevCodeDao;
import com.cdxt.lisweb.entity.examine.LisAiQcItemDevCode;
import com.cdxt.lisweb.entity.examine.LisItemDevCode;
/**
 * @author : liushijun
 * @date 创建时间：2018年6月21日 
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: //TODO
 */
@Repository
public class LisAiQcItemDevCodeDaoImpl extends BaseDaoImpl<LisAiQcItemDevCode> implements
LisAiQcItemDevCodeDao{
	
	@Override
	public Class<LisAiQcItemDevCode> getEntityType() {
		// TODO Auto-generated method stub
		return LisAiQcItemDevCode.class;
	}
	/**
	 * 用于分页查询数据
	 * @param start 前台传过来的页数
	 * @param limit	前台传过来的每页显示条数
	 * @param name	前台传过来的设备名字
	 * @return
	 */
	@Override
	public Map<String, Object> findAiQcByPage(int start, int limit, String name) {
		Map<String, Object> queryResult = new HashMap<String, Object>();
		//查询指控页面展示的数据
		StringBuffer sql = new StringBuffer("select Lidc.id, Lidi.DEV_NAME,Lidc.ITEM_NAME ,Lidc.ITEM_NAME_CN ,"
				+ "Laqidc.Is_Qc,Laqidc.Qc_State,Laqidc.adopt from Lis_Item_Dev_Code Lidc "
				+ "left join lis_inspec_dev_info Lidi on  Lidi.Id=Lidc.DEV_CODE "
				+ "left join LIS_AI_QC_ITEM_DEV_CODE Laqidc on laqidc.item_dev_id=Lidc.Id  where 1=1 ");
		//追加根据设备分类条件
		if (!name.equals("null")&&!"".equals(name)) {
			sql.append(" and Lidi.DEV_NAME= '" + name + "'" );
		}
		Query query = getSession().createSQLQuery(sql.toString()).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		query.setFirstResult(start);
		query.setMaxResults(limit);
		List list = query.list();
		queryResult.put(CommonConstants.QUERY_PAGE_ROWS, list);
		//查询总条数
		StringBuffer countsql = new StringBuffer("select count(*) from Lis_Item_Dev_Code Lidc "
				+ "left join lis_inspec_dev_info Lidi on  Lidi.Id=Lidc.DEV_CODE "
				+ "left join LIS_AI_QC_ITEM_DEV_CODE Laqidc on laqidc.item_dev_id=Lidc.Id  where 1=1");
		//追加设备条件
		if (!name.equals("null")&&!"".equals(name)) {
			countsql.append("and Lidi.DEV_NAME= '" + name +"'" );
		}
		Query queryCount = getSession().createSQLQuery(countsql.toString());
		queryResult.put(CommonConstants.QUERY_PAGE_TOTAL, queryCount.uniqueResult());
		return queryResult;
	}
	
	/**
	 * 用于根据页面传过来的项目id查询 质控表的该项目id下这条数据的id，
	 * 传入项目id查询LisAiQcItemDevCode 项目id 对应的那条数据是否存在， 
	 * 如果存在说明该表这个项目id对应的项目质检是存在的,所以获取这个id。
	 * @param id
	 * @return
	 */
	@Override
	public String findAiQcByItemDevId(String id) {
		String lisAiQcItemDevCodeId=null;
		//用于查询质检表LIS_AI_QC_ITEM_DEV_CODE 页面传来的项目id是否有记录  。
		Query query = getSession().createSQLQuery("select ID from "
				+ "LIS_AI_QC_ITEM_DEV_CODE where ITEM_DEV_ID='" + id +"'");
		List<String> listLisAiQcItemDevCode = query.list();
		for (String string : listLisAiQcItemDevCode) {
			lisAiQcItemDevCodeId=string;
		}
		return lisAiQcItemDevCodeId;
	}
}
