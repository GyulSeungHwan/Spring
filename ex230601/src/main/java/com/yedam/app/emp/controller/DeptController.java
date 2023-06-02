package com.yedam.app.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.yedam.app.emp.mapper.DeptMapper;

@Controller
public class DeptController {
	
	@Autowired DeptMapper deptMapper;
	
	
	
}
