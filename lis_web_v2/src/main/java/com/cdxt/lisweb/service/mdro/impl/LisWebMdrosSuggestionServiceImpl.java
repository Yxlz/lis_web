package com.cdxt.lisweb.service.mdro.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.cdxt.lisweb.dao.BaseDao;
import com.cdxt.lisweb.dao.mdro.LisWebMdrosSuggestionDao;
import com.cdxt.lisweb.entity.mdro.LisWebMdrosSuggestion;
import com.cdxt.lisweb.service.BaseServiceImpl;
import com.cdxt.lisweb.service.mdro.LisWebMdrosSuggestionService;
import com.cdxt.lisweb.utils.UseridUtils;

/**
 * @author : Tangxiaohui
 * @date 创建时间：2018年9月11日 下午1:38:57
 * @version 1.0
 * @company :成都信通网易医疗科技发展有限公司
 * @description: //TODO
 */
@Service
public class LisWebMdrosSuggestionServiceImpl extends
		BaseServiceImpl<LisWebMdrosSuggestion> implements
		LisWebMdrosSuggestionService {

	@Autowired
	private LisWebMdrosSuggestionDao mdroDao;

	@Override
	public BaseDao<LisWebMdrosSuggestion> getDao() {

		return mdroDao;
	}

	@Override
	public LisWebMdrosSuggestion getLisWebMdrosSuggestionByMdroCode(
			String mdroCode) {
		return mdroDao.getLisWebMdrosSuggestionByMdroCode(mdroCode);
	}

	@Override
	@Transactional
	public void saveClob(LisWebMdrosSuggestion t) {	
		if (StringUtils.hasText(t.getId())) {
			mdroDao.updateClob(t);
		} else {
			t.setId(UseridUtils.getUserID());
			mdroDao.saveClob(t);
		}
	}

	@Override
	public void updateClob(LisWebMdrosSuggestion mdro) {
		mdroDao.updateClob(mdro);
	}

}
