<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${result > 0 }">
		<script type="text/javascript">
			alert("주문 추가 등록 완료 !"); // detail 테이블에 담겨졌으니까
			location.href = "orderUpdateForm.do?order_date=${order1_detail.order_date}&custcode=${order1_detail.custcode}";
		</script>
	</c:if>
	<c:if test="${result == 0 }">
		<script type="text/javascript">
			alert("주문 추가 등록 실패..")
			location.href = "orderUpdateForm.do?order_date=${order1_detail.order_date}&custcode=${order1_detail.custcode}";
		</script>
	</c:if>
</body>
</html>