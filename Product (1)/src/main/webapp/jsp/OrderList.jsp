<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/shopping.css">
<script type="text/javascript" src="script/order.js"></script>
<title>장바구니</title>
</head>
<body>
	<form action="OrderListServlet" method="post">
		<input type="hidden" name="command" value="order_delete">
			 <input type="hidden" name="userid" value="${order.orderId }">
		<div id="wrap" align="center">
			<h1>장바구니</h1>
			<table class="list">
				<tr>
					<th>구분</th>
					<th>구매자 아이디</th>
					<th>구매자 이름</th>
					<th>구매 상품</th>
					<th>주문 일자</th>
					<th>상품 가격</th>
				</tr>
				<c:forEach var="order" items="${orderList}">
					<tr class="record">

						<td><input type="checkbox" name="selectedOrders"value="${order.orderId}">
						 <input type="hidden"	name="orderId" value="${order.orderId }" /></td>
						<td>${order.orderId}</td>
						<td>${order.customerName}</td>
						<td>${order.product}</td>
						<td><fmt:formatDate value="${order.orderDate}"
								pattern="yyyy-MM-dd" /></td>
						<td>${order.price }</td>
					</tr>
				</c:forEach>
			</table>
			<input type="submit" value="상품삭제" onclick="return confirmDelete()">


			<input type="button" value="상품 결제" onclick="location.href='OrderListServlet?command=order_pay1&selectedOrders=${selectedOrders}'">

		</div>
	</form>


</body>
</html>