<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 목록</title>
</head>
<body>
	<h1>주문 목록</h1>
	<table border="1">
		<tr>
			<th>구매 번호</th>
			<th>구매 상품</th>
			<th>구매자 이름</th>
			<th>주문 일자</th>
			<th>상품 가격</th>
			<!-- 다른 필드들의 헤더 추가 -->
		</tr>
		<c:forEach var="order" items="${orders}">
			<tr>
				<td>${order.orderId}</td>
				<td>${order.customerName}</td>
				<!-- 다른 필드들의 값을 여기에 추가 -->
			</tr>
		</c:forEach>
	</table>
</body>
</html>