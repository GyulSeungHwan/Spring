package com.yedam.app.emp.service;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor // Builder가 들어가면 들어가줘야한다
@AllArgsConstructor // Builder가 들어가면 들어가줘야한다
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmpVO {
	private int employeeId;
	private String firstName;
	private String lastName;
	@JsonIgnore
	private String email;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date hireDate;
	private String jobId;
//	@JsonProperty("sal")
	private BigDecimal salary;
	private int departmentId;
}
