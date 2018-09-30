package com.cdxt.lisweb.service.examine.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdxt.lisweb.dao.BaseDao;
import com.cdxt.lisweb.dao.examine.LisAiItemDevHistTypeDao;
import com.cdxt.lisweb.entity.examine.LisAiItemDevHistType;
import com.cdxt.lisweb.service.BaseServiceImpl;
import com.cdxt.lisweb.service.examine.LisAiItemDevHistTypeService;

/**
 * @author : liushijun
 * @date 创建时间：2018年7月6日
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: //TODO
 */
@Service
public class LisAiItemDevHistTypeServiceImpl extends BaseServiceImpl<LisAiItemDevHistType>
implements LisAiItemDevHistTypeService{

	@Autowired
	LisAiItemDevHistTypeDao  lisAiItemDevHistTypeDao;

	@Override
	public Map<String, Object> findHistByPage(int start, int limit, String groupId) {
		// TODO Auto-generated method stub
		return lisAiItemDevHistTypeDao.findHistByPage(start, limit, groupId);
	}

	@Override
	public Map<String, Object> findHistItemNotAdd(int start, int limit, String groupId, String typeId) {
		// TODO Auto-generated method stub
		return lisAiItemDevHistTypeDao.findHistItemNotAdd(start, limit, groupId, typeId);
	}

	@Override
	public List<String> findHistSampleNameInfo() {
		// TODO Auto-generated method stub
		return lisAiItemDevHistTypeDao.findHistSampleNameInfo();
	}

	@Override
	public BaseDao<LisAiItemDevHistType> getDao() {
		// TODO Auto-generated method stub
		return lisAiItemDevHistTypeDao;
	}

	@Override
	public List<String> findHistGroupType(String groupId, String typeName) {
		// TODO Auto-generated method stub
		return lisAiItemDevHistTypeDao.findHistGroupType(groupId, typeName);
	}
}
