package com.cdxt.lisweb.service.examine.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdxt.lisweb.dao.BaseDao;
import com.cdxt.lisweb.dao.examine.LisAiItemDevLOTypeDao;
import com.cdxt.lisweb.entity.examine.LisAiItemDevLOType;
import com.cdxt.lisweb.service.BaseServiceImpl;
import com.cdxt.lisweb.service.examine.LisAiItemDevLOTypeService;

/**
 * @author : liushijun
 * @date 创建时间：2018年7月6日
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: //TODO
 */
@Service
public class LisAiItemDevLOTypeServiceImpl extends BaseServiceImpl<LisAiItemDevLOType>
implements LisAiItemDevLOTypeService{

	@Autowired
	LisAiItemDevLOTypeDao  lisAiItemDevLOTypeDao;

	@Override
	public Map<String, Object> findLOTypeByPage(int start, int limit, String groupId) {
		// TODO Auto-generated method stub
		return lisAiItemDevLOTypeDao.findLOTypeByPage(start, limit, groupId);
	}

	@Override
	public Map<String, Object> findLOTypeItemNotAdd(int start, int limit, String groupId, String typeId) {
		// TODO Auto-generated method stub
		return lisAiItemDevLOTypeDao.findLOTypeItemNotAdd(start, limit, groupId, typeId);
	}

	@Override
	public List<String> findLOTypeSampleNameInfo() {
		// TODO Auto-generated method stub
		return lisAiItemDevLOTypeDao.findLOTypeSampleNameInfo();
	}

	@Override
	public BaseDao<LisAiItemDevLOType> getDao() {
		// TODO Auto-generated method stub
		return lisAiItemDevLOTypeDao;
	}

	@Override
	public List<String> findLOTGroupType(String groupId, String typeName) {
		// TODO Auto-generated method stub
		return lisAiItemDevLOTypeDao.findLOTGroupType(groupId, typeName);
	}
}
