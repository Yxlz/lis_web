package com.cdxt.lisweb.entity.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The persistent class for the LIS_INSPEC_DEPARTMENTS database table.
 * 
 */
@Entity
@Table(name="LIS_INSPEC_DEPARTMENTS")
public class LisInspecDepartment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name="CHARGE_HIS_ID")
	private String chargeHisId;

	@Column(name="DEPART_NAME")
	private String departName;

	@Column(name="HIS_ID")
	private String hisId;



	@Column(name="HOSPITAL_ID")
	private String hospitalId;

	@Column(name="UPLOAD_NAME")
	private String uploadName;

	//bi-directional many-to-one association to LisInspecUser
//	@OneToMany(mappedBy="lisInspecDepartment")
//	private List<LisInspecUser> lisInspecUsers;

	public LisInspecDepartment() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getChargeHisId() {
		return this.chargeHisId;
	}

	public void setChargeHisId(String chargeHisId) {
		this.chargeHisId = chargeHisId;
	}

	public String getDepartName() {
		return this.departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
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

	public String getUploadName() {
		return this.uploadName;
	}

	public void setUploadName(String uploadName) {
		this.uploadName = uploadName;
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
//		lisInspecUser.setLisInspecDepartment(this);
//
//		return lisInspecUser;
//	}
//
//	public LisInspecUser removeLisInspecUser(LisInspecUser lisInspecUser) {
//		getLisInspecUsers().remove(lisInspecUser);
//		lisInspecUser.setLisInspecDepartment(null);
//
//		return lisInspecUser;
//	}

}