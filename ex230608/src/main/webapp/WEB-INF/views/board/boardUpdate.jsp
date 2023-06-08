<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>
<body>
	<form name="updateForm" action="boardUpdate" method="POST" onsubmit="return false">
		<div>
			<h3>게시글 수정</h3>
		</div>
		<table>
			<tr>
				<th>번호</th>
				<td><input type="number" name="bno" value="${board.bno}" readonly></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" value="${board.title}"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer" value="${board.writer}" readonly></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="contents">${board.contents}</textarea></td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td><input type="text" name="image" value="${board.image}"></td>
			</tr>
			<tr>
				<th>수정날짜</th>
				<td><input type="date" name="updatedate" value="${board.updatedate}"></td>
			</tr>
		</table>
		<button type="submit">수정</button>
		<button type="button" onclick="location.href='boardList'">취소</button>
	</form>
	<script>
		document.querySelector('button[type="submit"]').addEventListener('click', function(e) {
			let data = {
				'bno' : updateForm.bno.value,
				'title' : updateForm.title.value,
				'writer' : updateForm.writer.value,
				'contents' : updateForm.contents.value,
				'image' : updateForm.image.value,
				'updatedate' : updateForm.updatedate.value
			}
			
			fetch('boardUpdate', {
				method: 'post',
				headers: {
					'content-type' : 'application/json'
				},
				body: JSON.stringify(data)
			})
			.then(response => response.text()) // 응답 받은 것을 text형태로 파싱하는 부분
			.then(result => { 
					alert(result);
					location.href="boardList";
			})
			.catch(err => console.log(err))
		})
	</script>
</body>
</html>