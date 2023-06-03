<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>부서수정</h3>
		<form action="deptUpdate" method="post" name="frm">
			departmentId<input name="departmentId" readonly="readonly" value="${dept.departmentId}"><br>
			*departmentName<input name="departmentName" value="${dept.departmentName}"><br>
			*fname<c:forEach var="manager" items="${manager}">
				 	<input type="radio" name="managerId"
				 			value="${manager.EMPLOYEE_ID}"
				 			<c:if test="${manager.EMPLOYEE_ID == dept.managerId}">checked</c:if> >
				 			${manager.FIRST_NAME}
				 </c:forEach><br>
			*location<select name="locationId">
						<option value="">--선택--
						<c:forEach var="location" items="${locations}">
							<option value="${location.LOCATION_ID}">${location.CITY}
						</c:forEach>
					</select><br>
			<button>저장</button>
		</form>
		<script>
			frm.locationId.value = "${dept.locationId}"
			console.log('${manager}');
			console.log('${locations}');
		</script>
</body>
</html>