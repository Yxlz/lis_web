package com.cdxt.lisweb.entity.examine;
/**
 * @author : liushijun
 * @date 创建时间：2018年6月21日 
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: //TODO
 */
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
/**
 * @author : liushijun
 * @date 创建时间：2018年6月23日 
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: 用于存储LIS_INSPEC_DEV_INFO对象
 */
@Entity
@Table(name="LIS_INSPEC_DEV_INFO")
@NamedQuery(name="LisInspecDevInfo.findAll", query="SELECT l FROM LisInspecDevInfo l")
public class LisInspecDevInfo implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="DEV_NAME") 
	private String devName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDevName() {
		return devName;
	}

	public void setDevName(String devName) {
		this.devName = devName;
	}

	public LisInspecDevInfo(Long id, String devName) {
		this.id = id;
		this.devName = devName;
	}

	public LisInspecDevInfo() {
		// TODO Auto-generated constructor stub
	}
	
	
}
