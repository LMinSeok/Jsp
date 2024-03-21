package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.Getter;
import lombok.Setter;
import order.dao.OrderDAO;
import order.dto.OrderVO;

@Setter
@Getter
@WebServlet("/orderList")
public class OrderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = null;
		try {
			// 데이터베이스 연결 설정 (Connection 객체 획득)
			// 예시: Connection conn = ConnectionManager.getConnection();

			OrderDAO orderDAO = new OrderDAO(conn);
			List<OrderVO> orders = orderDAO.getAllOrders();

			request.setAttribute("orders", orders);
			request.getRequestDispatcher("orderList.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			// 오류 처리 로직 추가
		} finally {
			// 연결 종료 로직 추가 (Connection 반환 등)
		}
	}
}