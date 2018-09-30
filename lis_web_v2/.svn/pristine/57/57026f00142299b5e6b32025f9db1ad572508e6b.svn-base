package com.cdxt.lisweb.dao.barcode.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdxt.lisweb.dao.BaseDaoImpl;
import com.cdxt.lisweb.dao.barcode.LisBarCodeRuleDao;
import com.cdxt.lisweb.entity.barcode.LisWebBarcodeRule;
import com.cdxt.lisweb.entity.barcode.LisWebBcruleContainer;
import com.cdxt.lisweb.entity.barcode.LisWebBcruleItem;
import com.cdxt.lisweb.entity.barcode.LisWebBcruleSingleitem;


/**
 * @author : zhaozeyu
 * @date 创建时间：2018年1月9日 下午4:14:10
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: //TODO
 */
@Repository
public class LisBarCodeRuleDaoImpl extends BaseDaoImpl<LisWebBarcodeRule>
		implements LisBarCodeRuleDao {

	@Override
	public Class<LisWebBarcodeRule> getEntityType() {
		return LisWebBarcodeRule.class;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LisWebBcruleContainer> queryBarCodeCon(String ruleId) {
		String hql = "from LisWebBcruleContainer b where 1=1 and  b.lisWebBarcodeRule.id = :ruleId";
		return getSession().createQuery(hql).setParameter("ruleId", ruleId)
				.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LisWebBcruleItem> queryBarCodeItem(String ruleId) {
		String hql = "from LisWebBcruleItem b where 1=1 and  b.lisWebBarcodeRule.id = :ruleId";
		return getSession().createQuery(hql).setParameter("ruleId", ruleId)
				.list();
	}
	
	  @SuppressWarnings("unchecked")
	  @Override
	  public List<LisWebBarcodeRule> queryAllRules() {
	    String hql =
	        "from LisWebBarcodeRule t order by t.priority desc";
	    return getSession().createQuery(hql).list();
	  }


	  @SuppressWarnings("unchecked")
	  @Override
	  public List<LisWebBcruleSingleitem> queryAllItemRules() {
	    String hql =
	        "from LisWebBcruleSingleitem t  where t.enable=1";
	    return getSession().createQuery(hql).list();
	  }

}
