package com.cdxt.lisweb.entity.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * The persistent class for the LIS_INSPEC_USERS database table.
 * 
 */
@Entity
@Table(name="LIS_INSPEC_USERS")
@NamedQuery(name="LisInspecUser.findAll", query="SELECT l FROM LisInspecUser l")
public class LisInspecUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Lob
	@Column(name="AUTO_GRAPH")
	private String autoGraph;

	@ManyToOne
	@JoinColumn(name="DEPT_ID")
	private LisInspecDepartment lisInspecDepartment;

	@Column(name="DEV_CODES")
	private String devCodes;

	private String enabled;

	@Column(name="HIS_ID")
	private String hisId;

	@Column(name="HOSPITAL_ID")
	private String hospitalId;

	@Column(name="INSPEC_NAME")
	private String inspecName;

	private String password;

	private String permissions;

	private String username;

	@Column(name="USERNAME_CN")
	private String usernameCn;

	//bi-directional many-to-one association to LisInspecRole
	@ManyToOne
	@JoinColumn(name="\"ROLE\"")
	private LisInspecRole lisInspecRole;

	public LisInspecUser() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	@Transient
	public String getAutoGraph() {
		return this.autoGraph;
	}

	public void setAutoGraph(String autoGraph) {
		this.autoGraph = autoGraph;
	}


	public String getDevCodes() {
		return this.devCodes;
	}

	public void setDevCodes(String devCodes) {
		this.devCodes = devCodes;
	}

	public String getEnabled() {
		return this.enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getHisId() {
		return this.hisId;
	}

	public void setHisId(String hisId) {
		this.hisId = hisId;
	}

	public String getHospitalId() {
		return this.hospitalId;
	}

	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getInspecName() {
		return this.inspecName;
	}

	public void setInspecName(String inspecName) {
		this.inspecName = inspecName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPermissions() {
		return this.permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsernameCn() {
		return this.usernameCn;
	}

	public void setUsernameCn(String usernameCn) {
		this.usernameCn = usernameCn;
	}

	public LisInspecRole getLisInspecRole() {
		return this.lisInspecRole;
	}

	public void setLisInspecRole(LisInspecRole lisInspecRole) {
		this.lisInspecRole = lisInspecRole;
	}

	public LisInspecDepartment getLisInspecDepartment() {
		return lisInspecDepartment;
	}

	public void setLisInspecDepartment(LisInspecDepartment lisInspecDepartment) {
		this.lisInspecDepartment = lisInspecDepartment;
	}

	
}