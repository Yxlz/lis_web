package com.cdxt.lisweb.entity.inspec;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the LIS_INSPEC_SAMPLE_TYPE database table.
 * 标本类型
 */
@Entity
@Table(name = "LIS_INSPEC_SAMPLE_TYPE")
@NamedQuery(name = "LisInspecSampleType.findAll", query = "SELECT l FROM LisInspecSampleType l")
public class LisInspecSampleType implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name="SAMPLE_CODE")
	private String sampleCode;

	@Column(name="SAMPLE_NAME")
	private String sampleName;

	@Column(name="SAMPLE_NAME_EN")
	private String sampleNameEn;

	@Column(name="DEV_CODE")
	private String devCode;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSampleCode() {
		return sampleCode;
	}

	public void setSampleCode(String sampleCode) {
		this.sampleCode = sampleCode;
	}

	public String getSampleName() {
		return sampleName;
	}

	public void setSampleName(String sampleName) {
		this.sampleName = sampleName;
	}

	public String getSampleNameEn() {
		return sampleNameEn;
	}

	public void setSampleNameEn(String sampleNameEn) {
		this.sampleNameEn = sampleNameEn;
	}

	public String getDevCode() {
		return devCode;
	}

	public void setDevCode(String devCode) {
		this.devCode = devCode;
	}
}
