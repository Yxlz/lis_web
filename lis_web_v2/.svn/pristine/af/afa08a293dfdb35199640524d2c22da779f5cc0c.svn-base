package com.cdxt.lisweb.dao.barcode;

import java.util.List;

import com.cdxt.lisweb.dao.BaseDao;
import com.cdxt.lisweb.entity.barcode.LisWebBarcodeRule;
import com.cdxt.lisweb.entity.barcode.LisWebBcruleContainer;
import com.cdxt.lisweb.entity.barcode.LisWebBcruleItem;
import com.cdxt.lisweb.entity.barcode.LisWebBcruleSingleitem;

/**
 * @author : zhaozeyu
 * @date 创建时间：2018年1月9日 下午3:58:21
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: //TODO
 */
public interface LisBarCodeRuleDao extends BaseDao<LisWebBarcodeRule> {
	/**
	 * 根据规则ID查询规则容器
	 * @param ruleId
	 * @return
	 */
	List<LisWebBcruleContainer> queryBarCodeCon(String ruleId);

	/**
	 * 根据规则ID查询规则项目
	 * @param ruleId
	 * @return
	 */
	List<LisWebBcruleItem> queryBarCodeItem(String ruleId);
	
	/**
	 * 查询所有条码合并规则
	 * @return
	 */
	public List<LisWebBarcodeRule> queryAllRules();
	
	/**
	 * 查询全部单项目条码规则
	 * @return
	 */
	public List<LisWebBcruleSingleitem> queryAllItemRules();

}
