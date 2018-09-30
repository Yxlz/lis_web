package com.cdxt.lisweb.dao.user.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.cdxt.lisweb.dao.BaseDaoImpl;
import com.cdxt.lisweb.dao.user.LisInspecUserDao;
import com.cdxt.lisweb.entity.user.LisInspecUser;

/**
 * @author : Tangxiaohui 
 * @date 创建时间：2018年1月3日 上午9:35:17
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: //TODO
 */
@Repository
public class LisInspecUserDaoImpl extends BaseDaoImpl<LisInspecUser> implements
		LisInspecUserDao {

	@Override
	public Class<LisInspecUser> getEntityType() {
		return LisInspecUser.class;
	}

	@Override
	public LisInspecUser getUserByAccount(String username) {
		Query query = getSession().createQuery(
				"from LisInspecUser where username=:username").setParameter("username",username);
		return (LisInspecUser) query.uniqueResult();
	}

	@Override
	public int updatePassword(String username, String newPwd) throws Exception {
		return getSession()
				.createQuery(
						"update LisInspecUser set password=:password where username=:username")
				.setParameter("password", newPwd)
				.setParameter("username", username).executeUpdate();
	}

	
}
