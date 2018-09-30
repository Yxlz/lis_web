package com.cdxt.lisweb.controller.examine;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cdxt.lisweb.service.examine.LisItemDevCodeService;
/**
 * @author : liushijun
 * @date 创建时间：2018年6月21日 
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: 用于查询设备下拉框数据的方法。
 */
@Controller
@RequestMapping("/itemdev")
public class LisItemDevCodeController {
	@Autowired
	private LisItemDevCodeService lisItemDevCodeService;
	/**
	 * 获取的下拉数据
	 * @param aiQcList
	 * @return
	 */	
	@RequestMapping(value = "getEquipmentInfo.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public List<String>  getEquipmentInfo() {
		List<String>  allEquipment = lisItemDevCodeService.getAllEquipment();
		return allEquipment;
	}
	/**
	 * 获取的下拉数据
	 * @param aiQcList
	 * @return
	 */	
	@RequestMapping(value = "getEquipmentNameAndId.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public  List<String>  getAllEquipmentNameAndId() {
		 List<String>  allEquipment = lisItemDevCodeService.getAllEquipmentNameAndId();
		return allEquipment;
	}
	/**
	 * 获取的下拉数据
	 * @return
	 */	
	@RequestMapping(value = "getItemName.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public  List<String>  getItemName() {
		 List<String>  allItemName = lisItemDevCodeService.findItemName();
		return allItemName;
	}
}
