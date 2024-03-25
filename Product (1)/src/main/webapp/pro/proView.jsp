<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/shopping.css">
<script type="text/javascript" src="script/product.js"></script>

<title>Insert title here</title>
</head>
<body>
	<div id="wrap" align="center">
		<h1>게시글 상세보기</h1>
		<table>
			<tr>
				<th>상 품 명</th>
				<td>${pro.pname}</td>

			</tr>
			<tr>
				<th>내 용</th>
				<td>${pro.content}</td>
			</tr>
			<tr>
				<th>가 격</th>
				<td>${pro.price}</td>
			</tr>
			<tr>
				<th>수 량</th>
				<td>${pro.stock }</td>
			</tr>
			<tr>
				<th>사 진</th>
				<td><img
					src="${pageContext.request.contextPath}/upload/${pro.img}"
					alt="상품 이미지"></td>
		</table>
		<br> <br>
		<c:choose>
			<c:when test="${empty loginUser}">
				<!-- 비회원인 경우 -->
				<input type="button" value="로그인"
					onclick="location.href='UserServlet?command=user_login_action'">
				<input type="button" value="회원가입"
					onclick="location.href='UserServlet?command=register_form'">
			</c:when>
			<c:otherwise>
				<!-- 회원인 경우 -->
				<c:choose>
					<c:when test="${loginUser.is_admin eq 'Y'}">
						<!-- 관리자인 경우 -->
						<input type="button" value="상품 수정"
							onclick="editProduct(${pro.pid})">
						<input type="button" value="상품 삭제"
							onclick="confirmDelete(${pro.pid})">
					</c:when>
					<c:otherwise>
						<!-- 일반 사용자인 경우 -->
						<input type="button" value="바로 구매하기">
						<input type="button" value="장바구니">
					</c:otherwise>
				</c:choose>
			</c:otherwise>
		</c:choose>
		<!-- 공통 버튼 -->
		<input type="button" value="상품 리스트"
			onclick="location.href='ProServlet?command=pro_list'">

		<!-- 공통 버튼 -->
		<input type="button" value="상품 리스트"
			onclick="location.href='ProServlet?command=pro_list'">
	</div>
</body>
</html>