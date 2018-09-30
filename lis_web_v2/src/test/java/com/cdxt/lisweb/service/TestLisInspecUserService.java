package com.cdxt.lisweb.service;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cdxt.lisweb.BaseTest;
import com.cdxt.lisweb.constants.CommonConstants;
import com.cdxt.lisweb.entity.user.LisInspecUser;
import com.cdxt.lisweb.service.user.LisInspecUserService;

/**
 * @author : Tangxiaohui 
 * @date 创建时间：2018年1月4日 上午9:56:52
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: //TODO
 */
public class TestLisInspecUserService extends BaseTest {
	
	@Autowired LisInspecUserService service;
	
	@SuppressWarnings("unchecked")
	@Test
	public void test(){
		Map<String, Object> users=service.queryAllByPage(0, 10, null);
		//String num = (String) users.get(CommonConstants.QUERY_PAGE_TOTAL);
		List<LisInspecUser> list = (List<LisInspecUser>) users.get(CommonConstants.QUERY_PAGE_ROWS);
		//System.out.println(num);
		for (LisInspecUser lisInspecUser : list) {
			System.out.println(lisInspecUser.getUsernameCn());
		}
	}
}
