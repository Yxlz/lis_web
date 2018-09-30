package com.cdxt.lisweb.service.barcode.impl;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.cdxt.lisweb.dao.BaseDao;
import com.cdxt.lisweb.dao.barcode.LisBarCodeRuleDao;
import com.cdxt.lisweb.dao.barcode.LisBcRuleContainerDao;
import com.cdxt.lisweb.dao.barcode.LisBcRuleItemDao;
import com.cdxt.lisweb.entity.barcode.LisWebBarcodeRule;
import com.cdxt.lisweb.entity.barcode.LisWebBcruleContainer;
import com.cdxt.lisweb.entity.barcode.LisWebBcruleItem;
import com.cdxt.lisweb.entity.barcode.LisWebBcruleSingleitem;
import com.cdxt.lisweb.entity.req.LisRequestionReceive;
import com.cdxt.lisweb.exception.BarCodeRuleContainerNotSetException;
import com.cdxt.lisweb.exception.BarCodeRuleNotFoundException;
import com.cdxt.lisweb.service.BaseServiceImpl;
import com.cdxt.lisweb.service.barcode.LisBarCodeRuleService;
import com.cdxt.lisweb.utils.BarCodeRuleMatcher;
import com.cdxt.lisweb.utils.UseridUtils;

/**
 * @author : Tangxiaohui
 * @date 创建时间：2018年1月9日 下午4:08:12
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: //TODO
 */
@Service
public class LisBarCodeRuleServiceImpl extends BaseServiceImpl<LisWebBarcodeRule> implements LisBarCodeRuleService {
	@Autowired
	private LisBarCodeRuleDao lisBarCodeRuleDao;
	@Autowired
	private LisBcRuleContainerDao lisBcRuleContainerDao;
	@Autowired
	private LisBcRuleItemDao lisBcRuleItemDao;

	@Override
	public BaseDao<LisWebBarcodeRule> getDao() {
		return lisBarCodeRuleDao;
	}

	@Override
	public List<LisWebBcruleContainer> queryBarCodeCon(String ruleId) {
		return lisBarCodeRuleDao.queryBarCodeCon(ruleId);
	}

	@Override
	public List<LisWebBcruleItem> queryBarCodeItem(String ruleId) {
		return lisBarCodeRuleDao.queryBarCodeItem(ruleId);
	}

	@Override
	@Transactional
	public void deleteAll(List<LisWebBarcodeRule> rules) {
		for (LisWebBarcodeRule lisWebBarcodeRule : rules) {
			String id = lisWebBarcodeRule.getId();
			lisBcRuleContainerDao.deleteByRuleId(id);
			lisBcRuleItemDao.deleteByRuleId(id);
			lisBarCodeRuleDao.delete(lisWebBarcodeRule);
		}
	}

	@Override
	@Transactional
	public void save(LisWebBarcodeRule rule) {
		if (StringUtils.hasText(rule.getId())) {
			lisBarCodeRuleDao.update(rule);
		} else {
			rule.setId(UseridUtils.getUserID());
			lisBarCodeRuleDao.save(rule);
		}
	}

	@Override
	public LisWebBarcodeRule getBcRuleByID(String id) {
		return lisBarCodeRuleDao.queryById(id);
	}

	@Override
	@Transactional
	public void SaveOrUpdateContainer(LisWebBcruleContainer con) {
		con.setEnable(new BigDecimal(1));
		if (!StringUtils.hasText(con.getId())) {
			con.setId(UseridUtils.getUserID());
			lisBcRuleContainerDao.save(con);
		} else {
			lisBcRuleContainerDao.update(con);
		}

	}

	@Override
	@Transactional
	public void deleteBcRuleContainer(LisWebBcruleContainer con) {
		lisBcRuleContainerDao.delete(con);
	}

	@Override
	@Transactional
	public void saveOrUpdateItem(LisWebBcruleItem item) {
		if (!StringUtils.hasText(item.getId())) {
			item.setId(UseridUtils.getUserID());
			lisBcRuleItemDao.save(item);
		} else {
			lisBcRuleItemDao.update(item);
		}
	}

	@Override
	@Transactional
	public void deleteBcRuleItem(LisWebBcruleItem item) {
		lisBcRuleItemDao.delete(item);
	}

	@Override
	@Transactional
	public List<String> createBarCode(LisRequestionReceive request, Map<String, List<String>> barCodeRefItem)
			throws BarCodeRuleNotFoundException, BarCodeRuleContainerNotSetException {
		
	    // 合并条码规则
	    Set<LisWebBarcodeRule> rules = new HashSet<LisWebBarcodeRule>();
	    rules.addAll(lisBarCodeRuleDao.queryAllRules());// 联合查询时有重复数据
	    // 单条码规则
	    List<LisWebBcruleSingleitem> itemRules = lisBarCodeRuleDao.queryAllItemRules();
	    BarCodeRuleMatcher matcher = BarCodeRuleMatcher.newInstance().setRules(rules, itemRules);
	    
	    String itemname =  request.getRequestItemName();
	    List<String> items = Arrays.asList(itemname.split(","));
	    
	    
	    //Set<Rule> matchs = matcher.matchRules();
	    //logger.debug("检验申请项目:" + request.getLisReqOrderNos() + "匹配到了规则:" + matchs);
		return null;
	}
}
