package com.cdxt.lisweb.entity.req;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the LIS_REQUESTION_RECEIVE database table.
 * 
 */
@Entity
@Table(name="LIS_REQUESTION_RECEIVE")
@NamedQuery(name="LisRequestionReceive.findAll", query="SELECT l FROM LisRequestionReceive l")
public class LisRequestionReceive implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String address;

	private String barcode;

	@Column(name="BARCODE_REMARK")
	private String barcodeRemark;

	@Temporal(TemporalType.DATE)
	private Date birthday;

	@Column(name="DEV_CODE_ID")
	private String devCodeId;

	@Column(name="DM2_MESSAGE")
	private String dm2Message;

	@Column(name="DOC_COLLECT")
	private String docCollect;

	@Column(name="DOC_RECEIVE")
	private String docReceive;

	@Column(name="DOC_REQUEST")
	private String docRequest;

	private String emergency;

	@Column(name="EXECUTE_SECTION")
	private String executeSection;

	@Column(name="HOSPITAL_ID")
	private String hospitalId;

	@Column(name="HOSPITAL_NAME")
	private String hospitalName;

	@Column(name="ID_CARD_NUM")
	private String idCardNum;

	@Column(name="INSPEC_NAME")
	private String inspecName;

	@Column(name="P_AGE")
	private String pAge;

	@Column(name="P_BEDNO")
	private String pBedno;

	@Column(name="P_DIAGNOSIS")
	private String pDiagnosis;

	@Column(name="P_ID_TYPE")
	private String pIdType;

	@Column(name="P_NAME")
	private String pName;

	@Column(name="P_SECTION")
	private String pSection;

	@Column(name="P_SEX")
	private String pSex;

	@Column(name="P_TYPE")
	private String pType;

	@Column(name="PERSON_INFO_ID")
	private String personInfoId;

	@Column(name="PHONE_NUM")
	private String phoneNum;

	private String pid;

	@Column(name="RECEIVE_DEPT_CODE")
	private String receiveDeptCode;

	@Column(name="RECEIVE_SECTION")
	private String receiveSection;

	private String refuse;

	@Temporal(TemporalType.DATE)
	@Column(name="REFUSE_CONFIRM_TIME")
	private Date refuseConfirmTime;

	@Column(name="REFUSE_CONFIRM_USER_NAME")
	private String refuseConfirmUserName;

	@Column(name="REFUSE_CONFIRM_USER_SECTION")
	private String refuseConfirmUserSection;

	@Column(name="REFUSE_REASON")
	private String refuseReason;

	@Column(name="REQUEST_ITEM_NAME")
	private String requestItemName;

	@Column(name="REQUEST_ITEM_NO")
	private String requestItemNo;

	@Column(name="REQUEST_NO")
	private String requestNo;

	private String sample;

	@Column(name="SAMPLE_NAME")
	private String sampleName;

	@Column(name="SECOND_DOC_RECEIVE")
	private String secondDocReceive;

	@Column(name="SECOND_RECEIVE_DEPT_CODE")
	private String secondReceiveDeptCode;

	@Column(name="SECOND_RECEIVE_SECTION")
	private String secondReceiveSection;

	@Temporal(TemporalType.DATE)
	@Column(name="SECOND_TIME_RECEIVE")
	private Date secondTimeReceive;

	@Column(name="SECTION_ID")
	private String sectionId;

	@Column(name="SEND_MESSAGE")
	private String sendMessage;

	@Column(name="SOURCEFROM_SECTION")
	private String sourcefromSection;

	@Column(name="STATUS_FLAG")
	private String statusFlag;

	@Temporal(TemporalType.DATE)
	@Column(name="TIME_AWAY")
	private Date timeAway;

	@Temporal(TemporalType.DATE)
	@Column(name="TIME_COLLECT")
	private Date timeCollect;

	@Temporal(TemporalType.DATE)
	@Column(name="TIME_COMMITE")
	private Date timeCommite;

	@Temporal(TemporalType.DATE)
	@Column(name="TIME_DOCHECK")
	private Date timeDocheck;

	@Temporal(TemporalType.DATE)
	@Column(name="TIME_ONPROCESS")
	private Date timeOnprocess;

	@Temporal(TemporalType.DATE)
	@Column(name="TIME_PRINT")
	private Date timePrint;

	@Temporal(TemporalType.DATE)
	@Column(name="TIME_RECEIVE")
	private Date timeReceive;

	@Temporal(TemporalType.DATE)
	@Column(name="TIME_REQUEST")
	private Date timeRequest;

	@Column(name="TOTAL_CHARGE")
	private BigDecimal totalCharge;

	private String xgcpinfoid;

	public LisRequestionReceive() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBarcode() {
		return this.barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getBarcodeRemark() {
		return this.barcodeRemark;
	}

	public void setBarcodeRemark(String barcodeRemark) {
		this.barcodeRemark = barcodeRemark;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getDevCodeId() {
		return this.devCodeId;
	}

	public void setDevCodeId(String devCodeId) {
		this.devCodeId = devCodeId;
	}

	public String getDm2Message() {
		return this.dm2Message;
	}

	public void setDm2Message(String dm2Message) {
		this.dm2Message = dm2Message;
	}

	public String getDocCollect() {
		return this.docCollect;
	}

	public void setDocCollect(String docCollect) {
		this.docCollect = docCollect;
	}

	public String getDocReceive() {
		return this.docReceive;
	}

	public void setDocReceive(String docReceive) {
		this.docReceive = docReceive;
	}

	public String getDocRequest() {
		return this.docRequest;
	}

	public void setDocRequest(String docRequest) {
		this.docRequest = docRequest;
	}

	public String getEmergency() {
		return this.emergency;
	}

	public void setEmergency(String emergency) {
		this.emergency = emergency;
	}

	public String getExecuteSection() {
		return this.executeSection;
	}

	public void setExecuteSection(String executeSection) {
		this.executeSection = executeSection;
	}

	public String getHospitalId() {
		return this.hospitalId;
	}

	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getHospitalName() {
		return this.hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getIdCardNum() {
		return this.idCardNum;
	}

	public void setIdCardNum(String idCardNum) {
		this.idCardNum = idCardNum;
	}

	public String getInspecName() {
		return this.inspecName;
	}

	public void setInspecName(String inspecName) {
		this.inspecName = inspecName;
	}

	public String getPAge() {
		return this.pAge;
	}

	public void setPAge(String pAge) {
		this.pAge = pAge;
	}

	public String getPBedno() {
		return this.pBedno;
	}

	public void setPBedno(String pBedno) {
		this.pBedno = pBedno;
	}

	public String getPDiagnosis() {
		return this.pDiagnosis;
	}

	public void setPDiagnosis(String pDiagnosis) {
		this.pDiagnosis = pDiagnosis;
	}

	public String getPIdType() {
		return this.pIdType;
	}

	public void setPIdType(String pIdType) {
		this.pIdType = pIdType;
	}

	public String getPName() {
		return this.pName;
	}

	public void setPName(String pName) {
		this.pName = pName;
	}

	public String getPSection() {
		return this.pSection;
	}

	public void setPSection(String pSection) {
		this.pSection = pSection;
	}

	public String getPSex() {
		return this.pSex;
	}

	public void setPSex(String pSex) {
		this.pSex = pSex;
	}

	public String getPType() {
		return this.pType;
	}

	public void setPType(String pType) {
		this.pType = pType;
	}

	public String getPersonInfoId() {
		return this.personInfoId;
	}

	public void setPersonInfoId(String personInfoId) {
		this.personInfoId = personInfoId;
	}

	public String getPhoneNum() {
		return this.phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getPid() {
		return this.pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getReceiveDeptCode() {
		return this.receiveDeptCode;
	}

	public void setReceiveDeptCode(String receiveDeptCode) {
		this.receiveDeptCode = receiveDeptCode;
	}

	public String getReceiveSection() {
		return this.receiveSection;
	}

	public void setReceiveSection(String receiveSection) {
		this.receiveSection = receiveSection;
	}

	public String getRefuse() {
		return this.refuse;
	}

	public void setRefuse(String refuse) {
		this.refuse = refuse;
	}

	public Date getRefuseConfirmTime() {
		return this.refuseConfirmTime;
	}

	public void setRefuseConfirmTime(Date refuseConfirmTime) {
		this.refuseConfirmTime = refuseConfirmTime;
	}

	public String getRefuseConfirmUserName() {
		return this.refuseConfirmUserName;
	}

	public void setRefuseConfirmUserName(String refuseConfirmUserName) {
		this.refuseConfirmUserName = refuseConfirmUserName;
	}

	public String getRefuseConfirmUserSection() {
		return this.refuseConfirmUserSection;
	}

	public void setRefuseConfirmUserSection(String refuseConfirmUserSection) {
		this.refuseConfirmUserSection = refuseConfirmUserSection;
	}

	public String getRefuseReason() {
		return this.refuseReason;
	}

	public void setRefuseReason(String refuseReason) {
		this.refuseReason = refuseReason;
	}

	public String getRequestItemName() {
		return this.requestItemName;
	}

	public void setRequestItemName(String requestItemName) {
		this.requestItemName = requestItemName;
	}

	public String getRequestItemNo() {
		return this.requestItemNo;
	}

	public void setRequestItemNo(String requestItemNo) {
		this.requestItemNo = requestItemNo;
	}

	public String getRequestNo() {
		return this.requestNo;
	}

	public void setRequestNo(String requestNo) {
		this.requestNo = requestNo;
	}

	public String getSample() {
		return this.sample;
	}

	public void setSample(String sample) {
		this.sample = sample;
	}

	public String getSampleName() {
		return this.sampleName;
	}

	public void setSampleName(String sampleName) {
		this.sampleName = sampleName;
	}

	public String getSecondDocReceive() {
		return this.secondDocReceive;
	}

	public void setSecondDocReceive(String secondDocReceive) {
		this.secondDocReceive = secondDocReceive;
	}

	public String getSecondReceiveDeptCode() {
		return this.secondReceiveDeptCode;
	}

	public void setSecondReceiveDeptCode(String secondReceiveDeptCode) {
		this.secondReceiveDeptCode = secondReceiveDeptCode;
	}

	public String getSecondReceiveSection() {
		return this.secondReceiveSection;
	}

	public void setSecondReceiveSection(String secondReceiveSection) {
		this.secondReceiveSection = secondReceiveSection;
	}

	public Date getSecondTimeReceive() {
		return this.secondTimeReceive;
	}

	public void setSecondTimeReceive(Date secondTimeReceive) {
		this.secondTimeReceive = secondTimeReceive;
	}

	public String getSectionId() {
		return this.sectionId;
	}

	public void setSectionId(String sectionId) {
		this.sectionId = sectionId;
	}

	public String getSendMessage() {
		return this.sendMessage;
	}

	public void setSendMessage(String sendMessage) {
		this.sendMessage = sendMessage;
	}

	public String getSourcefromSection() {
		return this.sourcefromSection;
	}

	public void setSourcefromSection(String sourcefromSection) {
		this.sourcefromSection = sourcefromSection;
	}

	public String getStatusFlag() {
		return this.statusFlag;
	}

	public void setStatusFlag(String statusFlag) {
		this.statusFlag = statusFlag;
	}

	public Date getTimeAway() {
		return this.timeAway;
	}

	public void setTimeAway(Date timeAway) {
		this.timeAway = timeAway;
	}

	public Date getTimeCollect() {
		return this.timeCollect;
	}

	public void setTimeCollect(Date timeCollect) {
		this.timeCollect = timeCollect;
	}

	public Date getTimeCommite() {
		return this.timeCommite;
	}

	public void setTimeCommite(Date timeCommite) {
		this.timeCommite = timeCommite;
	}

	public Date getTimeDocheck() {
		return this.timeDocheck;
	}

	public void setTimeDocheck(Date timeDocheck) {
		this.timeDocheck = timeDocheck;
	}

	public Date getTimeOnprocess() {
		return this.timeOnprocess;
	}

	public void setTimeOnprocess(Date timeOnprocess) {
		this.timeOnprocess = timeOnprocess;
	}

	public Date getTimePrint() {
		return this.timePrint;
	}

	public void setTimePrint(Date timePrint) {
		this.timePrint = timePrint;
	}

	public Date getTimeReceive() {
		return this.timeReceive;
	}

	public void setTimeReceive(Date timeReceive) {
		this.timeReceive = timeReceive;
	}

	public Date getTimeRequest() {
		return this.timeRequest;
	}

	public void setTimeRequest(Date timeRequest) {
		this.timeRequest = timeRequest;
	}

	public BigDecimal getTotalCharge() {
		return this.totalCharge;
	}

	public void setTotalCharge(BigDecimal totalCharge) {
		this.totalCharge = totalCharge;
	}

	public String getXgcpinfoid() {
		return this.xgcpinfoid;
	}

	public void setXgcpinfoid(String xgcpinfoid) {
		this.xgcpinfoid = xgcpinfoid;
	}

}