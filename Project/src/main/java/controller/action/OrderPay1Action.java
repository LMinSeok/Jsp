package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import order.dao.OrderDAO;
import order.dto.OrderVO;

public class OrderPay1Action implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int num = Integer.parseInt(request.getParameter("num"));

		OrderVO vo = OrderDAO.getInstance().selectOrderByNum(num);

		request.setAttribute("order", vo);

		String url = "jsp/OrderPay1.jsp";

		request.getRequestDispatcher(url).forward(request, response);
	}

}