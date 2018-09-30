package com.cdxt.lisweb.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.cdxt.lisweb.dao.BaseDao;
import com.cdxt.lisweb.dao.user.LisInspecUserDao;
import com.cdxt.lisweb.entity.user.LisInspecUser;
import com.cdxt.lisweb.service.BaseServiceImpl;
import com.cdxt.lisweb.service.user.LisInspecUserService;
import com.cdxt.lisweb.utils.UseridUtils;

/**
 * @author : Tangxiaohui 
 * @date 创建时间：2018年1月3日 上午9:45:23
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: //TODO
 */
@Service
public class LisInspecUserServiceImpl extends BaseServiceImpl<LisInspecUser> implements LisInspecUserService {

	@Autowired
	private LisInspecUserDao lisInspecUserDao;
	@Override
	public BaseDao<LisInspecUser> getDao() {
		return lisInspecUserDao;
	}
	@Override
	@Transactional
	public void save(LisInspecUser t) {
		if (StringUtils.hasText(t.getId())) {
			lisInspecUserDao.update(t);
		    } else {
		      t.setId(UseridUtils.getUserID());
		      lisInspecUserDao.save(t);
		    }
	}
	@Override
	public LisInspecUser getUserByAccount(String username) throws Exception {
		return lisInspecUserDao.getUserByAccount(username);
	}
	@Override
	public int updatePassword(String username, String oldPwd, String newPwd)
			throws Exception {
		if (lisInspecUserDao.getUserByAccount(username).getPassword()
				.equals(oldPwd)) {
			return lisInspecUserDao.updatePassword(username,newPwd);
		}
		return -1;
	}

}
