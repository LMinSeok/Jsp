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
	<h2>주문 거래처 상세내역</h2>
	<table class="table table-hover table-primary">
		<tr>
			<td>주문일자</td>
			<td>${order1.order_date }</td>
		</tr>

		<tr>
			<td>거래처</td>
			<td>${order1.custcode }${order1.custname }</td>
		</tr>

		<tr>
			<td>주문요청내용</td>
			<td>${order1.order_desc }</td>
		</tr>

		<tr>
			<td>접수사원</td>
			<td>${order1.sabun}${order1.sawon_name }</td>
		</tr>

		<tr>
			<td>접수상태</td>
			<td>${order1.order_status }</td>
		</tr>

		<tr>
			<td colspan="2"><c:if test="${order1.order_status=='0'}">
					<input type="button" value="거래처제품추가"
						onclick="location.href='orderUpdateForm.do?custcode=${order1.custcode}&order_date=${order1.order_date }'">
					<input type="button" value="거래처삭제"
						onclick="location.href='orderDeleteForm.do?custcode=${order1.custcode}&order_date=${order1.order_date }'">
				</c:if> <input type="button" value="거래처목록"
				onclick="location.href='orderList.do'"></td>
		</tr>
	</table>
</body>
</html>