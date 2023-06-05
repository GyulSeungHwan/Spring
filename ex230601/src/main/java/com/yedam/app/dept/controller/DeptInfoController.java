package com.yedam.app.dept.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.yedam.app.dept.service.DeptInfoVO;
import com.yedam.app.dept.service.DeptListVO;
import com.yedam.app.dept.service.DeptService;

@Controller
public class DeptInfoController {
	@Autowired
	DeptService deptService;
	
	// 경로 <-> 기능 (View)
	// 경로 + Method -> Unique
	
	// 조회 (데이터, 페이지) -> GET
	// 등록, 수정, 삭제 -> POST
	
	// 전체조회 - 페이지 : GET
//	@RequestMapping(value = "deptList", method = HttpMethod.POST)
	@GetMapping("deptList")
	public String getDeptAllList(@RequestParam(required = false) String msg, Model model, HttpServletRequest request) {
		model.addAttribute("deptList", deptService.getAllDept());
		
		System.out.println("redirect : " + msg);
		
		Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request); // ?는 Object와 다름없다
		if(flashMap != null) {
			System.out.println("department_id : " + flashMap.get("departmentId"));
		}
		
		return "dept2/list"; // 특정 jsp를 찾기위한 경로
	}
	
	// 단건조회 - 페이지 : GET
	@GetMapping("deptInfo")
	public String getDeptInfo(DeptInfoVO deptVO, Model model) {
		// 객체 형태로 받아들이는게 일반적이다
		DeptInfoVO findDept = deptService.getDeptInfo(deptVO);
		model.addAttribute("deptInfo", findDept);
		return "dept2/info";
	}
	
	// 등록 - 페이지 : GET
	@GetMapping("deptInsert")
	public String deptInsertForm() {
		return "dept2/insert";
	}
	
	// 등록 - 기능 : POST
	@PostMapping("deptInsert")
	public String deptInsert(DeptInfoVO deptVO, RedirectAttributes rtt) {
		deptService.insertDeptInfo(deptVO);
		rtt.addFlashAttribute("departmentId", deptVO.getDepartmentId());
//		return "redirect:deptList?departmentID=" + deptVO.getDepartmentId();
		rtt.addAttribute("msg", "test"); // ?msg=test
		return "redirect:deptList";
		// return "redirect:경로" or "forward:경로"
		// redirect - 재호출, 경로가 바뀐다, get 방식
		// forward - 서버 내부적으로 처리를 해서 보여준다(사용자에게 보여주지 않음)
		// RedirectAttributes
	}
	
	// 삭제 - 기능 : POST
	@PostMapping("deptDelete")
	public String deptDelete(DeptListVO list) {
		int result = deptService.deleteDeptList(list.getDeptList());
		return "redirect:deptList?msg=" + result;
	}
	
	// 수정 - 기능 : POST
//	@PostMapping("deptUpdate") // @RequestBody : JSON 포맷을 사용하는 경우에 사용 -> content-type : 'application/json'
	@ResponseBody // 응답하면 body에 필요한 데이터를 집어넣는 어노테이션(더 이상 받아들이는 타입이 String일 필요가 없다)
	public Map<String, Object> deptUpdate(@RequestBody List<DeptInfoVO> deptVO, RedirectAttributes rtt) {
		return deptService.updateDeptList(deptVO);
	}
	
//	public String deptUpdate(@RequestBody List<DeptInfoVO> deptVO, RedirectAttributes rtt) {
//		Map<String, Object> map = deptService.updateDeptList(deptVO);
//		rtt.addFlashAttribute("updateRes", map);
//		return "redirect:deptInfo?departmentId=" + deptVO.get(0).getDepartmentId();
//	}
	
	@PostMapping("deptUpdate") // @RequestBody : JSON 포맷을 사용하는 경우에 사용 -> content-type : 'application/json'
	@ResponseBody // 응답하면 body에 필요한 데이터를 집어넣는 어노테이션(더 이상 받아들이는 타입이 String일 필요가 없다)
	public String deptUpdateText(@RequestBody List<DeptInfoVO> deptVO, RedirectAttributes rtt) {
		Map<String, Object> map = deptService.updateDeptList(deptVO);
		return "success";
	}
}
