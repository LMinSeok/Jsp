<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "ezen1";
	String password = "1234";
	String sql = "select * from item";%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>입력된 정보</h1>
	<table width="800" border="1">
		<tr>
			<th>이름</th>
			<th>가격</th>
			<th>설명</th>
		</tr>
		<%
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			con = DriverManager.getConnection(url, username, password);

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				out.println("<tr>");
				out.println("<td>" + rs.getString("name") + "</td>");
				out.println("<td>" + rs.getString("price") + "</td>");
				out.println("<td>" + rs.getString("description") + "</td>");
				out.println("</tr>");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
			rs.close();
				if (pstmt != null)
			pstmt.close();
				if (con != null)
			con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		%>

	</table>
</body>
</html>