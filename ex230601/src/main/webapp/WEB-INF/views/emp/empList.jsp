<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>사원조회</h2>
		<a href="empInsert">등록</a> <!-- get방식 -->
		<!-- ${empVO} -->
		<form action="empList">
			부서<input name="departmentId" value="${emp.departmentId}">
			fname<input name="firstName" value="${emp.firstName}">
			<button>검색</button>
			<button type="reset">초기화</button>
		</form>
		<table border="1">
			<tr>
				<th>firstName</th>
				<th>lastName</th>
				<th>email</th>
				<th>hireDate</th>
				<th>jobId</th>
				<th>departmentId</th>
				<th></th>
				<th></th>
			</tr>
			<c:forEach items="${empList}" var="emp">
				<tr>
					<td>${emp.firstName}</td>
					<td>${emp.lastName}</td>
					<td>${emp.email}</td>
					<td>${emp.hireDate}</td>
					<td>${emp.jobId}</td>
					<td>${emp.departmentId}</td>
					<td><a href="empUpdate?empId=${emp.employeeId}">수정</a></td>
					<td><a href="empDelete?empId=${emp.employeeId}">삭제</a></td>
				</tr>
			</c:forEach>
		</table>
</body>
</html>