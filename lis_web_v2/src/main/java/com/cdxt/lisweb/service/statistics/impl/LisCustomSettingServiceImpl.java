package com.cdxt.lisweb.service.statistics.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdxt.lisweb.dao.BaseDao;
import com.cdxt.lisweb.dao.statistics.LisCustomSettingDao;
import com.cdxt.lisweb.entity.statistics.LisCustomSetting;
import com.cdxt.lisweb.service.BaseServiceImpl;
import com.cdxt.lisweb.service.statistics.LisCustomSettingService;

/**
 * @author : Tangxiaohui 
 * @date 创建时间：2018年1月9日 下午4:08:12
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: //TODO
 */
@Service
public class LisCustomSettingServiceImpl extends BaseServiceImpl<LisCustomSetting> implements
		LisCustomSettingService {

	@Autowired
	private LisCustomSettingDao lisCustomSettingDao;
	
	@Override
	public String getUrlByUrlName(String url_name) throws Exception {
		return lisCustomSettingDao.getUrlByUrlName(url_name);
	}

	@Override
	public BaseDao<LisCustomSetting> getDao() {
		return lisCustomSettingDao;
	}

	}
