<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/member.js"></script>
</head>
<body>
	<h2 align="center">아이디 중복 체크</h2>
	<form action="idCheck.do" method="get" name="frm">
		아이디<input type="text" name="userid" value=${userid }> <input
			type="submit" value="중복 체크"> <br>
		<c:if test="${result == 1 }">
			<script type="text/javascript">
				opener.document.frm.userid.value = "";
			</script>
			<div style="">${userid }는이미사용중인아이디입니다.</div>
		</c:if>
		<c:if test="${result == -1 }">
			<div style="color: red">${userid }는사용가능한아이디입니다.</div>
			<input type="button" value="사용" class="cancel" onclick="idok()">
		</c:if>
	</form>
</body>
</html>