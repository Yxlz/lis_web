package com.cdxt.lisweb.service.statistics;

import com.cdxt.lisweb.entity.statistics.LisCustomSetting;
import com.cdxt.lisweb.service.BaseService;

/**
 * @author : Tangxiaohui 
 * @date 创建时间：2018年1月9日 下午3:58:21
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: //TODO
 */
public interface LisCustomSettingService extends BaseService<LisCustomSetting> {

	/**
	 * 根据报表url名称查询报表的url
	 * @param url_name
	 * @return
	 */
	String getUrlByUrlName(String url_name) throws Exception;

}
