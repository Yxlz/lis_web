package com.cdxt.lisweb.dao.lisitem.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdxt.lisweb.dao.BaseDaoImpl;
import com.cdxt.lisweb.dao.lisitem.LisReqItemDao;
import com.cdxt.lisweb.entity.inspec.LisRequestionItem;

/**
 * @author : zhaozeyu
 * @date 创建时间：2018年1月9日 下午4:14:10
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: //TODO
 */
@Repository
public class LisReqItemDaoImpl extends BaseDaoImpl<LisRequestionItem> implements
		LisReqItemDao {

	@Override
	public Class<LisRequestionItem> getEntityType() {
		return LisRequestionItem.class;
	}

	@Override
	public List<LisRequestionItem> queryAllItem() {
		String hql = "select new LisRequestionItem(id,charge,container,requestionName,sampleName,requestionCode) from LisRequestionItem r";
		@SuppressWarnings("unchecked")
		List<LisRequestionItem> list = getSession().createQuery(hql).list();
		return list;
	}

}
