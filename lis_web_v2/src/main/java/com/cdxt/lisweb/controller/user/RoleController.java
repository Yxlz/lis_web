package com.cdxt.lisweb.controller.user;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cdxt.lisweb.constants.CommonConstants;
import com.cdxt.lisweb.controller.BaseController;
import com.cdxt.lisweb.entity.user.LisInspecRole;
import com.cdxt.lisweb.entity.user.Right;
import com.cdxt.lisweb.model.tree.TreeViewNode;
import com.cdxt.lisweb.service.user.LisInspecRoleService;
import com.cdxt.lisweb.utils.DateUtils;

/**
 * 角色管理
 * 
 * @author zhaozeyu
 * @date 2017年5月3日 下午2:04:52
 * @since 1.0.0
 */
@Controller
@RequestMapping("/role")
public class RoleController extends BaseController {

	@Autowired
	private LisInspecRoleService roleService;


	/**
	 * 查询所有角色
	 * 
	 * @param start
	 * @param limit
	 * @return
	 */
	@RequestMapping(value = "getRoles.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public List<LisInspecRole> getRoles() {
		return roleService.queryAll();

	}

	/**
	 * 分页查询所有角色
	 * 
	 * @param start
	 * @param limit
	 * @return
	 */
	@RequestMapping(value = "getRolesByPage.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public Map<String, Object> getRolesByPage(int start, int limit,
			String roleName) {
		Map<String, Object> query = new HashMap<String, Object>();
		if (StringUtils.hasText(roleName)) {
			query.put("roleName", roleName);
		}
		Map<String, Object> roles = roleService.queryAllByPage(start, limit,query);
		return roles;
	}

	/**
	 * 保存角色
	 * 
	 * @param r
	 * @return
	 */
	@RequestMapping(value = "saveRole.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public String saveRole(@RequestBody LisInspecRole r) {
		if (StringUtils.hasText(r.getId())) {
			roleService.update(r);
			return this.createResJson(CommonConstants.INTEGER_ZERO, "success");
		} else {
			String format = "YYYYMMddHHmmss";
			Date date = new Date();
			String id = "LIS" + DateUtils.formatDate(date, format);
			r.setId(id);
			roleService.save(r);
			return this.createResJson(CommonConstants.INTEGER_ZERO, "success");
		}
	}

	/**
	 * 删除角色
	 * 
	 * @param r
	 * @return
	 */
	@RequestMapping(value = "delRoles.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public String delRoles(@RequestBody List<LisInspecRole> rs) {
		try {
			roleService.deleteAll(rs);
		} catch (DataIntegrityViolationException e) {
			return this.createResJson(CommonConstants.INTEGER_ONE, "角色已被用户使用.");
		}
		return this.createResJson(CommonConstants.INTEGER_ZERO, "success");
	}

	/**
	 * 查询角色权限
	 * 
	 * @param roleId
	 * @return
	 */
	@RequestMapping(value = "getRoleRights.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public List<TreeViewNode> getRoleRights(String rId) {
		List<Right> rts = roleService.getRoleRights(rId, "0");
		List<TreeViewNode> list = roleService.roleRightsToTreeViewNode(rts, rId);
		return list;
	}

	/**
	 * 保存角色权限
	 * 
	 * @param roleId
	 * @return
	 */
	@RequestMapping(value = "saveRoleRights.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public String saveRoleRights(String roleId, String rts) {
		String[] ids = rts.split(",");

		roleService.saveRoleRights(roleId, ids);
		
		return this.createResJson(CommonConstants.INTEGER_ZERO, "");
	}

	/**
	 * 删除角色权限
	 * 
	 * @param roleId
	 * @return
	 */
	@RequestMapping(value = "deleteRoleRights.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public String deleteRoleRights(String roleId, String rightId) {
		String[] ids = rightId.split(",");

		roleService.deleteRoleRight(roleId, ids);

		return this.createResJson(CommonConstants.INTEGER_ZERO, "");
	}

}
