package com.cdxt.lisweb.service.examine.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdxt.lisweb.dao.BaseDao;
import com.cdxt.lisweb.dao.examine.LisAiItemDevLODao;
import com.cdxt.lisweb.entity.examine.LisAiItemDevLO;
import com.cdxt.lisweb.service.BaseServiceImpl;
import com.cdxt.lisweb.service.examine.LisAiItemDevLOService;

/**
 * @author : liushijun
 * @date 创建时间：2018年7月6日
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: //TODO
 */
@Service
public class LisAiItemDevLOServiceImpl extends BaseServiceImpl<LisAiItemDevLO>
implements LisAiItemDevLOService {
	
	@Autowired
	LisAiItemDevLODao lisAiItemDevLODao;
	
	@Override
	public BaseDao<LisAiItemDevLO> getDao() {
		// TODO Auto-generated method stub
		return lisAiItemDevLODao;
	}

	@Override
	public Map<String, Object> findLOJudgeAdded(int start, int limit, String itemId, String typeId) {
		// TODO Auto-generated method stub
		return lisAiItemDevLODao.findLOJudgeAdded(start, limit, itemId, typeId);
	}

	@Override
	public String findLOJudgeItem(String itemId, String typeId) {
		// TODO Auto-generated method stub
		return lisAiItemDevLODao.findLOJudgeItem(itemId, typeId);
	}

	@Override
	public Map<String, Object> findLOAddedItem(int start, int limit, String groupId, String typeId) {
		// TODO Auto-generated method stub
		return lisAiItemDevLODao.findLOAddedItem(start, limit, groupId, typeId);
	}

	@Override
	public List<LisAiItemDevLO> findLOJudgeItemObj(String typeId, String itemId) {
		// TODO Auto-generated method stub
		return lisAiItemDevLODao.findLOJudgeItemObj(typeId, itemId);
	}

	@Override
	public List<LisAiItemDevLO> findLOByItemDevId(String itemDevId) {
		// TODO Auto-generated method stub
		return lisAiItemDevLODao.findLOByItemDevId(itemDevId);
	}

}
