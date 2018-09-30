package com.cdxt.lisweb.controller.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cdxt.lisweb.controller.BaseController;
import com.cdxt.lisweb.entity.user.LisInspecRole;
import com.cdxt.lisweb.entity.user.LisInspecUser;
import com.cdxt.lisweb.service.user.LisInspecRoleService;
import com.cdxt.lisweb.service.user.LisInspecUserService;


/**
 * 用户管理模块
 * 
 * @author lixying
 * @date 2017年5月2日 下午3:04:19
 * @since 1.0.0
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController{

  @Autowired
  private LisInspecUserService userService;

  @Autowired
  private LisInspecRoleService roleService;

  /**
   * 获取所有用户
   * 
   * @return
   */
  @RequestMapping(value = "getUsers.do", produces = "application/json;charset=utf8")
  @ResponseBody
  public Map<String, Object> getUsers(int start, int limit, String userName) {
    Map<String, Object> query = new HashMap<String, Object>();
    if (StringUtils.hasText(userName)) {
      query.put("username", userName);
    }

    Map<String, Object> users = userService.queryAllByPage(start, limit, query);
    return users;
  }

  @RequestMapping(value = "saveUser.do", produces = "application/json;charset=utf8")
  @ResponseBody
  public void saveUser(@RequestBody LisInspecUser user,HttpServletResponse response) {
	  userService.save(user);
	  this.resJsonMessage(response, "保存成功");
	  //return "{success:true}";
  }

  @RequestMapping(value = "delUser.do", produces = "application/json;charset=utf8")
  @ResponseBody
  public String delUser(@RequestBody List<LisInspecUser> user) {
    userService.deleteAll(user);
    return "{success:true}";
  }

  /**
   * 获取所有角色信息
   * 
   * @return
   */
  @RequestMapping(value = "getRoles.do", produces = "application/json;charset=utf8")
  @ResponseBody
  public List<LisInspecRole> getRoles() {
    return roleService.queryAll();
  }
  
  /***
   * 修改用户信息
   * @param user
   * @return
   */
  @RequestMapping(value = "updateUser.do", produces = "application/json;charset=utf8")
  @ResponseBody
  public String updateUser(@RequestBody LisInspecUser user,HttpServletResponse response) {
	  userService.update(user);
	  //this.resJsonMessage(response, "修改成功");
	  return "{success:true}";
  }

}
