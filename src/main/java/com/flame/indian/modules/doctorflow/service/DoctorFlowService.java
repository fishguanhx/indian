/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.flame.indian.modules.doctorflow.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flame.indian.common.persistence.Page;
import com.flame.indian.common.service.CrudService;
import com.flame.indian.modules.doctorflow.entity.DoctorFlow;
import com.flame.indian.modules.doctorflow.dao.DoctorFlowDao;

/**
 * 医生信息流程Service
 * @author wateryice
 * @version 2016-08-22
 */
@Service
@Transactional(readOnly = true)
public class DoctorFlowService extends CrudService<DoctorFlowDao, DoctorFlow> {

	public DoctorFlow get(String id) {
		return super.get(id);
	}
	
	public List<DoctorFlow> findList(DoctorFlow doctorFlow) {
		return super.findList(doctorFlow);
	}
	
	public Page<DoctorFlow> findPage(Page<DoctorFlow> page, DoctorFlow doctorFlow) {
		return super.findPage(page, doctorFlow);
	}
	
	@Transactional(readOnly = false)
	public void save(DoctorFlow doctorFlow) {
		super.save(doctorFlow);
	}
	
	@Transactional(readOnly = false)
	public void delete(DoctorFlow doctorFlow) {
		super.delete(doctorFlow);
	}
	
}