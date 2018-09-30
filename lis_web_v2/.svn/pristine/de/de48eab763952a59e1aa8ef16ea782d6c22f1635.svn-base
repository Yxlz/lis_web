package com.cdxt.lisweb.entity.user;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the LIS_HOSPITAL database table.
 * 
 */
@Entity
@Table(name="LIS_HOSPITAL")
@NamedQuery(name="LisHospital.findAll", query="SELECT l FROM LisHospital l")
public class LisHospital implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name="BARCODE_PREFIX")
	private String barcodePrefix;

	@Column(name="\"DATABASE\"")
	private String database;

	@Column(name="HOSP_CODE")
	private String hospCode;

	@Column(name="HOSP_NAME")
	private String hospName;

	@Column(name="HOSP_SX")
	private String hospSx;

	@Column(name="IS_USED")
	private String isUsed;

	@Column(name="IS_VISABLE")
	private String isVisable;

	private String password;

	@Column(name="PHONE_NUM")
	private String phoneNum;

	@Column(name="SERVER_IP")
	private String serverIp;

	private String userid;

	public LisHospital() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBarcodePrefix() {
		return this.barcodePrefix;
	}

	public void setBarcodePrefix(String barcodePrefix) {
		this.barcodePrefix = barcodePrefix;
	}

	public String getDatabase() {
		return this.database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public String getHospCode() {
		return this.hospCode;
	}

	public void setHospCode(String hospCode) {
		this.hospCode = hospCode;
	}

	public String getHospName() {
		return this.hospName;
	}

	public void setHospName(String hospName) {
		this.hospName = hospName;
	}

	public String getHospSx() {
		return this.hospSx;
	}

	public void setHospSx(String hospSx) {
		this.hospSx = hospSx;
	}

	public String getIsUsed() {
		return this.isUsed;
	}

	public void setIsUsed(String isUsed) {
		this.isUsed = isUsed;
	}

	public String getIsVisable() {
		return this.isVisable;
	}

	public void setIsVisable(String isVisable) {
		this.isVisable = isVisable;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNum() {
		return this.phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getServerIp() {
		return this.serverIp;
	}

	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

}