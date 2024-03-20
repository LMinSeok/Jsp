<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Order 거래처 내역</h2>
	<table class="table table-hover table-primary">
		<tr>
			<td>주문일자</td>
			<td>거래처명</td>
			<td>주문내용</td>
			<td>접수사원</td>
		</tr>
		<tr>
			<td>${order1.order_date }</td>
			<td>${order1.custcode }${order1.custname }</td>
			<td>${order1.order_desc }</td>
			<td>${order1.sabun }${order1.sawon_name }</td>
		</tr>
	</table>

	<form action="orderUpdatePro.do">
		// ***
		<h2>주문 상세 추가 입력</h2>
		<input type="hidden" name="order_date" value="${order1.order_date }">
		// 위 페이지에서 request.setAttribute으로 담았으니까 갖고 올 수 있음 <input type="hidden"
			name="custcode" value="${order1.custcode }">
		<table class="table table-hover table-primary">
			<tr>
				<td>제품</td>
				<td>제품주문입력</td>
				<td>제품수량</td>
				<td>상세 추가 입력</td>
			</tr>
			<tr>
				<td><select name="item_code" required="required">
						<c:forEach var="item" items="${itemList }">
							<option value="${item.item_code }">${item.item_name }</option>
						</c:forEach>
				</select></td>
				<td><input type="text" name="item_order_desc"
					required="required"></td>
				<td><input type="number" name="item_count" value="1"
					required="required"></td>
				<td><input type="submit" value="거래처 제품 추가 등록"></td>
			</tr>
		</table>
	</form>

	<h2>주문 상세 리스트</h2>
	<table class="table table-hover table-primary">
		<tr>
			<td>제품코드</td>
			<td>제품명</td>
			<td>제품주문내용</td>
			<td>제품수량</td>
		</tr>
		<c:forEach var="orderDetail" items="${orderDetailList }">
			<tr>
				<td>${orderDetail.item_code }</td>
				<td><a
					href="orderUpdatePro.do?=order_date=${orderDetail.order_date }&custcode=?${orderDetail.custcode}">${orderDetail.item_name }</a></td>
				<td>${orderDetail.item_order_desc }</td>
				<td>${orderDetail.item_count }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>