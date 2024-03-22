<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/shopping.css">
<title>Insert title here</title>
</head>
<body>
	<div id="wrap" align="center">
		<h1>장바구니</h1>
		<table class="list">

			<tr>
				<th>구매자 아이디</th>
				<th>구매자 이름</th>
				<th>구매 상품</th>
				<th>주문 일자</th>
				<th>상품 가격</th>
				<th>총 금액</th>
			</tr>
			<c:forEach var="order" items="${orderList}">
				<tr class="record">
					<td>${order.orderId}</td>
					<td>${order.customerName}</td>
					<td>${order.product}</td>
					<td><fmt:formatDate value="${order.orderDate }"
							pattern="yyyy-MM-dd" /></td>
					<td>${order.price }</td>
					<td>${order.totalamount }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>