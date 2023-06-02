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
	<h3>사원등록</h3>
		<form action="empInsert" method="post">
			*fname<input name="firstName"><br>
			*lname<input name="lastName"><br>
			*hiredate<input name="hireDate"><br>
			*email<input name="email"><br>
			departmentId<c:forEach var="dept" items="${dept}">
							<input type="radio" name="departmentId"
									value="${dept.deptId}">${dept.deptName}
						</c:forEach><br>
			jobId<select name="jobId">
					<option value="">--선택--
					<c:forEach var="job" items="${jobs}">
						<option value="${job.jobId}">${job.jobTitle}
						<!-- 오라클에서 컬럼의 이름이 대문자로 뜨기때문에 대문자로 적어줘야한다 -->
						<!-- alias를 mapper.xml에 적어주면 alias를 적으면 된다 -->
					</c:forEach>
				</select><br>
			<button>저장</button>
		</form>
</body>
</html>