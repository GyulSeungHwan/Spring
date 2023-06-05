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
	<h2>부서조회</h2>
		<a href="deptInsert">등록</a>
		<form action="deptList">
			부서<input name="departmentName" value="${dept.departmentName}">
			<button>검색</button>
			<button type="reset">초기화</button>
		</form>
		<table border="1">
			<tr>
				<th>departmentName</th>
				<th>managerId</th>
				<th>locationId</th>
			</tr>
			<c:forEach items="${deptList}" var="dept">
				<tr>
					<td>${dept.departmentName}</td>
					<td>${dept.managerId}</td>
					<td>${dept.locationId}</td>
					<td><a href="deptUpdate?deptId=${dept.departmentId}">수정</a></td>
					<td><a href="deptDelete?deptId=${dept.departmentId}">삭제</a></td>
				</tr>
			</c:forEach>
		</table>
</body>
</html>