package com.cdxt.lisweb.controller.user;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cdxt.lisweb.entity.user.LisHospital;
import com.cdxt.lisweb.service.user.LisHospitalService;
import com.cdxt.lisweb.utils.UseridUtils;

/**
 * @author : zhaozeyu
 * @date 创建时间：2018年1月4日 下午1:35:31
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: //TODO
 */
@Controller
@RequestMapping("/hospital")
public class LisHospitalController {
	@Autowired
	private LisHospitalService hospitalService;

	@RequestMapping(value = "getHosOrgInfo.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public Map<String, Object> queryHosOrgInfoByPage(int start, int limit, String hosName) {
		if(StringUtils.hasText(hosName)){
			try {
				return hospitalService.queryHosByPage(start, limit, new String(hosName.getBytes("ISO8859-1"), "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		Map<String, Object> queryHosByPage = hospitalService.queryHosByPage(start, limit, hosName);
		System.out.println(queryHosByPage);
		return hospitalService.queryHosByPage(start, limit, hosName);
	}

	/**
	 * 保存医疗机构
	 * 
	 * @param hosOrgInfo
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "addHosOrgInfo.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public String addHosOrgInfo(@RequestBody LisHospital hosInfo) {
		if (hosInfo.getId()==null||hosInfo.getId().equals("")) {
			String id = UseridUtils.getUserID();
			hosInfo.setId(id);
		}
		hospitalService.saveOrUpdate(hosInfo);
		return "{success:true}";
	}
	
	/**
	 * 根据id获取医疗机构
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "getHosOrgInfoByID.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public LisHospital getHosOrgInfoByID(String id){
		LisHospital lisHospital = hospitalService.queryById(id);
		return lisHospital;
	}

	/**
	 * 删除医疗机构
	 * 
	 * @param hoiList
	 * @return
	 */
	@RequestMapping(value = "delHosOrgInfo.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public String delHosOrgInfo(@RequestBody List<LisHospital> hosList) {
		hospitalService.deleteAll(hosList);
		return "{success:true}";
	}
}
