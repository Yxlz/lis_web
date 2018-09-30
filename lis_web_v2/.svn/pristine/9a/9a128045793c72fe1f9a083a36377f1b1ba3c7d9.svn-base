package com.cdxt.lisweb.service.lisitem.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdxt.lisweb.dao.BaseDao;
import com.cdxt.lisweb.dao.lisitem.LisReqItemDao;
import com.cdxt.lisweb.entity.inspec.LisRequestionItem;
import com.cdxt.lisweb.service.BaseServiceImpl;
import com.cdxt.lisweb.service.lisitem.LisReqItemService;

/**
 * @author : zhaozeyu
 * @date 创建时间：2018年1月9日 下午4:08:12
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: //TODO
 */
@Service
public class LisReqItemServiceImpl extends BaseServiceImpl<LisRequestionItem>
		implements LisReqItemService {
	private static final Logger log = LoggerFactory.getLogger(LisReqItemServiceImpl.class);
	
	@Autowired
	private LisReqItemDao lisReqItemDao;

	@Override
	public BaseDao<LisRequestionItem> getDao() {
		
		return lisReqItemDao;
	}

	@Override
	@Transactional
	@Cacheable(value="lisRequestionItemCache")
	public List<LisRequestionItem> queryAll() {
		log.info("正在查询所有项目。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。");
		return lisReqItemDao.queryAllItem();
	}

}
