/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.flame.indian.modules.doctor.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flame.indian.common.persistence.Page;
import com.flame.indian.common.service.CrudService;
import com.flame.indian.modules.doctor.entity.Doctor;
import com.flame.indian.modules.doctor.dao.DoctorDao;

/**
 * 单表生成Service
 * @author wateryice
 * @version 2016-08-22
 */
@Service
@Transactional(readOnly = true)
public class DoctorService extends CrudService<DoctorDao, Doctor> {

	public Doctor get(String id) {
		return super.get(id);
	}
	
	public List<Doctor> findList(Doctor doctor) {
		return super.findList(doctor);
	}
	
	public Page<Doctor> findPage(Page<Doctor> page, Doctor doctor) {
		return super.findPage(page, doctor);
	}
	
	@Transactional(readOnly = false)
	public void save(Doctor doctor) {
		super.save(doctor);
	}
	
	@Transactional(readOnly = false)
	public void delete(Doctor doctor) {
		super.delete(doctor);
	}
	
}