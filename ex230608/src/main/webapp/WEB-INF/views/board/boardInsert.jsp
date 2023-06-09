<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
</head>
<body>
	<form name="insertForm" action="boardInsert" method="POST">
		<div>
			<h3>게시글 정보</h3>
		</div>
		<table>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="contents"></textarea></td>
			</tr>
			<tr>
				<th>첨부이미지</th>
				<td><input type="text" name="image"></td>
			</tr>
		</table>
		<button type="submit">등록</button>
		<button type="button" onclick="location.href='boardList'">목록</button>
	</form>
	<script>
		document.querySelector('form[name="insertForm"]').addEventListener('submit', function(e) {
			// submit은 form에서 일어나는 것이기 때문에 form에 이벤트를 걸어준다
			e.preventDefault(); // 기존에 등록되어있는 기능을 막는다
			
			let title = document.getElementsByName('title')[0];
			let writer = document.getElementsByName('writer')[0];
			let contents = document.getElementsByName('contents')[0];
			
			if(title.value == '') {
				alert('제목이 입력되지 않았습니다.');
				title.focus(); // focus로 사용자가 의식할 수 있게 만든다
				return;
			}
			
			if(writer.value == '') {
				alert('작성자가 입력되지 않았습니다.');
				writer.focus();
				return;
			}
			
			if(contents.value == '') {
				alert('내용이 입력되지 않았습니다.');
				contents.focus();
				return;
			}
			// if as if가 아니라 개별로 조건문을 줘야한다
			
			insertForm.submit();
		})
	</script>
</body>
</html>