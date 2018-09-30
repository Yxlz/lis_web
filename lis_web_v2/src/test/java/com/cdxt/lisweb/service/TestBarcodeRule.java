package com.cdxt.lisweb.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cdxt.lisweb.BaseTest;
import com.cdxt.lisweb.entity.req.LisRequestionReceive;
import com.cdxt.lisweb.exception.BarCodeRuleContainerNotSetException;
import com.cdxt.lisweb.exception.BarCodeRuleNotFoundException;
import com.cdxt.lisweb.service.barcode.LisBarCodeRuleService;

public class TestBarcodeRule extends BaseTest {
	@Autowired
	private LisBarCodeRuleService ruleService;
	
	@Test
	public void testCreateBarCode()
		      throws BarCodeRuleNotFoundException, BarCodeRuleContainerNotSetException {
		Map<String, List<String>> barCodeRefItem = new HashMap<String, List<String>>();
		LisRequestionReceive req = new LisRequestionReceive();
		
		req.setRequestItemName("血常规，尿常规");
		ruleService.createBarCode(req, barCodeRefItem);
	}

}
