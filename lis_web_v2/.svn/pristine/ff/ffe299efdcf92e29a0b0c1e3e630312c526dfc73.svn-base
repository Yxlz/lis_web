package com.cdxt.lisweb.service.user;

import com.cdxt.lisweb.entity.user.LisInspecUser;
import com.cdxt.lisweb.service.BaseService;

/**
 * @author : Tangxiaohui 
 * @date 创建时间：2018年1月3日 上午9:46:14
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: //TODO
 */
public interface LisInspecUserService extends BaseService<LisInspecUser> {
	/**
	 * 根据账号获取用户信息
	 * 
	 * @param username 账号
	 * @return
	 * @throws Exception
	 */
	LisInspecUser getUserByAccount(String username) throws Exception;
	
    /**
     * 用户密码修改
     * 
     * @param account 账号
     * @param oldPwd 旧密码
     * @param newPwd  新密码
     * @throws Exception
     */
    int updatePassword(String username,String oldPwd,String newPwd) throws Exception;
	

}
