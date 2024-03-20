<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>주문 리스트</h3>
	<p>
	<h4>주문 전체 Count: ${totCnt }</h4>
	<table class="table table-hover table-primary">
		<tr>
			<th>주문일자</th>
			<th>거래처명</th>
			<th>주문내용</th>
			<th>접수사원</th>
		</tr>

		<c:forEach var="order" items="${orderList }">
			<tr>
				<td>${order.order_date}</td>
				<td><a
					href='orderContent.do?custcode=${order.custcode }&order_date=${order.order_date}'>${order.custname }</a></td>
				<td>${order.order_desc }</td>
				<td>${order.sawon_name }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>