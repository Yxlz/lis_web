package com.cdxt.lisweb.service.examine.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdxt.lisweb.dao.BaseDao;
import com.cdxt.lisweb.dao.examine.LisAiItemDevHistDao;
import com.cdxt.lisweb.entity.examine.LisAiItemDevHist;
import com.cdxt.lisweb.service.BaseServiceImpl;
import com.cdxt.lisweb.service.examine.LisAiItemDevHistService;

/**
 * @author : liushijun
 * @date 创建时间：2018年7月6日
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: //TODO
 */
@Service
public class LisAiItemDevHistServiceImpl extends BaseServiceImpl<LisAiItemDevHist>
implements LisAiItemDevHistService {
	
	@Autowired
	LisAiItemDevHistDao lisAiItemDevHistDao;
	
	@Override
	public BaseDao<LisAiItemDevHist> getDao() {
		// TODO Auto-generated method stub
		return lisAiItemDevHistDao;
	}

	@Override
	public Map<String, Object> findHistJudgeAdded(int start, int limit, String itemId, String typeId) {
		// TODO Auto-generated method stub
		return lisAiItemDevHistDao.findHistJudgeAdded(start, limit, itemId, typeId);
	}

	@Override
	public String findHistJudgeItem(String itemId, String typeId) {
		// TODO Auto-generated method stub
		return lisAiItemDevHistDao.findHistJudgeItem(itemId, typeId);
	}

	@Override
	public Map<String, Object> findHistAddedItem(int start, int limit, String groupId, String typeId) {
		// TODO Auto-generated method stub
		return lisAiItemDevHistDao.findHistAddedItem(start, limit, groupId, typeId);
	}

	@Override
	public List<LisAiItemDevHist> findHistJudgeItemObj(String typeId, String itemId) {
		// TODO Auto-generated method stub
		return lisAiItemDevHistDao.findHistJudgeItemObj(typeId, itemId);
	}

	@Override
	public List<LisAiItemDevHist> findHistByItemDevId(String itemDevId) {
		// TODO Auto-generated method stub
		return lisAiItemDevHistDao.findHistByItemDevId(itemDevId);
	}

}
