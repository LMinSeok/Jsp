<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String[] movieList = {"타이타닉2", "시네마 천국", "혹성 탈출", "킹콩" };
	pageContext.setAttribute("movieList2", movieList);
%>

<c:forEach items="${movieList2}" var="m">
	${m} <br>
</c:forEach>


</body>
</html>