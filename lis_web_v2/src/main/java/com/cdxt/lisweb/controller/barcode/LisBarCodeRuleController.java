package com.cdxt.lisweb.controller.barcode;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cdxt.lisweb.constants.CommonConstants;
import com.cdxt.lisweb.controller.BaseController;
import com.cdxt.lisweb.entity.barcode.LisWebBarcodeRule;
import com.cdxt.lisweb.entity.barcode.LisWebBcruleContainer;
import com.cdxt.lisweb.entity.barcode.LisWebBcruleItem;
import com.cdxt.lisweb.service.barcode.LisBarCodeRuleService;

/**
 * @author : zhaozeyu
 * @date 创建时间：2018年1月23日 10:46:36
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: //TODO
 */
@Controller
@RequestMapping("/bcrule")
public class LisBarCodeRuleController extends BaseController {
	@Autowired
	private LisBarCodeRuleService ruleService;

	/**
	 * 查询合并条码规则
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "queryInspRule.do", produces = "application/json;charset=utf8")
	public List<LisWebBarcodeRule> queryInspRule() {
		return ruleService.queryAll("priority desc");
	}

	/**
	 * 查询规则容器
	 * 
	 * @param ruleId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getConbyRuleid.do", produces = "application/json;charset=utf8")
	public List<LisWebBcruleContainer> queryBarCodeCon(String ruleId) {
		List<LisWebBcruleContainer> cons = ruleService.queryBarCodeCon(ruleId);
		return cons;
	}

	/**
	 * 查询规则项目
	 * 
	 * @param ruleId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getItembyRuleid.do", produces = "application/json;charset=utf8")
	public List<LisWebBcruleItem> queryBarCodeItem(String ruleId) {
		List<LisWebBcruleItem> items = ruleService.queryBarCodeItem(ruleId);
		return items;
	}

	/**
	 * 保存合并条码规则
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "saveBcRule.do", produces = "application/json;charset=utf8")
	public String saveInspRule(@RequestBody LisWebBarcodeRule rule) {
		try{
		ruleService.save(rule);
		}catch(Exception e){
			return "{success:false}";
		}
		return "{success:true}";
	}

	/**
	 * 根据id查询条码规则
	 * 
	 * @param ruleId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getBcRuleByID.do", produces = "application/json;charset=utf8")
	public LisWebBarcodeRule getBcRuleByID(String id) {
		return ruleService.getBcRuleByID(id);
	}

	/**
	 * 删除条码规则
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "delBcRule.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public String delBcRule(@RequestBody List<LisWebBarcodeRule> rules) {
		
		ruleService.deleteAll(rules);
		return "{success:true}";
	}
	/**
	 * 保存或更新条码规则容器
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "saveBcRuleContainer.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public String saveBcRuleContainer(@RequestBody LisWebBcruleContainer con){
		try{
			ruleService.SaveOrUpdateContainer(con);
		}catch(Exception e){
			return this.createResJson(CommonConstants.INTEGER_ONE, e.getMessage());
		}
		return this.createResJson(CommonConstants.INTEGER_ZERO,"success");
	}
	
	/**
	 * 删除规则容器
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "delBcRuleCon.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public String deleteBcRuleContainer(@RequestBody LisWebBcruleContainer con){
		try{
			ruleService.deleteBcRuleContainer(con);
		}catch(Exception e){
			return this.createResJson(CommonConstants.INTEGER_ONE, e.getMessage());
		}
		return this.createResJson(CommonConstants.INTEGER_ZERO,"success");
	}
	
	/**
	 * 保存或更新条码规则 项目
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "saveBcRuleItem.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public String saveBcRuleItem(@RequestBody LisWebBcruleItem item){
		try{
			ruleService.saveOrUpdateItem(item);
		}catch(Exception e){
			return this.createResJson(CommonConstants.INTEGER_ONE, e.getMessage());
		}
		return this.createResJson(CommonConstants.INTEGER_ZERO,"success");
	}
	
	/**
	 * 删除规则项目
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "delBcRuleItem.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public String deleteBcRuleItem(@RequestBody LisWebBcruleItem item){
		ruleService.deleteBcRuleItem(item);
		return this.createResJson(CommonConstants.INTEGER_ZERO,"success");
	}
}
