/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.flame.indian.modules.doctor.dao;

import com.flame.indian.common.persistence.CrudDao;
import com.flame.indian.common.persistence.annotation.MyBatisDao;
import com.flame.indian.modules.doctor.entity.Doctor;

/**
 * 单表生成DAO接口
 * @author wateryice
 * @version 2016-08-22
 */
@MyBatisDao
public interface DoctorDao extends CrudDao<Doctor> {
	
}