package com.cdxt.lisweb.manager.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cdxt.lisweb.entity.examine.LisAiItemCheckReference;
import com.cdxt.lisweb.entity.examine.LisAiItemDevHist;
import com.cdxt.lisweb.entity.examine.LisAiItemDevICD;
import com.cdxt.lisweb.entity.examine.LisAiItemDevLO;
import com.cdxt.lisweb.manager.api.LisWeb;
import com.cdxt.lisweb.service.examine.LisAiItemCheckReferenceService;
import com.cdxt.lisweb.service.examine.LisAiItemDevHistService;
import com.cdxt.lisweb.service.examine.LisAiItemDevICDService;
import com.cdxt.lisweb.service.examine.LisAiItemDevLOService;

@Service("lisWebManager")
public class LisWebImp implements LisWeb{
	
	@Resource
	LisAiItemCheckReferenceService lisAiItemCheckReferenceService;
	
	@Resource
	LisAiItemDevLOService lisAiItemDevLOService;
	
	@Resource
	LisAiItemDevHistService lisAiItemDevHistService;
	
	@Resource
	LisAiItemDevICDService  lisAiItemDevICDService;
	
	/**
	 * 项目唯一编码获取范围规则数据
	 * @param itemCode
	 * @param devCode
	 * @return
	 */
	public List<LisAiItemCheckReference> getRefByItemDevId(String itemDevId ){
		
		return lisAiItemCheckReferenceService.findRefByItemDevId(itemDevId);
	}
	
	@Override
	public String getItemIdByItemCode(String itemCode) {
		// TODO Auto-generated method stub
		return lisAiItemCheckReferenceService.findItemIdByItemCode(itemCode);
	}

	@Override
	public List<LisAiItemDevLO> getLOByItemDevId(String itemDevId) {
		// TODO Auto-generated method stub
		return lisAiItemDevLOService.findLOByItemDevId(itemDevId);
	}

	@Override
	public List<LisAiItemDevHist> getHistByItemId(String itemDevId) {
		// TODO Auto-generated method stub
		return lisAiItemDevHistService.findHistByItemDevId(itemDevId);
	}

	@Override
	public List<LisAiItemDevICD> getKeyWords(String itemDevId) {
		// TODO Auto-generated method stub
		return lisAiItemDevICDService.findKeyWords(itemDevId);
	}

}
