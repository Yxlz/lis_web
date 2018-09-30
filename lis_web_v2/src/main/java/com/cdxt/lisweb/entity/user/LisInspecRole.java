package com.cdxt.lisweb.entity.user;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the LIS_INSPEC_ROLE database table.
 * 
 */
@Entity
@Table(name="LIS_INSPEC_ROLE")
@NamedQuery(name="LisInspecRole.findAll", query="SELECT l FROM LisInspecRole l")
public class LisInspecRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name="ROLE_DESCRIPTION")
	private String roleDescription;

	@Column(name="ROLE_NAME")
	private String roleName;

	@Column(name="ROLE_NUMBER")
	private BigDecimal roleNumber;

	//bi-directional many-to-one association to LisInspecUser
//	@OneToMany(mappedBy="lisInspecRole")
//	private List<LisInspecUser> lisInspecUsers;

	public LisInspecRole() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoleDescription() {
		return this.roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public BigDecimal getRoleNumber() {
		return this.roleNumber;
	}

	public void setRoleNumber(BigDecimal roleNumber) {
		this.roleNumber = roleNumber;
	}

//	@Transient
//	public List<LisInspecUser> getLisInspecUsers() {
//		return this.lisInspecUsers;
//	}
//
//	public void setLisInspecUsers(List<LisInspecUser> lisInspecUsers) {
//		this.lisInspecUsers = lisInspecUsers;
//	}

//	public LisInspecUser addLisInspecUser(LisInspecUser lisInspecUser) {
//		getLisInspecUsers().add(lisInspecUser);
//		lisInspecUser.setLisInspecRole(this);
//
//		return lisInspecUser;
//	}
//
//	public LisInspecUser removeLisInspecUser(LisInspecUser lisInspecUser) {
//		getLisInspecUsers().remove(lisInspecUser);
//		lisInspecUser.setLisInspecRole(null);
//
//		return lisInspecUser;
//	}

}