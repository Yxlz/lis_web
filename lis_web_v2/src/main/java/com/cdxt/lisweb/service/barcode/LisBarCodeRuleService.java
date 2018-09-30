package com.cdxt.lisweb.service.barcode;

import java.util.List;
import java.util.Map;

import com.cdxt.lisweb.entity.barcode.LisWebBarcodeRule;
import com.cdxt.lisweb.entity.barcode.LisWebBcruleContainer;
import com.cdxt.lisweb.entity.barcode.LisWebBcruleItem;
import com.cdxt.lisweb.entity.req.LisRequestionReceive;
import com.cdxt.lisweb.exception.BarCodeRuleContainerNotSetException;
import com.cdxt.lisweb.exception.BarCodeRuleNotFoundException;
import com.cdxt.lisweb.service.BaseService;

/**
 * @author : zhaozeyu
 * @date 创建时间：2018年1月9日 下午3:58:21
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: //TODO
 */
public interface LisBarCodeRuleService extends BaseService<LisWebBarcodeRule> {

	/**
	 * 根据规则id查询规则容器
	 * 
	 * @param ruleId
	 * @return
	 */
	List<LisWebBcruleContainer> queryBarCodeCon(String ruleId);

	/**
	 * 根据规则id查询规则项目
	 * 
	 * @param ruleId
	 * @return
	 */
	List<LisWebBcruleItem> queryBarCodeItem(String ruleId);

	/**
	 * 根据规则id查询规则信息
	 * 
	 * @param id
	 * @return
	 */
	LisWebBarcodeRule getBcRuleByID(String id);

	/**
	 * 修改或新增容器
	 */
	void SaveOrUpdateContainer(LisWebBcruleContainer con);

	/**
	 * 删除规则容器
	 * 
	 * @param con
	 */
	void deleteBcRuleContainer(LisWebBcruleContainer con);

	/**
	 * 修改或新增项目
	 */
	void saveOrUpdateItem(LisWebBcruleItem item);

	/**
	 * 删除项目
	 */
	void deleteBcRuleItem(LisWebBcruleItem item);

	/**
	 * 根据条码合并规则生成条码
	 * 
	 * @param request
	 * @param barCodeRefItem
	 * @return
	 */
	public List<String> createBarCode(LisRequestionReceive request, Map<String, List<String>> barCodeRefItem)
			throws BarCodeRuleNotFoundException, BarCodeRuleContainerNotSetException;
}
