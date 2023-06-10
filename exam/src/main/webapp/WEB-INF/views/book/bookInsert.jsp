<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
th {
	text-align: center;
	width: 100px;
}
input {
	width: 200px;
}
</style>
<meta charset="UTF-8">
<title>도서 등록</title>
</head>
<body>
	<div style="margin: 20px auto; text-align: center;">
		<h4>도서 등록</h4>
	</div>
	<form name="insertBook" action="bookInsert" method="post" onsubmit="return false;">
		<table border="1" class="table">
			<tr>
				<th>도서번호</th>
				<td><input name="bookNo" value="${bookNo}"></td>
			</tr>
			<tr>
				<th>도서명</th>
				<td><input name="bookName"></td>
			</tr>
			<tr>
				<th>도서표지</th>
				<td><input name="bookCoverimg"></td>
			</tr>
			<tr>
				<th>출판일자</th>
				<td><input name="bookDate"></td>
			</tr>
			<tr>
				<th>금액</th>
				<td><input name="bookPrice"></td>
			</tr>
			<tr>
				<th>출판사</th>
				<td><input name="bookPublisher"></td>
			</tr>
			<tr>
				<th>도서소개</th>
				<td><textarea name="bookInfo" cols="50" rows="3"></textarea></td>
			</tr>
		</table>
		<div style="text-align: center;">
			<button type="submit">등록</button>
			<button type="button" onclick="location.href='bookList'">목록</button>
		</div>
	</form>
	<script>
		document.querySelector('form[name="insertBook"]').addEventListener('submit', function(e) {
			e.preventDefault();
			
//			let bookNo = document.getElementsByName('bookNo')[0];
			let bookName = document.getElementsByName('bookName')[0];
//			let bookCoverimg = document.getElementsByName('bookCoverimg')[0];
//			let bookDate = document.getElementsByName('bookDate')[0];
//			let bookPrice = document.getElementsByName('bookPrice')[0];
//			let bookPublisher = document.getElementsByName('bookPublisher')[0];
//			let bookInfo = document.getElementsByName('bookInfo')[0];
			
//			if(bookNo.value == '') {
//				alert('도서번호가 입력되지 않았습니다.');
//				bookNo.focus();
//				return;
//			}
			
			if(bookName.value == '') {
				alert('도서명이 입력되지 않았습니다.');
				bookName.focus();
				return;
			}
			
//			if(bookCoverimg.value == '') {
//				alert('도서표지가 입력되지 않았습니다.');
//				bookCoverimg.focus();
//				return;
//			}
			
//			if(bookDate.value == '') {
//				alert('출판일지가 입력되지 않았습니다.');
//				bookDate.focus();
//				return;
//			}
			
//			if(bookPrice.value == '') {
//				alert('금액이 입력되지 않았습니다.');
//				bookPrice.focus();
//				return;
//			}
			
//			if(bookPublisher.value == '') {
//				alert('출판사가 입력되지 않았습니다.');
//				bookPublisher.focus();
//				return;
//			}
			
//			if(bookInfo.value == '') {
//				alert('도서소개가 입력되지 않았습니다.');
//				bookInfo.focus();
//				return;
//			}
			
			alert('도서등록이 완료 되었습니다.');
			insertBook.submit();
		})
	</script>
</body>
</html>