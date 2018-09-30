package com.cdxt.lisweb.service.examine.impl;

import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdxt.lisweb.dao.BaseDao;
import com.cdxt.lisweb.dao.examine.LisItemDevCodeDao;
import com.cdxt.lisweb.entity.examine.LisItemDevCode;
import com.cdxt.lisweb.service.BaseServiceImpl;
import com.cdxt.lisweb.service.examine.LisItemDevCodeService;
/**
 * @author : liushijun
 * @date 创建时间：2018年6月21日 
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: //TODO
 */
@Service
public class LisItemDevCodeServiceImpl extends BaseServiceImpl<LisItemDevCode>
implements LisItemDevCodeService{
	@Autowired
	private LisItemDevCodeDao lisItemDevCodeDao;
	@Override
	public BaseDao<LisItemDevCode> getDao() {
		// TODO Auto-generated method stub
		return lisItemDevCodeDao;
	}
	@Override
	public List<String>  getAllEquipment() {
		// TODO Auto-generated method stub
		return lisItemDevCodeDao.getAllEquipment();
	}
	@Override
	public List<String> getAllEquipmentNameAndId() {
		// TODO Auto-generated method stub
		return lisItemDevCodeDao.getAllEquipmentNameAndId();
	}
	@Override
	public List<String> findItemName() {
		// TODO Auto-generated method stub
		return lisItemDevCodeDao.findItemName();
	}

}
