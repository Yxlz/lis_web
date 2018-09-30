package com.cdxt.lisweb.service.mdro;

import com.cdxt.lisweb.entity.mdro.LisWebMdrosSuggestion;
import com.cdxt.lisweb.service.BaseService;

/**
 * @author : Tangxiaohui 
 * @date 创建时间：2018年9月11日 下午1:38:03
 * @version 1.0
 * @company :成都信通网易医疗科技发展有限公司
 * @description: 耐药菌服务接口
 */
public interface LisWebMdrosSuggestionService extends BaseService<LisWebMdrosSuggestion> {

	/**
	 * 根据耐药菌代码查询耐药菌信息
	 */
	LisWebMdrosSuggestion getLisWebMdrosSuggestionByMdroCode(String mdroCode);

	void saveClob(LisWebMdrosSuggestion mdro);

	void updateClob(LisWebMdrosSuggestion mdro);

}
