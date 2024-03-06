<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>정보 입력 폼</h2>
	<form method="post" action="additem.jsp">
		상품명 <input type="text" name="name" size="20"><br> 
		가 &nbsp격 <input type="text" name="price" size="20"><br> 
		설 &nbsp명 <input type="text" name="description"style="width: 600px; height: 200px; font-size: 20px;"><br>
		
		
		<input type="submit" value="전송"> 
		<input type="reset"	value="취소">

	</form>
</body>
</html>