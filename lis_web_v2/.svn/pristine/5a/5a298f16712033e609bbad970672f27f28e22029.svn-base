package com.cdxt.lisweb.service.user;

import com.cdxt.lisweb.entity.user.Right;
import com.cdxt.lisweb.model.right.RightNode;
import com.cdxt.lisweb.model.tree.MenuModel;
import com.cdxt.lisweb.model.tree.TreeViewNode;
import com.cdxt.lisweb.service.BaseService;

import java.util.List;

/**
 * @author wutianfa
 * @date 2017/5/3 14:15
 * @since 1.0.0
 */
public interface RightService extends BaseService<Right>{
    /**
     * 获取菜单列表
     */
    List<Right> getRightList(String parentId);
    
    /**
     * 获取某用户的菜单列表
     * 
     * @param user 登录用户名
     */
    List<Right> getRightList(String user, String parentId);
    
    /**
     * 获取某用户的全部权限信息
     * 
     * @param account 登录用户名
     */
    List<Right> getRightsByAccount(String account);
    
    /**
     * 将菜单链表转换成菜单树
     * @param rts
     * @return
     */
    List<RightNode> rightsToTree(List<Right> rts);

    /**
     * 获取所有父节点
     */
    List<Right> findAllParentNode();
    
    /**
     * 获取角色的所有叶子节点菜单
     * @param roleid
     * @return
     */
    List<Right> findLeafNodeByRoleid(String roleid);

    /**
     * 查找最大菜单id
     * @param parentCode
     * @return
     */
    int findMaxRightId(String parentCode);

    /**
     * 通过菜单id获取菜单
     * @param rightCode
     * @return
     */
    List<Right> getRightByCode(String rightCode);

    /**
     * 删除菜单
     * @param rightId
     */
    void deleteByRightId(String rightId);
    
    /**
     * 转换成页面需要的tree数据结构
     * @param rts 权限LIST
     * @param user 当前用户  为空则表示查询所有权限
     * @return
     */
    List<TreeViewNode> rightsToTreeViewNode(List<Right> rts,String user);
    /**
     * 转换成菜单数据结构
     * @param rts
     * @param user
     * @return
     */
    List<MenuModel> rightsToMenu(List<Right> rts,String user);

    
    /**
     * 分析角色已拥有的权限树 和全体权限树  返回差异树
     * @param rts 权限LIST
     * @param user 当前用户  为空则表示查询所有权限
     * @return
     */
    List<TreeViewNode> makeDifferentTree(List<TreeViewNode> alltree,List<Right> roleRightList);
}
