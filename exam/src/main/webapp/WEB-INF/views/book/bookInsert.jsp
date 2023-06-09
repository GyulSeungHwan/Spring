<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>도서 등록</title>
</head>
<body>
	<center><h4>도서 등록</h4></center>
	<form name="insertBook" action="bookInsert" method="post">
		<table border="1">
			<tr>
				<td>도서번호<input name="bookNo" value="${bookNo}"></td>
			</tr>
			<tr>
				<td>도서명<input name="bookName"></td>
			</tr>
			<tr>
				<td>도서표지<input name="bookCoverimg"></td>
			</tr>
			<tr>
				<td>출판일자<input name="bookDate"></td>
			</tr>
			<tr>
				<td>금액<input name="bookPrice"></td>
			</tr>
			<tr>
				<td>출판사<input name="bookPublisher"></td>
			</tr>
			<tr>
				<td>도서소개<textarea name="bookInfo"></textarea></td>
			</tr>
		</table>
		<button type="submit">등록</button>
		<button type="button" onclick="location.href='bookList'">목록</button>
	</form>
	<script>
		document.querySelector('form[name="insertBook"]').addEventListener('submit', function(e) {
			e.preventDefault();
			
			let bookNo = document.getElementsByName('bookNo')[0];
			let bookName = document.getElementsByName('bookName')[0];
			let bookCoverimg = document.getElementsByName('bookCoverimg')[0];
			let bookDate = document.getElementsByName('bookDate')[0];
			let bookPrice = document.getElementsByName('bookPrice')[0];
			let bookPublisher = document.getElementsByName('bookPublisher')[0];
			let bookInfo = document.getElementsByName('bookInfo')[0];
			
			if(bookNo.value == '') {
				alert('도서번호가 입력되지 않았습니다.');
				bookNo.focus();
				return;
			}
			
			if(bookName.value == '') {
				alert('도서명이 입력되지 않았습니다.');
				bookName.focus();
				return;
			}
			
			if(bookCoverimg.value == '') {
				alert('도서표지가 입력되지 않았습니다.');
				bookCoverimg.focus();
				return;
			}
			
			if(bookDate.value == '') {
				alert('출판일지가 입력되지 않았습니다.');
				bookDate.focus();
				return;
			}
			
			if(bookPrice.value == '') {
				alert('금액이 입력되지 않았습니다.');
				bookPrice.focus();
				return;
			}
			
			if(bookPublisher.value == '') {
				alert('출판사가 입력되지 않았습니다.');
				bookPublisher.focus();
				return;
			}
			
			if(bookInfo.value == '') {
				alert('도서소개가 입력되지 않았습니다.');
				bookInfo.focus();
				return;
			}
			
			alert('도서등록이 완료 되었습니다.');
			insertBook.submit();
		})
	</script>
</body>
</html>