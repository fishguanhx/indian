/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.flame.indian.modules.doctor.entity;

import org.hibernate.validator.constraints.Length;

import com.flame.indian.common.persistence.DataEntity;

/**
 * 单表生成Entity
 * @author wateryice
 * @version 2016-08-22
 */
public class Doctor extends DataEntity<Doctor> {
	
	private static final long serialVersionUID = 1L;
	private String doctorCode;		// 医生代码
	private String docotorName;		// 医生姓名
	
	public Doctor() {
		super();
	}

	public Doctor(String id){
		super(id);
	}

	@Length(min=0, max=100, message="医生代码长度必须介于 0 和 100 之间")
	public String getDoctorCode() {
		return doctorCode;
	}

	public void setDoctorCode(String doctorCode) {
		this.doctorCode = doctorCode;
	}
	
	@Length(min=0, max=100, message="医生姓名长度必须介于 0 和 100 之间")
	public String getDocotorName() {
		return docotorName;
	}

	public void setDocotorName(String docotorName) {
		this.docotorName = docotorName;
	}
	
}