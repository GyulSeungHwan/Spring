<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서 정보</title>
</head>
<body>
	<form name="frm" onsubmit="return false">
		<div>
			<label for="id">부서번호</label>
			<input type="number" id="id" name="departmentId" value="${deptInfo.departmentId}" readonly>
		</div>
		<div>
			<label for="name">부서이름</label>
			<input type="text" id="name" name="departmentName" value="${deptInfo.departmentName}">
		</div>
		<div>
			<label for="mId">매니저번호</label>
			<input type="number" id="mId" name="managerId" value="${deptInfo.managerId}">
		</div>
		<div>
			<label for="lId">지역번호</label>
			<input type="number" id="lId" name="locationId" value="${deptInfo.locationId}">
		</div>
		<button type="submit">수정</button>
		<button type="button">목록</button>
	</form>
	<script>
//		let result = "${updateRes}";
//		if(result != "" && result != null) {
//			result = JSON.parse(result);
//			let msg = `
//			결과 : ${result.result} \n 
//			성공 : ${result.success} \n
//			대상 : ${result.deptList[0]}
//			`;
//			alert(msg);
//		}
		document.querySelector('button[type="submit"]').addEventListener('click', function(e) {
			let data = [{
					'departmentId' : frm.departmentId.value,
					'departmentName' : frm.departmentName.value,
					'managerId' : frm.managerId.value,
					'locationId' : frm.locationId.value
			}]
			
			fetch('deptUpdate', {
				method: 'post',
				headers: {
					'content-type' : 'application/json' // json 타입으로 보낼때는 form 태그를 사용할 수가 없다
				},
				body: JSON.stringify(data)
			})
			.then(response => response.text())
			.then(data => console.log(data))
			.catch(err => console.log(err))
			// .then(response => console.log(response.body)) // form에 return false 넣고 어떻게 되는지 보려고 쓴 것
			/*
			.then(response => response.json())
			.then(result => { // result는 임의의 값
				if(result != "" && result != null) {
					result = JSON.parse(result);
					let msg = `
					결과 : ${result.result} \n 
					성공 : ${result.success} \n
					대상 : ${result.deptList[0]}
					`;
					alert(msg);
				}
			})
			.catch(err => console.log(err));
			*/
		})
	</script>
</body>
</html>