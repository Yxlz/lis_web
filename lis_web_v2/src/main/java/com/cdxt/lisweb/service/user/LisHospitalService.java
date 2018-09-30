package com.cdxt.lisweb.service.user;

import java.util.Map;

import com.cdxt.lisweb.entity.user.LisHospital;
import com.cdxt.lisweb.service.BaseService;

/**
 * @author : zhaozeyu 
 * @date 创建时间：2018年1月4日 下午1:39:30
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: //TODO
 */
public interface LisHospitalService  extends BaseService<LisHospital> {
	public Map<String, Object> queryHosByPage(int start, int limit, String name);
}
