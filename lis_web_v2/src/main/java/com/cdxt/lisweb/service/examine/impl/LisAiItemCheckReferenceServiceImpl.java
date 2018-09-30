package com.cdxt.lisweb.service.examine.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdxt.lisweb.dao.BaseDao;
import com.cdxt.lisweb.dao.examine.LisAiItemCheckReferenceDao;
import com.cdxt.lisweb.entity.examine.LisAiItemCheckReference;
import com.cdxt.lisweb.service.BaseServiceImpl;
import com.cdxt.lisweb.service.examine.LisAiItemCheckReferenceService;
/**
 * @author : liushijun
 * @date 创建时间：2018年7月3日 
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: //TODO
 */
@Service
public class LisAiItemCheckReferenceServiceImpl extends BaseServiceImpl<LisAiItemCheckReference>
		implements LisAiItemCheckReferenceService{
	@Autowired
	LisAiItemCheckReferenceDao lisAiItemCheckReferenceDao;
	
	@Override
	public BaseDao<LisAiItemCheckReference> getDao() {
		// TODO Auto-generated method stub
		return lisAiItemCheckReferenceDao;
	}

	@Override
	public Map<String, Object> findJudgeAdded(int start, int limit, String itemId,String typeId) {
		// TODO Auto-generated method stub
		return lisAiItemCheckReferenceDao.findJudgeAdded(start, limit, itemId,typeId);
	}

	@Override
	public String findJudgeItem(String itemId,String typeId) {
		// TODO Auto-generated method stub
		return lisAiItemCheckReferenceDao.findJudgeItem(itemId,typeId);
	}

	@Override
	public Map<String, Object> findAddedItem(int start, int limit, String groupId, String typeId) {
		// TODO Auto-generated method stub
		return lisAiItemCheckReferenceDao.findAddedItem(start, limit, groupId, typeId);
	}

	@Override
	public List<LisAiItemCheckReference> findScopeJudgeItemObj(String typeId, String itemId) {
		// TODO Auto-generated method stub
		return lisAiItemCheckReferenceDao.findScopeJudgeItemObj(typeId, itemId);
	}

	@Override
	public List<LisAiItemCheckReference> findRefByItemDevId(String itemDevId) {
		// TODO Auto-generated method stub
		return lisAiItemCheckReferenceDao.findRefByItemDevId(itemDevId);
	}

	@Override
	public String findItemIdByItemCode(String itemCode) {
		// TODO Auto-generated method stub
		return lisAiItemCheckReferenceDao.findItemIdByItemCode(itemCode);
	}

}
