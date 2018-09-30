package com.cdxt.lisweb.dao.lisitem.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdxt.lisweb.dao.BaseDaoImpl;
import com.cdxt.lisweb.dao.lisitem.LisInspecTypeDao;
import com.cdxt.lisweb.entity.inspec.LisInspecTypeName;

/**
 * @author : zhaozeyu
 * @date 创建时间：2018年1月9日 下午4:14:10
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: //TODO
 */
@Repository
public class LisInspecTypeDaoImpl extends BaseDaoImpl<LisInspecTypeName> implements
LisInspecTypeDao {

	@Override
	public Class<LisInspecTypeName> getEntityType() {
		return LisInspecTypeName.class;
	}

	@Override
	public List<String> querySampleType() {
		String sql = "select distinct(t.sample_name) from LIS_INSPEC_SAMPLE_TYPE t";
		@SuppressWarnings("unchecked")
		List<String> list = getSession().createSQLQuery(sql).list();
		return list;
	}

}
