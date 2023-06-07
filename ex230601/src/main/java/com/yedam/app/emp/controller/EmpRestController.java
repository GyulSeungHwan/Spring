package com.yedam.app.emp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

@RestController
public class EmpRestController {
	@Autowired
	EmpMapper empMapper;
	
	// 전체조회
	@GetMapping("emps")
	public List<EmpVO> getEmpList() {
		EmpVO empVO = new EmpVO(); // 비어있는 값 보냈음
		return empMapper.selectList(empVO);
	}
	
	// 단건조회
	@GetMapping("emps/{employeeId}") // {employeeId}는 경로가 아니라 데이터를 요청하는 것이다
	public EmpVO getEmpInfo(@PathVariable(name="employeeId") int empId) { // @PathVariable만 경로에 있는 데이터를 불러올 수 있다
		return empMapper.selectOne(empId);
	}
	
//	@GetMapping("emps/{employeeId}")
//	public EmpVO getEmpInfo(@PathVariable int employeeId) {
//		return empMapper.selectOne(employeeId);
//	}
	
	// 등록
	@PostMapping("emps")
	public EmpVO insertEmpInfo(@RequestBody EmpVO empVO) { // 내부를 JSON 타입으로 보내달라는 것
		empMapper.insertEmp(empVO);
		return empVO;
	}
	
	// 수정
	@PutMapping("emps/{employeeId}")
	public EmpVO updateEmpInfo(@PathVariable String employeeId, @RequestBody EmpVO empVO) {
		empVO.setEmployeeId(employeeId);
		empMapper.updateEmp(empVO);
		return empVO;
	}
	
	// 삭제
//	@DeleteMapping("emps/{employeeId}")
//	public int deleteEmpInfo(@PathVariable int employeeId) {
//		empMapper.deleteEmp(employeeId);
//		return employeeId;
//	}
	
	@DeleteMapping("emps/{employeeId}") // 단순히 int 값을 불러오지 않고 더 자세하게 보고 싶을때 map을 사용해서 본다
	public Map<String, Object> deleteEmpInfo(@PathVariable int employeeId) {
		boolean success = false;
		int result = empMapper.deleteEmp(employeeId);
		if(result > 0) {
			success = true;
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("result", success);
		map.put("employeeId", employeeId);
		
		return map;
	}
}