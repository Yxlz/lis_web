package com.cdxt.lisweb.controller.examine;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cdxt.lisweb.entity.examine.LisAiQcItemDevCode;
import com.cdxt.lisweb.service.examine.LisAiQcItemDevCodeService;
import com.cdxt.lisweb.utils.IDCreateUtils;
/**
 * @author : liushijun
 * @date 创建时间：2018年6月21日 
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: //用于质控页面的展示 操作的一些功能方法
 */
@Controller
@RequestMapping("/aiqc")
public class LisAiQcItemDevCodeController {
	@Autowired
	private LisAiQcItemDevCodeService lisAiQcItemDevCodeService;
	/**
	 * 用于分页查询数据
	 * @param start 前台传来的页码
	 * @param limit	前台传来的每页展示数目
	 * @param aiQcName 前台传来下拉设备名字
	 * @return
	 */
	@RequestMapping(value = "getAiQcInfo.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public Map<String, Object> findAiQcInfoByPage(int start, int limit, String aiQcName) {
		if(!aiQcName.equals("null")&&!"".equals(aiQcName)){
			try {
				return lisAiQcItemDevCodeService.
						findAiQcByPage(start, limit, new String(aiQcName.getBytes("ISO8859-1"), "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		Map<String, Object> queryAiQcByPage = 
				lisAiQcItemDevCodeService.findAiQcByPage(start, limit, aiQcName);
		return queryAiQcByPage;
	}

	/**
	 * 保存质控信息
	 * @param id 当前选中的表格数据的项目id
	 * @param isQc	是否判断质控
	 * @param qcState	质控状态
	 * @param adopt 	是否通过审核
	 * @return
	 */
	@RequestMapping(value = "saveAiQcInfo.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public Map<String, String> saveCell(String id,String isQc,String qcState, String adopt) {
		Map<String, String> resultMap=new HashMap<String, String>();
		resultMap.put("success","true");
		//用于存储质检表主键
		String lisAiQcItemDevCodeId=null;
		/*通过表格中的字段id（当前选中的表格数据的项目id）查询数据库表LisAiQcItemDevCode的id，
		 * 因为只要执行了保存操作，至少都会有id和项目id*/
		lisAiQcItemDevCodeId = lisAiQcItemDevCodeService.findAiQcByItemDevId(id);
		LisAiQcItemDevCode  queryAiQcByItemDevId=new LisAiQcItemDevCode();
		//判断查询出来是否存在id 若存在根据前台传来的参数设置其他参数，执行更新操作。否则插入全部参数，执行保存操作。
		if(StringUtils.hasText(lisAiQcItemDevCodeId)){
			queryAiQcByItemDevId=lisAiQcItemDevCodeService.queryById(lisAiQcItemDevCodeId);
			queryAiQcByItemDevId.setIsQc(isQc);
			queryAiQcByItemDevId.setQcState(qcState);
			queryAiQcByItemDevId.setAdopt(adopt);
			lisAiQcItemDevCodeService.update(queryAiQcByItemDevId);
			return resultMap;
		}else{
			queryAiQcByItemDevId.setId(IDCreateUtils.getQccID());
			queryAiQcByItemDevId.setItemDevId(id);
			queryAiQcByItemDevId.setIsQc(isQc);
			queryAiQcByItemDevId.setQcState(qcState);
			queryAiQcByItemDevId.setAdopt(adopt);
			System.out.println(queryAiQcByItemDevId.toString());
			lisAiQcItemDevCodeService.save(queryAiQcByItemDevId);
			return resultMap;
		}
		
	}
	
}
