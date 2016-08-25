/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.flame.indian.modules.doctor.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.flame.indian.common.config.Global;
import com.flame.indian.common.persistence.Page;
import com.flame.indian.common.web.BaseController;
import com.flame.indian.common.utils.StringUtils;
import com.flame.indian.modules.doctor.entity.Doctor;
import com.flame.indian.modules.doctor.service.DoctorService;

/**
 * 单表生成Controller
 * @author wateryice
 * @version 2016-08-22
 */
@Controller
@RequestMapping(value = "${adminPath}/doctor/doctor")
public class DoctorController extends BaseController {

	@Autowired
	private DoctorService doctorService;
	
	@ModelAttribute
	public Doctor get(@RequestParam(required=false) String id) {
		Doctor entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = doctorService.get(id);
		}
		if (entity == null){
			entity = new Doctor();
		}
		return entity;
	}
	
	@RequiresPermissions("doctor:doctor:view")
	@RequestMapping(value = {"list", ""})
	public String list(Doctor doctor, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Doctor> page = doctorService.findPage(new Page<Doctor>(request, response), doctor); 
		model.addAttribute("page", page);
		return "modules/doctor/doctorList";
	}

	@RequiresPermissions("doctor:doctor:view")
	@RequestMapping(value = "form")
	public String form(Doctor doctor, Model model) {
		model.addAttribute("doctor", doctor);
		return "modules/doctor/doctorForm";
	}

	@RequiresPermissions("doctor:doctor:edit")
	@RequestMapping(value = "save")
	public String save(Doctor doctor, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, doctor)){
			return form(doctor, model);
		}
		doctorService.save(doctor);
		addMessage(redirectAttributes, "保存单表成功");
		return "redirect:"+Global.getAdminPath()+"/doctor/doctor/?repage";
	}
	
	@RequiresPermissions("doctor:doctor:edit")
	@RequestMapping(value = "delete")
	public String delete(Doctor doctor, RedirectAttributes redirectAttributes) {
		doctorService.delete(doctor);
		addMessage(redirectAttributes, "删除单表成功");
		return "redirect:"+Global.getAdminPath()+"/doctor/doctor/?repage";
	}

}