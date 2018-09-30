package com.cdxt.lisweb.controller.login;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cdxt.lisweb.constants.CommonConstants;
import com.cdxt.lisweb.controller.BaseController;
import com.cdxt.lisweb.entity.user.LisInspecUser;
import com.cdxt.lisweb.entity.user.Right;
import com.cdxt.lisweb.model.right.Menu;
import com.cdxt.lisweb.model.right.Root;
import com.cdxt.lisweb.model.tree.TreeViewNode;
import com.cdxt.lisweb.service.user.LisInspecUserService;
import com.cdxt.lisweb.service.user.RightService;

@Controller
@RequestMapping("/login")
public class UserLoginController extends BaseController {

	private Logger logger = Logger.getLogger(getClass());

	@Resource
	private LisInspecUserService userService;

	@Autowired
	private RightService rightService;

	/**
	 * @Title: login @Description: 登录 @最后修改人：hezheng @最后修改时间：2017-4-24 下午2:54:16 @param
	 *         request @param response @return 对方法的参数进行描述 @return String 返回类型 @throws
	 */
	@RequestMapping(value = "/login")
	public void login(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try {
			if (StringUtils.isBlank(username)) {
				this.resJsonMessage(response, CommonConstants.INTEGER_ONE,
						"用户名不能为空！");
				return;
			}
			if (StringUtils.isBlank(password)) {
				this.resJsonMessage(response, CommonConstants.INTEGER_ONE,
						"密码不能为空！");
				return;
			}
			Subject subject = SecurityUtils.getSubject();
			subject.logout();
			// 登录后存放进shiro token
			UsernamePasswordToken token = new UsernamePasswordToken(username,
					password);
			subject.login(token);
			this.resJsonMessage(response, CommonConstants.INTEGER_ZERO, "登陆成功！");
		} catch (AuthenticationException e) {
			e.printStackTrace();
			this.resJsonMessage(response, CommonConstants.INTEGER_ONE,
					e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			this.resJsonMessage(response, CommonConstants.INTEGER_ONE,
					"系统错误！登陆失败！");
		}
	}

	/**
	 * @Title: loginout
	 * @Description: 用户登出，只有处于登陆状态的才需要进行登出，否则直接跳转至登陆页面
	 * @最后修改人：hezheng
	 * @最后修改时间：2017-5-2 下午5:38:45
	 * @param request
	 * @param response
	 *            对方法的参数进行描述
	 * @return void 返回类型
	 * @throws
	 */
	@RequiresUser
	@RequestMapping(value = "/logout")
	
	public void logout(HttpServletRequest request, HttpServletResponse response) {
		try {
			Subject currentUser = SecurityUtils.getSubject();
			Object pc = currentUser.getPrincipal();
			currentUser.logout();
			logger.info("用户" + pc + "登出成功！");
			this.resJsonMessage(response, 0, "您已安全退出！");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 用户密码修改
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/changePwd")
	public void changePwd(HttpServletRequest request,
			HttpServletResponse response) {
		String oldPwd = request.getParameter("oldPwd");
		String password = request.getParameter("password");
		String rePassword = request.getParameter("rePassword");
		try {
			if (StringUtils.isBlank(oldPwd)) {
				this.resJsonMessage(response, 1, "原始密码不能为空！");
				return;
			}
			if (StringUtils.isBlank(password)) {
				this.resJsonMessage(response, 1, "新密码不能为空！");
				return;
			}
			if (StringUtils.isBlank(rePassword)) {
				this.resJsonMessage(response, 1, "确认密码不能为空！");
				return;
			}
			if (!password.equals(rePassword)) {
				this.resJsonMessage(response, 1, "新密码和确认密码不一致！");
				return;
			}
			Subject currentUser = SecurityUtils.getSubject();
			String account = (String) currentUser.getPrincipal();
			int code = userService.updatePassword(account, oldPwd, password);
			if (code == -1) {
				this.resJsonMessage(response, 1, "原始密码不正确！");
				return;
			}
			if (code > 0) {
				logger.info("用户[" + account + "]密码修改成功！");
				this.resJsonMessage(response, 0, "密码修改成功！");
				return;
			}
			this.resJsonMessage(response, 1, "数据异常，密码修改失败！");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("用户密码修改失败！" + e.getMessage(), e);
			this.resJsonMessage(response, 1, "系统错误，密码修改失败！");
		}
	}

	

	/**
	 * @Title: login @Description: 用户信息获取测试 @最后修改人：hezheng @最后修改时间：2017-4-24
	 *         下午2:54:16 @param request @param response @return 对方法的参数进行描述 @return
	 *         String 返回类型 @throws
	 */
	@RequiresUser
	@RequestMapping(value = "/loguser", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String loguser(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			Object user = SecurityUtils.getSubject().getPrincipal();
			LisInspecUser u = userService.getUserByAccount(String.valueOf(user));
			return u.getUsername();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@RequiresUser
	@RequestMapping(value = "/userAccount", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String userAccount(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			Object user = SecurityUtils.getSubject().getPrincipal();
			return String.valueOf(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 
	 * @param request
	 * @param response
	 * @return 返回用户的组织信息
	 */
	@RequiresUser
	@RequestMapping(value = "/orgname"  ,produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String orgname(HttpServletRequest request,
			HttpServletResponse response) {/*
		
		try {
			
			Object user = SecurityUtils.getSubject().getPrincipal();
			LisInspecUser cuser = userService.getUserByAccount(String.valueOf(user).trim());
			//String orgId = lisHospitalItemService.getHosOrgInfoIDByUserId(cuser.getId());
			String orgname="";
			if(orgId!=null){
				HosOrgInfo orgInfo = hosOrgInfoService.queryById(orgId);
				orgname = orgInfo.getOrgName();
				if(orgname.equals("四川大学华西第二医院 HX")){
					orgname = "华西二院";
				}
			}else{
				orgname = "未分配机构";
			}
			return orgname;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	*/ return null;}

	/**
	 * @Title: islogin
	 * @Description: 判断是否登陆
	 * @最后修改人：hezheng
	 * @最后修改时间：2017-5-2 下午5:58:06
	 * @return 对方法的参数进行描述
	 * @return String 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/islogin")
	public void islogin(HttpServletResponse response) {
		Subject currentUser = SecurityUtils.getSubject();
		if (currentUser.isAuthenticated()) {
			this.resJsonMessage(response, 0, "已登陆！");
			return;
		}
		this.resJsonMessage(response, 1, "未登陆！");
	}

	/**
	 * @discription 加载根节点信息
	 * @author hezheng
	 * @created 2017-5-4 下午2:40:51
	 * @param @param parentId
	 * @param @param response
	 * @return void
	 */
	@RequiresUser
	@RequestMapping(value = "/loadRoots")
	public void loadRoots(String parentId, HttpServletResponse response) {
		Object user = SecurityUtils.getSubject().getPrincipal();
		List<Right> rights = rightService.getRightList(user.toString(), "0");
		List<Menu> menus = new ArrayList<Menu>();
		for (Right right : rights) {
			Menu menu = new Menu();
			menu.setMid(right.getRightCode());
			menu.setTitle(right.getText());
			menu.setRoot(new Root(right.getRightCode()));
			menus.add(menu);
		}
		this.resJsonMessage(response, menus);
	}

	/**
	 * @discription 加载子菜单信息
	 * @author hezheng
	 * @created 2017-5-4 下午2:40:51
	 * @param @param parentId
	 * @param @param response
	 * @return void
	 */
	@RequiresUser
	@RequestMapping(value = "/loadMenus")
	public void loadMenus(String parentId, HttpServletResponse response) {
		Object user = SecurityUtils.getSubject().getPrincipal();
		List<Right> rights = rightService.getRightList(user.toString(),
				parentId);
		this.resJsonMessage(response, rightService.rightsToTree(rights));
	}

	/**
	 * @discription 加载左边导航菜单
	 * @author zhaozeyu
	 * @created 2018年1月9日 16:41:42
	 * @param @param parentId
	 * @param @param response
	 * @return void
	 */
	@RequiresUser
	@RequestMapping(value = "/loadTreeMenus")
	@ResponseBody
	public List<TreeViewNode> loadTreeMenus() {
		Object user = SecurityUtils.getSubject().getPrincipal();
		List<Right> rights = rightService.getRightList(user.toString(), "0");
		//List<TreeViewNode> list = rightService.rightsToTreeViewNode(rights, user.toString());
		List<TreeViewNode> list = rightService.rightsToTreeViewNode(rights, user.toString());
		return list;
	}
	
	/**
	 * @Title: login
	 * @Description: 用户信息获取测试
	 * @最后修改人：hezheng @最后修改时间：2017-4-24 下午2:54:16
	 * @param request
	 * @param response
	 * @return 对方法的参数进行描述
	 * @return String 返回类型
	 * @throws org.apache.shiro.subject.support.DefaultSubjectContext_AUTHENTICATED_SESSION_KEY
	 *             ---- true
	 *             org.apache.shiro.web.session.HttpServletSession.HOST_SESSION_KEY
	 *             ----127.0.0.1 org.apache.shiro.subject.support.
	 *             DefaultSubjectContext_PRINCIPALS_SESSION_KEY----admin, {}
	 */
	@RequestMapping(value = "/loginSuccess")
	@SuppressWarnings("rawtypes")
	public String loginSuccess(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			Enumeration e = request.getSession().getAttributeNames();
			while (e.hasMoreElements()) {
				String sessionName = (String) e.nextElement();
				Object value = request.getSession().getAttribute(sessionName);
				System.out.println(sessionName + "----" + value);
			}
			SimplePrincipalCollection spc = (SimplePrincipalCollection) request
					.getSession()
					.getAttribute(
							"org.apache.shiro.subject.support.DefaultSubjectContext_PRINCIPALS_SESSION_KEY");
			String username = (String) spc.getPrimaryPrincipal();
			System.out.println(username);
			Set<String> realmNames = spc.getRealmNames();
			System.out.println(realmNames);
			Object user = request.getUserPrincipal();
			System.out.println(user);
			// Subject currentUser = SecurityUtils.getSubject();
			// Session session = currentUser.getSession();
			// User user1 = (User)
			// session.getAttribute(CommonConstants.SHIRO_USER);
			LisInspecUser currUser = (LisInspecUser) request.getSession().getAttribute(
					CommonConstants.SHIRO_USER);
			System.out.println(currUser);
			// List<Role> role = user2.getRoles();
			return "/main";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@RequiresUser
	@RequestMapping(value = "/getCurrUser")
	@ResponseBody
	public String getCurrUser(){
		Object user = SecurityUtils.getSubject().getPrincipal();
		return this.createResJson(0, user.toString());
	}
}
