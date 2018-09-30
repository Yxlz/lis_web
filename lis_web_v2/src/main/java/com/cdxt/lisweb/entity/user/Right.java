package com.cdxt.lisweb.entity.user;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 权限信息
 * 
 * @author hezheng
 */
@Entity
@Table(name = "LIS_WEB_INFO_QX_T")
public class Right implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 6179551127524962708L;

	private String id;

	private String rolePinyin;
	
	private String rightName;
	
	private String text;

	private String pinyin;

	private String remark;
	
	private String rightCode;
	private String parentCode;

	private String isLeaf;
	
	private String leaf = "true";

	private String leafNum;

	private String url;

	private String icon;

	private String sortNo;
	
	private String reporturl;

	public Right() {
	}
	
	public Right(String id,String rightName, String text, String pinyin, String remark,
			String rightCode, String parentCode, String isLeaf, String leaf,
			String leafNum, String url, String icon, String sortNo,String reporturl) {
		super();
		this.id = id;
		this.rightName = rightName;
		this.text = text;
		this.pinyin = pinyin;
		this.remark = remark;
		this.rightCode = rightCode;
		this.parentCode = parentCode;
		this.isLeaf = isLeaf;
		this.leaf = leaf;
		this.leafNum = leafNum;
		this.url = url;
		this.icon = icon;
		this.sortNo = sortNo;
		this.reporturl = reporturl;
	}



	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "S_QXID")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	@Transient
	public String getRolePinyin() {
		return rolePinyin;
	}

	public void setRolePinyin(String rolePinyin) {
		this.rolePinyin = rolePinyin;
	}

	@Column(name="S_QXMC")
	public String getRightName() {
		return rightName;
	}

	public void setRightName(String rightName) {
		this.rightName = rightName;
	}

	@Transient
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Transient
	public String getLeaf() {
		return leaf;
	}

	public void setLeaf(String leaf) {
		this.leaf = leaf;
	}

	@Column(name="S_QXPY")
	public String getPinyin() {
		return pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}

	@Column(name="S_QXBZ")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Column(name="S_NOWID")
	public String getRightCode() {
		return rightCode;
	}

	public void setRightCode(String rightCode) {
		this.rightCode = rightCode;
	}

	@Column(name="S_PARID")
	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	@Column(name="S_LEAF")
	public String getIsLeaf() {
		return isLeaf;
	}

	public void setIsLeaf(String isLeaf) {
		this.isLeaf = isLeaf;
	}

	@Column(name="S_SONMAXID")
	public String getLeafNum() {
		return leafNum;
	}

	public void setLeafNum(String leafNum) {
		this.leafNum = leafNum;
	}

	@Column(name="S_URL")
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name="S_IOC")
	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}


	@Column(name="S_PX")
	public String getSortNo() {
		return sortNo;
	}

	public void setSortNo(String sortNo) {
		this.sortNo = sortNo;
	}
	@Column(name="REPORT_URL")
	public String getReporturl() {
		return reporturl;
	}

	public void setReporturl(String reporturl) {
		this.reporturl = reporturl;
	}


}
