<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/shopping.css">
<link rel="stylesheet" type="text/css" href="css/mainPage.css">
<script type="text/javascript" src="script/product.js"></script>
<title>헤더</title>
<style>
#header {
	overflow: hidden; /* 자식 요소의 특정 요소가 부모 요소의 너비를 벗어나면, 넘치는 요소를 숨김 처리 */
	background-color: #f1f1f1; /* 배경색 설정 */
	padding: 20px; /* 내부 여백 설정 */
}

#header ul {
	list-style: none;
	padding: 0;
	margin: 0;
	float: right; /* 우측 정렬 */
}

#header ul li {
	display: inline;
	margin-right: 10px; /* 각 항목 사이의 간격 조정 */
	font-size: 14px; /* 폰트 크기 설정 */
}

#header .user-info {
	display: inline; /* 인라인 요소로 설정하여 다른 요소와 함께 표시 */
	font-size: 14px; /* 폰트 크기 설정 */
	color: #555; /* 글자색 설정 */
	margin-right: 20px; /* 오른쪽 여백 설정 */
}
</style>

</head>
<body>
	<div id="header">
		<ul>
			<c:choose>
				<c:when test="${empty loginUser}">
					<!-- 로그인되지 않은 경우 -->
					<li><a href="UserServlet?command=user_login_action">로그인</a></li>
					<li><a href="UserServlet?command=register_form">회원가입</a></li>
				</c:when>
				<c:otherwise>
					<!-- 로그인된 경우 -->
					<li><a href="UserServlet?command=logout_action">로그아웃</a></li>
			     		<c:if test="${loginUser.is_admin eq 'Y'}">
						<!-- 관리자 로그인 상태일 때 -->
						<li><a href="ProServlet?command=pro_write_form">상품등록</a></li>
						<li><a href="ProServlet?command=user_list">회원관리</a></li>
				    </c:if> 
					<c:if test="${loginUser.is_admin eq 'N'}">
						<!-- 일반 사용자 로그인 상태일 때 -->
						<li><a href="ProServlet?command=order_list">장바구니</a></li>
						
						<li><a href="reviews.jsp">리뷰</a></li>
						<li><a href="qna.jsp">Q&A</a></li>
						<li><a href="UserServlet?command=mypage&id=${loginUser.id}">마이페이지</a></li>
					</c:if>
					<!-- 사용자 정보 표시 -->
					<li class="user-info">${loginUser.username}님</li>
				</c:otherwise>
			</c:choose>

		</ul>
	</div>
</body>
</html>
