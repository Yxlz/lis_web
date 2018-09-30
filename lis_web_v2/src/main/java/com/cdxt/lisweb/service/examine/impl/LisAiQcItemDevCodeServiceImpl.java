package com.cdxt.lisweb.service.examine.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdxt.lisweb.dao.BaseDao;
import com.cdxt.lisweb.dao.examine.LisAiQcItemDevCodeDao;
import com.cdxt.lisweb.entity.examine.LisAiQcItemDevCode;
import com.cdxt.lisweb.service.BaseServiceImpl;
import com.cdxt.lisweb.service.examine.LisAiQcItemDevCodeService;

/**
 * @author : liushijun
 * @date 创建时间：2018年6月21日 
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: //TODO
 */
@Service
public class LisAiQcItemDevCodeServiceImpl  extends BaseServiceImpl<LisAiQcItemDevCode>
implements LisAiQcItemDevCodeService{
	@Autowired
	private LisAiQcItemDevCodeDao lisAiQcItemDevCodeDao;
	@Override
	public BaseDao<LisAiQcItemDevCode> getDao() {
		// TODO Auto-generated method stub
		return lisAiQcItemDevCodeDao;
	}
	@Override
	public String findAiQcByItemDevId(String id) {
		return lisAiQcItemDevCodeDao.findAiQcByItemDevId(id);
	}
	@Override
	public Map<String, Object> findAiQcByPage(int start, int limit, String name) {
		// TODO Auto-generated method stub
		return lisAiQcItemDevCodeDao.findAiQcByPage(start, limit, name);
	}

}
