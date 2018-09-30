package com.cdxt.lisweb.dao.user;

import com.cdxt.lisweb.dao.BaseDao;
import com.cdxt.lisweb.entity.user.LisInspecUser;

/**
 * @author : Tangxiaohui 
 * @date 创建时间：2018年1月3日 上午9:27:29
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: //TODO
 */
public interface LisInspecUserDao extends BaseDao<LisInspecUser> {
	  /**
	  * @discription 根据用户账户获取用户信息
	  * @author hezheng       
	  * @created 2017-5-4 下午5:26:33
	  * @param @param account
	  * @param @return
	  * @return User
	  */
	 LisInspecUser getUserByAccount(String account);
	 
	  /**
	   * 用户密码修改
	   * 
	   * @param account 账号
	   * @param oldPwd 旧密码
	   * @param newPwd  新密码
	   * @return int  返回非0 更改成功，否则失败
	   * @throws Exception
	   */
	  int updatePassword(String username, String newPwd) throws Exception;
}
