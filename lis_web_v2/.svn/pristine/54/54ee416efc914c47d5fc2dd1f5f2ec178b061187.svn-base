package com.cdxt.lisweb.dao.user;

import com.cdxt.lisweb.dao.BaseDao;
import com.cdxt.lisweb.entity.user.Right;

import java.util.List;

/**
 * @author wutianfa
 * @date 2017/5/3 14:22
 * @since 1.0.0
 */
public interface RightDao extends BaseDao<Right>{

	/**
	* @Title: getRightList
	* @Description: 根据parentId获取对应的下一级子节点信息，不会一次性读取全部的数据
	* @最后修改人：hezheng
	* @最后修改时间：2017-5-3 下午6:36:33
	* @see com.cdxt.lisweb.dao.user.RightDao#getRightList(java.lang.String)
	* @param parentId
	* @return 对方法的参数进行描述
	* @throws
	*/
    List<Right> getRightList(String parentId);

    /**
     * 查找所有父节点
     * @return
     */
    List<Right> findAllParentNode();

	int findMaxRightId(String parentCode);

	List<Right> getRightByCode(String rightCode);

    /**
     * @discription 获取某个用户的菜单信息
     * @author hezheng   
     * @created 2017-5-4 下午2:44:31
     * @param @param user
     * @param @param parentId
     * @param @return
     * @return List<Right>
     */
    List<Right> getRightList(String user, String parentId);
    
    /**
     * 获取某用户的全部权限信息
     * 
     * @param account 登录用户名
     */
    List<Right> getRightsByAccount(String account);

	/**
	 * 级联删除
	 * @param rightId
	 */
	void deleteByParentId(String rightId);

    /**
     * 获取角色的所有叶子节点菜单
     * @param roleid
     * @return
     */
    List<Right> findLeafNodeByRoleid(String roleid);

}
