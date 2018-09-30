package com.cdxt.lisweb.controller.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cdxt.lisweb.constants.CommonConstants;
import com.cdxt.lisweb.controller.BaseController;
import com.cdxt.lisweb.entity.user.Right;
import com.cdxt.lisweb.model.tree.TreeViewNode;
import com.cdxt.lisweb.service.user.RightService;

/**
 * @author wutianfa
 * @date 2017/5/3 14:13
 * @since 1.0.0
 */

@Controller
@RequestMapping("/right")
public class RightController extends BaseController {

  //private static Logger log = LoggerFactory.getLogger(HosOrgInfoController.class);

  @Autowired
  private RightService rightService;

  /**
   * 获取菜单
   * 
   * @return
   */
  @RequestMapping(value = "getRight.do", produces = "application/json;charset=utf8")
  @ResponseBody
	public List<TreeViewNode> getRight() {
		List<Right> rights = rightService.getRightList("0");
		List<TreeViewNode> list = rightService.rightsToTreeViewNode(rights, null);
		return list;
	}
  /**
   * 获取当前角色没有的权限列表
   * 
   * @return
   */
  @RequestMapping(value = "getNothaveRight.do", produces = "application/json;charset=utf8")
  @ResponseBody
	public List<TreeViewNode> getNothaveRight(String rId) {
		List<Right> roleRight = rightService.findLeafNodeByRoleid(rId);
		List<Right> allrts = rightService.getRightList("0");
		List<TreeViewNode> allTree = rightService.rightsToTreeViewNode(allrts, null);
		List<TreeViewNode> nothaveList = new ArrayList<TreeViewNode>();
		try {
			nothaveList = rightService.makeDifferentTree(allTree, roleRight);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nothaveList;
	}
  /**
   * 获取父菜单
   * 
   * @return
   */
  @RequestMapping(value = "getParentRight.do", produces = "application/json;charset=utf8")
  @ResponseBody
  public List<Right> getParentRight() {
    List<Right> allParentNode = rightService.findAllParentNode();
    return allParentNode;
  }


  /**
   * 根据菜单id查询菜单信息
   */

  @RequestMapping(value = "getRightByCode.do", produces = "application/json;charset=utf8")
  @ResponseBody
  public List<Right> getRightByCode(String rightCode) {
    return rightService.getRightByCode(rightCode);
  }

  /**
   * 添加菜单 @param right @throws
   */
  @RequestMapping(value = "addRight.do", produces = "application/json;charset=utf8")
  @ResponseBody
  public String addRight(@RequestBody Right right) {
    if (right.getId() != null && (!"".equals(right.getId()))) {
      rightService.update(right);
    } else {
      // 如果菜单Id为空 生成菜单id
      if (right.getRightCode() == null || "".equals(right.getRightCode())) {
        right.setId(null);
        right.setIsLeaf("0");//标记为叶子节点
        int maxRightId = 0;
        if ("0".equals(right.getParentCode()) || right.getParentCode() == null) {
          maxRightId = rightService.findMaxRightId("0");
          right.setParentCode("0");
        } else {
        	Right parentRight = rightService.getRightByCode(right.getParentCode()).get(0);
        	if ("0".equals(parentRight.getIsLeaf())) {
        		parentRight.setIsLeaf("1");//将父节点标记为非叶子节点
            	rightService.update(parentRight);
			}
        	maxRightId = rightService.findMaxRightId(right.getParentCode());
        }
        // 生成 菜单ID
        maxRightId++;
        right.setRightCode(String.valueOf(maxRightId));
      }
      rightService.save(right);
    }
    return this.createResJson(CommonConstants.INTEGER_ZERO, null);
  }

  @RequestMapping(value = "deleteRight.do",produces="application/x-www-form-urlencoded")
  @ResponseBody
  public String deleteRight(String rightId) throws IOException {
    try {
      rightService.deleteByRightId(rightId);
      return this.createResJson(CommonConstants.INTEGER_ZERO, null);
    } catch (Exception e) {
      return this.createResJson(CommonConstants.INTEGER_ONE, e.getMessage());
    }

  }
}
