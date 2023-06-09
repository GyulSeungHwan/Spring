<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<style>
table {
	margin-left:auto;
	margin-right:auto;
}
</style>
<meta charset="UTF-8">
<title>도서 목록</title>
</head>
<body>
	<center><h4>도서 조회/수정</h4></center>
	<table border="1">
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
					<td>${book.bookNo}</td>
					<td>${book.bookName}</td>
					<c:choose>
						<c:when test="${not empty book.bookCoverimg}">
							<td><img src='<c:url value="/resources/images/${book.bookCoverimg}" />'></td>
						</c:when>
					</c:choose>
					<td><fmt:formatDate value="${book.bookDate}" pattern="yyyy/MM/dd" /></td>
					<td>${book.bookPrice}</td>
					<td>${book.bookPublisher}</td>
					<td>${book.bookInfo}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>