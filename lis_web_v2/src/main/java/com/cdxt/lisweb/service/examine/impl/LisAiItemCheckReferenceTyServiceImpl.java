package com.cdxt.lisweb.service.examine.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdxt.lisweb.dao.BaseDao;
import com.cdxt.lisweb.dao.examine.LisAiItemCheckReferenceTyDao;
import com.cdxt.lisweb.entity.examine.LisAiItemCheckReferenceTy;
import com.cdxt.lisweb.service.BaseServiceImpl;
import com.cdxt.lisweb.service.examine.LisAiItemCheckReferenceTyService;
/**
 * @author : liushijun
 * @date 创建时间：2018年7月3日 
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: //TODO
 */
@Service
public class LisAiItemCheckReferenceTyServiceImpl extends BaseServiceImpl<LisAiItemCheckReferenceTy>
implements LisAiItemCheckReferenceTyService{
	@Autowired
	LisAiItemCheckReferenceTyDao lisAiItemCheckReferenceTyDao;
	
	@Override
	public BaseDao<LisAiItemCheckReferenceTy> getDao() {
		// TODO Auto-generated method stub
		return lisAiItemCheckReferenceTyDao;
	}
	
	@Override
	public Map<String, Object> findAICRTByPage(int start, int limit,String groupId) {
		return lisAiItemCheckReferenceTyDao.findAICRTByPage(start, limit,groupId);
	}

	@Override
	public Map<String, Object> findItemNotAdd(int start, int limit, String groupId,String typeId) {
		return lisAiItemCheckReferenceTyDao.findItemNotAdd(start, limit, groupId, typeId);
	}

	@Override
	public List<String> findSampleNameInfo() {
		// TODO Auto-generated method stub
		return lisAiItemCheckReferenceTyDao.findSampleNameInfo();
	}

	@Override
	public List<String> findAiItemGroupType(String groupId, String typeName) {
		// TODO Auto-generated method stub
		return lisAiItemCheckReferenceTyDao.findAiItemGroupType(groupId, typeName);
	}

}
