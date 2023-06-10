<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style>
th {
	border: 1px solid black;
	text-align: center;
}
td {
	border: 1px solid black;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="margin: 20px auto; text-align: center;">
		<h4>도서별 대여매출현황</h4>
	</div>
	<table border="1" class="table">
		<thead>
			<tr>
				<th>도서번호</th>
				<th>도서명</th>
				<th>대여총계</th>
				<th>대여횟수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${rentList}" var="rent">
				<tr>
					<td style="text-align: center;">${rent.bookNo}</td>
					<td>${rent.bookName}</td>
					<td style="text-align: right;">${rent.price}</td>
					<td style="text-align: right;">${rent.book}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>