package com.cdxt.lisweb.entity.inspec;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the LIS_REQUESTION_ITEM database table.
 * 
 */
@Entity
@Table(name="LIS_REQUESTION_ITEM")
@NamedQuery(name="LisRequestionItem.findAll", query="SELECT l FROM LisRequestionItem l")
public class LisRequestionItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	
	@Column(name="CHARGE")
	private BigDecimal charge;

	@Column(name="CHARGE_WARD")
	private String chargeWard;

	@Column(name="CLINICAL_MEANING")
	private String clinicalMeaning;

	@Column(name="COLLECT_REQUEST")
	private String collectRequest;

	@Column(name="CONTAINER")
	private String container;

	@Column(name="CUSTOM_CODE")
	private String customCode;

	@Column(name="DISCOUNT")
	private String discount;

	@Column(name="HIS_ITEM_CODE")
	private String hisItemCode;

	@Column(name="HIS_ITEM_NAME")
	private String hisItemName;

	@Column(name="INSPEC_NAME")
	private String inspecName;

	@Column(name="IS_KN")
	private String isKn;

	@Column(name="IS_TAKEOUT")
	private String isTakeout;

	@Column(name="IS_USE")
	private String isUse;

	@Column(name="LAB_CLASS_NAME")
	private String labClassName;

	@Column(name="PACKAGE_FLAG")
	private String packageFlag;

	@Column(name="PEIS_ITEM_CODE")
	private String peisItemCode;

	@Column(name="PEIS_ITEM_NAME")
	private String peisItemName;

	@Column(name="REQUESTION_CODE")
	private String requestionCode;

	@Column(name="REQUESTION_NAME")
	private String requestionName;

	@Column(name="SAMPLE_NAME")
	private String sampleName;

	@Column(name="SUBMISSION_TIME_JZ")
	private String submissionTimeJz;

	@Column(name="SUBMISSION_TIME_MZ")
	private String submissionTimeMz;

	@Column(name="SUBMISSION_TIME_ZY")
	private String submissionTimeZy;

	@Column(name="TAKE_REPORT_TIME_JZ")
	private String takeReportTimeJz;

	@Column(name="TAKE_REPORT_TIME_MZ")
	private String takeReportTimeMz;

	@Column(name="TAKE_REPORT_TIME_ZY")
	private String takeReportTimeZy;

	@Column(name="TAKE_REPORT_WAY")
	private String takeReportWay;

	public LisRequestionItem() {
	}
	public LisRequestionItem(String id,BigDecimal charge,String container,String requestionName, String sampleName, String requestionCode){
		this.id = id;
		this.charge = charge;
		this.container = container;
		this.requestionName = requestionName;
		this.requestionCode = requestionCode;
		this.sampleName = sampleName;
	}
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigDecimal getCharge() {
		return this.charge;
	}

	public void setCharge(BigDecimal charge) {
		this.charge = charge;
	}

	public String getChargeWard() {
		return this.chargeWard;
	}

	public void setChargeWard(String chargeWard) {
		this.chargeWard = chargeWard;
	}

	public String getClinicalMeaning() {
		return this.clinicalMeaning;
	}

	public void setClinicalMeaning(String clinicalMeaning) {
		this.clinicalMeaning = clinicalMeaning;
	}

	public String getCollectRequest() {
		return this.collectRequest;
	}

	public void setCollectRequest(String collectRequest) {
		this.collectRequest = collectRequest;
	}

	public String getContainer() {
		return this.container;
	}

	public void setContainer(String container) {
		this.container = container;
	}

	public String getCustomCode() {
		return this.customCode;
	}

	public void setCustomCode(String customCode) {
		this.customCode = customCode;
	}

	public String getDiscount() {
		return this.discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getHisItemCode() {
		return this.hisItemCode;
	}

	public void setHisItemCode(String hisItemCode) {
		this.hisItemCode = hisItemCode;
	}

	public String getHisItemName() {
		return this.hisItemName;
	}

	public void setHisItemName(String hisItemName) {
		this.hisItemName = hisItemName;
	}

	public String getInspecName() {
		return this.inspecName;
	}

	public void setInspecName(String inspecName) {
		this.inspecName = inspecName;
	}

	public String getIsKn() {
		return this.isKn;
	}

	public void setIsKn(String isKn) {
		this.isKn = isKn;
	}

	public String getIsTakeout() {
		return this.isTakeout;
	}

	public void setIsTakeout(String isTakeout) {
		this.isTakeout = isTakeout;
	}

	public String getIsUse() {
		return this.isUse;
	}

	public void setIsUse(String isUse) {
		this.isUse = isUse;
	}

	public String getLabClassName() {
		return this.labClassName;
	}

	public void setLabClassName(String labClassName) {
		this.labClassName = labClassName;
	}

	public String getPackageFlag() {
		return this.packageFlag;
	}

	public void setPackageFlag(String packageFlag) {
		this.packageFlag = packageFlag;
	}

	public String getPeisItemCode() {
		return this.peisItemCode;
	}

	public void setPeisItemCode(String peisItemCode) {
		this.peisItemCode = peisItemCode;
	}

	public String getPeisItemName() {
		return this.peisItemName;
	}

	public void setPeisItemName(String peisItemName) {
		this.peisItemName = peisItemName;
	}

	public String getRequestionCode() {
		return this.requestionCode;
	}

	public void setRequestionCode(String requestionCode) {
		this.requestionCode = requestionCode;
	}

	public String getRequestionName() {
		return this.requestionName;
	}

	public void setRequestionName(String requestionName) {
		this.requestionName = requestionName;
	}

	public String getSampleName() {
		return this.sampleName;
	}

	public void setSampleName(String sampleName) {
		this.sampleName = sampleName;
	}

	public String getSubmissionTimeJz() {
		return this.submissionTimeJz;
	}

	public void setSubmissionTimeJz(String submissionTimeJz) {
		this.submissionTimeJz = submissionTimeJz;
	}

	public String getSubmissionTimeMz() {
		return this.submissionTimeMz;
	}

	public void setSubmissionTimeMz(String submissionTimeMz) {
		this.submissionTimeMz = submissionTimeMz;
	}

	public String getSubmissionTimeZy() {
		return this.submissionTimeZy;
	}

	public void setSubmissionTimeZy(String submissionTimeZy) {
		this.submissionTimeZy = submissionTimeZy;
	}

	public String getTakeReportTimeJz() {
		return this.takeReportTimeJz;
	}

	public void setTakeReportTimeJz(String takeReportTimeJz) {
		this.takeReportTimeJz = takeReportTimeJz;
	}

	public String getTakeReportTimeMz() {
		return this.takeReportTimeMz;
	}

	public void setTakeReportTimeMz(String takeReportTimeMz) {
		this.takeReportTimeMz = takeReportTimeMz;
	}

	public String getTakeReportTimeZy() {
		return this.takeReportTimeZy;
	}

	public void setTakeReportTimeZy(String takeReportTimeZy) {
		this.takeReportTimeZy = takeReportTimeZy;
	}

	public String getTakeReportWay() {
		return this.takeReportWay;
	}

	public void setTakeReportWay(String takeReportWay) {
		this.takeReportWay = takeReportWay;
	}

}