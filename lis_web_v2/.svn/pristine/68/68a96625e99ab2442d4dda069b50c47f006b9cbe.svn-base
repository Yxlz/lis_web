package com.cdxt.lisweb.service.lisitem.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdxt.lisweb.dao.BaseDao;
import com.cdxt.lisweb.dao.lisitem.LisInspecTypeDao;
import com.cdxt.lisweb.entity.inspec.LisInspecTypeName;
import com.cdxt.lisweb.service.BaseServiceImpl;
import com.cdxt.lisweb.service.lisitem.LisInspecTypeService;

/**
 * @author : zhaozeyu
 * @date 创建时间：2018年1月9日 下午4:08:12
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: //TODO
 */
@Service
public class LisInspecTypeServiceImpl extends BaseServiceImpl<LisInspecTypeName>
implements LisInspecTypeService {
	
	@Autowired
	private LisInspecTypeDao lisInspecTypeDao;
	@Override
	public BaseDao<LisInspecTypeName> getDao() {
		return lisInspecTypeDao;
	}
	@Override
	public List<String> querySampleType() {
		return lisInspecTypeDao.querySampleType();
	}

}
