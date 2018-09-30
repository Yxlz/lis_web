package com.cdxt.lisweb.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cdxt.lisweb.controller.BaseController;
import com.cdxt.lisweb.entity.user.LisInspecDepartment;
import com.cdxt.lisweb.service.user.LisInspecDepartmentService;

/**
 * @author : Tangxiaohui
 * @date 创建时间：2018年1月4日 下午1:35:31
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: //TODO
 */
@Controller
@RequestMapping("/dept")
public class LisInspecDepartmentController extends BaseController {

	@Autowired
	private LisInspecDepartmentService deptService;

	@RequestMapping(value = "getDepts.do", produces = "application/json;charset=utf8")
	@ResponseBody
	public List<LisInspecDepartment> getDepts() {
		return deptService.queryAll();

	}
}
