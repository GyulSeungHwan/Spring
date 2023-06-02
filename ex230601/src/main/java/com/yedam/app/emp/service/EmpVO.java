package com.yedam.app.emp.service;

import lombok.Data;

@Data
public class EmpVO {
	String employeeId;
	String firstName;
	String lastName;
	String email;
	String hireDate;
	String jobId;
	String departmentId;
	String orderColumn;
	
	String[] getDeptArr() {
		return departmentId.split(",");
	}
	// 필요할 때마다 새로 만들어내야 하기때문에 bean을 만들지 않는다
}
