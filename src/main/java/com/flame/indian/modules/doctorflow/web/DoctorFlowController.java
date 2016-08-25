/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.flame.indian.modules.doctorflow.web;

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
import com.flame.indian.modules.doctorflow.entity.DoctorFlow;
import com.flame.indian.modules.doctorflow.service.DoctorFlowService;

/**
 * 医生信息流程Controller
 * @author wateryice
 * @version 2016-08-22
 */
@Controller
@RequestMapping(value = "${adminPath}/doctorflow/doctorFlow")
public class DoctorFlowController extends BaseController {

	@Autowired
	private DoctorFlowService doctorFlowService;
	
	@ModelAttribute
	public DoctorFlow get(@RequestParam(required=false) String id) {
		DoctorFlow entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = doctorFlowService.get(id);
		}
		if (entity == null){
			entity = new DoctorFlow();
		}
		return entity;
	}
	
	@RequiresPermissions("doctorflow:doctorFlow:view")
	@RequestMapping(value = {"list", ""})
	public String list(DoctorFlow doctorFlow, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<DoctorFlow> page = doctorFlowService.findPage(new Page<DoctorFlow>(request, response), doctorFlow); 
		model.addAttribute("page", page);
		return "modules/doctorflow/doctorFlowList";
	}

	@RequiresPermissions("doctorflow:doctorFlow:view")
	@RequestMapping(value = "form")
	public String form(DoctorFlow doctorFlow, Model model) {
		model.addAttribute("doctorFlow", doctorFlow);
		return "modules/doctorflow/doctorFlowForm";
	}

	@RequiresPermissions("doctorflow:doctorFlow:edit")
	@RequestMapping(value = "save")
	public String save(DoctorFlow doctorFlow, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, doctorFlow)){
			return form(doctorFlow, model);
		}
		doctorFlowService.save(doctorFlow);
		addMessage(redirectAttributes, "保存医生信息成功");
		return "redirect:"+Global.getAdminPath()+"/doctorflow/doctorFlow/?repage";
	}
	
	@RequiresPermissions("doctorflow:doctorFlow:edit")
	@RequestMapping(value = "delete")
	public String delete(DoctorFlow doctorFlow, RedirectAttributes redirectAttributes) {
		doctorFlowService.delete(doctorFlow);
		addMessage(redirectAttributes, "删除医生信息成功");
		return "redirect:"+Global.getAdminPath()+"/doctorflow/doctorFlow/?repage";
	}

}