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
	<h3>부서등록</h3>
		<form action="deptInsert" method="post">
			*departmentName<input name="departmentName"><br>
			*fname<c:forEach var="manager" items="${manager}">
					<input type="radio" name="managerId"
							value="${manager.EMPLOYEE_ID}">${manager.FIRST_NAME}
				  </c:forEach><br>
			*city<select name="locationId">
					<option value="">--선택--
					<c:forEach var="location" items="${locations}">
						<option value="${location.LOCATION_ID}">${location.CITY}
					</c:forEach>
				 </select><br>
			<button>저장</button>
		</form>
		<script>
			console.log('${manager}');
			console.log('${locations}');
		</script>
</body>
</html>