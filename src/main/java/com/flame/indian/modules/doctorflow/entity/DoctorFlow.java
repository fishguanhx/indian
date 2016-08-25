/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.flame.indian.modules.doctorflow.entity;

import org.hibernate.validator.constraints.Length;

import com.flame.indian.common.persistence.DataEntity;

/**
 * 医生信息流程Entity
 * @author wateryice
 * @version 2016-08-22
 */
public class DoctorFlow extends DataEntity<DoctorFlow> {
	
	private static final long serialVersionUID = 1L;
	private String procInsId;		// proc_ins_id
	private String dName;		// d_name
	private String dCode;		// d_code
	
	public DoctorFlow() {
		super();
	}

	public DoctorFlow(String id){
		super(id);
	}

	@Length(min=0, max=64, message="proc_ins_id长度必须介于 0 和 64 之间")
	public String getProcInsId() {
		return procInsId;
	}

	public void setProcInsId(String procInsId) {
		this.procInsId = procInsId;
	}
	
	@Length(min=0, max=64, message="d_name长度必须介于 0 和 64 之间")
	public String getDName() {
		return dName;
	}

	public void setDName(String dName) {
		this.dName = dName;
	}
	
	@Length(min=0, max=64, message="d_code长度必须介于 0 和 64 之间")
	public String getDCode() {
		return dCode;
	}

	public void setDCode(String dCode) {
		this.dCode = dCode;
	}
	
}