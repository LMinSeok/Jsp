<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
	// 현재 날짜 및 시간을 가져오는 함수
	function getCurrentDateTime() {
		var now = new Date();
		var year = now.getFullYear();
		var month = now.getMonth() + 1; // 월은 0부터 시작하므로 1을 더해줍니다.
		var day = now.getDate();
		var hour = now.getHours();
		var minute = now.getMinutes();
		var second = now.getSeconds();

		// 두 자리수로 포맷팅
		if (month < 10)
			month = '0' + month;
		if (day < 10)
			day = '0' + day;
		if (hour < 10)
			hour = '0' + hour;
		if (minute < 10)
			minute = '0' + minute;
		if (second < 10)
			second = '0' + second;

		// yyyy-MM-dd HH:mm:ss 형식으로 반환
		return year + '-' + month + '-' + day + ' ' + hour + ':' + minute + ':'
				+ second;
	}

	// 폼이 로드될 때 현재 날짜 및 시간을 입력
	window.onload = function() {
		document.getElementById('register_date').value = getCurrentDateTime();
	};

	// 주소 검색 함수
	function findAddress() {
		new daum.Postcode({
			oncomplete : function(data) {
				document.getElementById('postcode').value = data.zonecode;
				document.getElementById('address').value = data.address;
			}
		}).open();
	}
</script>
<link rel="stylesheet" type="text/css" href="css/shopping.css">
<title>회원가입</title>
</head>
<body>
	<div id="wrap" align="center">
		<h1>회원가입</h1>
		<form name="frm" method="post" action="UserServlet">
			<input type="hidden" name="command" value="register">
			<table>
				<tr>
					<th>아이디</th>
					<td><input type="text" name="id"> * 필수</td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="username"></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text" name="email"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="pass"> *</td>
				</tr>
				<tr>
					<th>우편번호</th>
					<td><input type="text" id="postcode" name="postcode" readonly>
						<input type="button" value="우편번호 검색" onclick="findAddress()">
					</td>
				</tr>
				<tr>
					<th>주소</th>
					<td><input type="text" id="address" name="address" readonly></td>
				</tr>
				<tr>
					<th>상세주소</th>
					<td><input type="text" id="addr2" name="addr2"></td>
				</tr>
				<tr style="display: none;">
					<th>가입일</th>
					<td><input type="text" id="register_date" name="register_date"
						readonly></td>
				</tr>
				<tr style="display: none;">
					<th>관리자 여부</th>
					<td><select name="is_admin">
							<option value="N">일반 회원</option>
							<option value="Y">관리자</option>
					</select></td>
				</tr>
			</table>
			<br> <br> <input type="submit" value="가입"> <input
				type="reset" value="다시 작성"> <input type="button" value="목록"
				onclick="location.href='UserServlet?command=user_list'">
		</form>
	</div>
</body>
</html>
