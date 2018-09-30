package com.cdxt.lisweb.service.examine.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdxt.lisweb.dao.BaseDao;
import com.cdxt.lisweb.dao.examine.LisAiItemDevICDDao;
import com.cdxt.lisweb.entity.examine.LisAiItemDevICD;
import com.cdxt.lisweb.service.BaseServiceImpl;
import com.cdxt.lisweb.service.examine.LisAiItemDevICDService;

/**
 * @author : liushijun
 * @date 创建时间：2018年7月6日
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: //TODO
 */
@Service
public class LisAiItemDevICDServiceImpl extends BaseServiceImpl<LisAiItemDevICD>
implements LisAiItemDevICDService {
	
	@Autowired
	LisAiItemDevICDDao lisAiItemDevICDDao;
	
	@Override
	public BaseDao<LisAiItemDevICD> getDao() {
		// TODO Auto-generated method stub
		return lisAiItemDevICDDao;
	}

	@Override
	public Map<String, Object> findICDInfo(int start, int limit, String itemDevId) {
		// TODO Auto-generated method stub
		return lisAiItemDevICDDao.findICDInfo(start, limit, itemDevId);
	}

	@Override
	public Map<String, Object> findItemInfo(int start, int limit,String groupId) {
		// TODO Auto-generated method stub
		return lisAiItemDevICDDao.findItemInfo(start, limit,groupId);
	}

	@Override
	public List<LisAiItemDevICD> findKeyWords(String itemDevId) {
		// TODO Auto-generated method stub
		return lisAiItemDevICDDao.findKeyWords(itemDevId);
	}
}
