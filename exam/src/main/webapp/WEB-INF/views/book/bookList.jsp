<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<title>도서 목록</title>
</head>
<body>
	<div style="margin: 20px auto; text-align: center;">
		<h4>도서 조회/수정</h4>	
	</div>
	<table border="1" class="table">
		<thead>
			<tr>
				<th>도서번호</th>
				<th>도서명</th>
				<th>표지</th>
				<th>출판일자</th>
				<th>금액</th>
				<th>출판사</th>
				<th>도서소개</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${bookList}" var="book">
				<tr>
					<td style="text-align: center;">${book.bookNo}</td>
					<td>${book.bookName}</td>
					<c:choose>
						<c:when test="${not empty book.bookCoverimg}">
							<td style="text-align: center;"><img style="width: 30px; height: 30px;" src='<c:url value="/resources/images/${book.bookCoverimg}" />'></td>
						</c:when>
					</c:choose>
					<td style="width: 100px; text-align: center;"><fmt:formatDate value="${book.bookDate}" pattern="yyyy/MM/dd" /></td>
					<td style="text-align: right; width: 100px;"><fmt:formatNumber value="${book.bookPrice}" /></td>
					<td style="text-align: center;">${book.bookPublisher}</td>
					<td>${book.bookInfo}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>