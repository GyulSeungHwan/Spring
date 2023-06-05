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
	<h3>사원수정</h3>
		<form action="empUpdate" method="post" name="frm">
			employeeId<input name="employeeId" readonly="readonly" value="${emp.employeeId}"><br>
			<!-- readonly는 값을 넘기지만 disabled는 값을 넘기지 않는다 -->
			*fname<input name="firstName" value="${emp.firstName}"><br>
			*lname<input name="lastName" value="${emp.lastName}"><br>
			*hiredate<input name="hireDate" value="${emp.hireDate}"><br>
			*email<input name="email" value="${emp.email}"><br>
			departmentId<c:forEach var="dept" items="${dept}">
							<input type="radio" name="departmentId"
									value="${dept.deptId}" 
									<c:if test="${dept.deptId == emp.departmentId}">checked</c:if> >
									${dept.deptName}
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
		<script>
			frm.jobId.value = "${emp.jobId}"
			// select 박스의 값을 선택되어진 상태로 만들어주기 위해서 넣었다
		</script>
</body>
</html>