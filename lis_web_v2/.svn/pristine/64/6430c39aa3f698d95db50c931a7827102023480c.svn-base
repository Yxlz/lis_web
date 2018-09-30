package com.cdxt.lisweb.service.lisitem.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdxt.lisweb.dao.BaseDao;
import com.cdxt.lisweb.dao.lisitem.LisContainerDao;
import com.cdxt.lisweb.entity.inspec.LisInspecContainer;
import com.cdxt.lisweb.service.BaseServiceImpl;
import com.cdxt.lisweb.service.lisitem.LisContainerService;

/**
 * @author : zhaozeyu
 * @date 创建时间：2018年1月9日 下午4:08:12
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: //TODO
 */
@Service
public class LisContainerServiceImpl extends
		BaseServiceImpl<LisInspecContainer> implements LisContainerService {
	@Autowired
	private LisContainerDao lisContainerDao;

	@Override
	public BaseDao<LisInspecContainer> getDao() {
		
		return lisContainerDao;
	}

/*	@Override
	public List<LisInspecContainer> queryContainerByName(String name) {
		
		return lisContainerDao.queryContainerByName(name);
	}*/

}
