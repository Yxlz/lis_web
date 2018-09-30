package com.cdxt.lisweb.dao.lisitem.impl;

import org.springframework.stereotype.Repository;

import com.cdxt.lisweb.dao.BaseDaoImpl;
import com.cdxt.lisweb.dao.lisitem.LisContainerDao;
import com.cdxt.lisweb.entity.inspec.LisInspecContainer;

/**
 * @author : zhaozeyu
 * @date 创建时间：2018年1月9日 下午4:14:10
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: //TODO
 */
@Repository
public class LisContainerDaoImpl extends BaseDaoImpl<LisInspecContainer>
		implements LisContainerDao {

	@Override
	public Class<LisInspecContainer> getEntityType() {
		return LisInspecContainer.class;
	}

/*	@SuppressWarnings("unchecked")
	@Override
	public List<LisInspecContainer> queryContainerByName(String name) {
		StringBuffer hql = new StringBuffer("from LisInspecContainer r where 1=1 ");
		if (StringUtils.hasText(name)) {
			hql.append(" and r.name like'%"+name+"%' ");
		}
		return getSession().createQuery(hql.toString()).list();
	}*/

}
