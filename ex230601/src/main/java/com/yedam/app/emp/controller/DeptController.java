package com.yedam.app.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yedam.app.emp.mapper.DeptMapper;
import com.yedam.app.emp.service.DeptVO;

@Controller
public class DeptController {
	
	@Autowired DeptMapper deptMapper;
	
	@GetMapping("deptList")
	public String deptList(Model model, @ModelAttribute("dept") DeptVO vo) {
		System.out.println(vo);
		model.addAttribute("deptList", deptMapper.selectList(vo));
		return "dept/deptList";
	}
	
	@GetMapping("deptInsert")
	public String deptInsertForm(Model model) {
		model.addAttribute("manager", deptMapper.selectManager());
		model.addAttribute("locations", deptMapper.selectLocation());
		return "dept/deptInsert";
	}
	
	@PostMapping("deptInsert")
	public String deptInsert(DeptVO vo) {
		deptMapper.insertDept(vo);
		return "redirect:deptList";
	}
	
	@GetMapping("deptDelete")
	public String deptDelete(@RequestParam int deptId) {
		deptMapper.deleteDept(deptId);
		return "redirect:deptList";
	}
	
	@GetMapping("deptUpdate")
	public String deptUpdateForm(Model model, int deptId) {
		model.addAttribute("dept", deptMapper.selectOne(deptId));
		model.addAttribute("manager", deptMapper.selectManager());
		model.addAttribute("locations", deptMapper.selectLocation());
		return "dept/deptUpdate";
	}
	
	@PostMapping("deptUpdate")
	public String deptUpdate(DeptVO vo) {
		deptMapper.updateDept(vo);
		return "redirect:deptList";
	}
}
