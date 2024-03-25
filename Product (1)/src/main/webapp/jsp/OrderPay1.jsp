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
		<h1>주문 / 결제</h1>
		<form name="frm" method="post" action="BoardServlet">
			<table>
				<tr>
					<th>회원번호</th>
					<td><input type="text" name="name" value ="${order.id}"> * 필수</td>
				</tr>
				<tr>
					<th>구매자 성명</th>
					<td><input type="text" name="name" value ="${order.username}"> </td>
				</tr>
				<tr>
					<th>주문 상품</th>
					<td>${product }">  (배송이 시작되면
						주문 취소가 불가능 합니다.)</td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td><input type="text" name="email"value ="${order.callnum}">></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text" size="70" name="title"value ="${order.email}"></td>
				</tr>
				<tr>
					<th>우편번호(주소)</th>
					<td><input type="text" size="70" name="title"value ="${order.addr}"> * 필수</td>
				</tr>
				<tr>
					<th>상세 주소</th>
					<td><input type="text" size="70" name="title"value ="${order.addr2}"> * 필수</td>
				</tr>
				<tr>
				   <th>총합 가격</th>
		    	</tr>
				<tr>
					<th>주문 시 요청사항</th>
					<td><textarea cols="70" rows="15" name="content"></textarea></td>
				</tr>
			</table>
			<br> <br> 
			<input type="submit" value="결제하기"> 
			<input type="reset" value="이 전(장바구니)"
				onclick="location.href='OrderListServlet?command=OrderList">
		</form>
	</div>
</body>
</html>