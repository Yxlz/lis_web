package com.cdxt.lisweb.service.user.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdxt.lisweb.dao.BaseDao;
import com.cdxt.lisweb.dao.user.LisHospitalDao;
import com.cdxt.lisweb.entity.user.LisHospital;
import com.cdxt.lisweb.service.BaseServiceImpl;
import com.cdxt.lisweb.service.user.LisHospitalService;

/**
 * @author : zhaozeyu 
 * @date 创建时间：2018年1月4日 下午1:40:50
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: //TODO
 */
@Service
public class LisHospitalServiceImpl  extends BaseServiceImpl<LisHospital>
implements LisHospitalService {

	@Autowired
	private LisHospitalDao lisHostpitalDao;
	
	@Override
	public BaseDao<LisHospital> getDao() {
		return lisHostpitalDao;
	}

	@Override
	public Map<String, Object> queryHosByPage(int start, int limit, String name) {
		return lisHostpitalDao.queryHosByPage(start, limit, name);
	}

}
