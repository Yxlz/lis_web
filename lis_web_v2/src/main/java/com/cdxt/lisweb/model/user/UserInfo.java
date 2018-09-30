package com.cdxt.lisweb.model.user;


/**
 * 互宜达接收的用户信息
 * 
 * @author hezheng
 */
public class UserInfo {

	private String usercd;
	private String truename;
	private String orgcd;
	private String orgname;
	private String deptcd;
	private String loginname;
	private String deptname;
	private String pwd;
	private String msgcreatetime;

	public String getUsercd() {
		return usercd;
	}

	public void setUsercd(String usercd) {
		this.usercd = usercd;
	}

	public String getTruename() {
		return truename;
	}

	public void setTruename(String truename) {
		this.truename = truename;
	}

	public String getOrgcd() {
		return orgcd;
	}

	public void setOrgcd(String orgcd) {
		this.orgcd = orgcd;
	}

	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	public String getDeptcd() {
		return deptcd;
	}

	public void setDeptcd(String deptcd) {
		this.deptcd = deptcd;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getMsgcreatetime() {
		return msgcreatetime;
	}

	public void setMsgcreatetime(String msgcreatetime) {
		this.msgcreatetime = msgcreatetime;
	}

}
