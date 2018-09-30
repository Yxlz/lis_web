package com.cdxt.lisweb.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdxt.lisweb.dao.BaseDao;
import com.cdxt.lisweb.dao.user.LisInspecDepartmentDao;
import com.cdxt.lisweb.entity.user.LisInspecDepartment;
import com.cdxt.lisweb.service.BaseServiceImpl;
import com.cdxt.lisweb.service.user.LisInspecDepartmentService;

/**
 * @author : Tangxiaohui 
 * @date 创建时间：2018年1月4日 下午1:40:50
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: //TODO
 */
@Service
public class LisInspecDepartmentServiceImpl extends BaseServiceImpl<LisInspecDepartment>
		implements LisInspecDepartmentService {

	@Autowired
	private LisInspecDepartmentDao deptDao;
	
	@Override
	public BaseDao<LisInspecDepartment> getDao() {
		return deptDao;
	}


}
