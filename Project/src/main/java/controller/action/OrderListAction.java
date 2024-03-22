package controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import order.dao.OrderDAO;
import order.dto.OrderVO;

public class OrderListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("테스트");
		String url = "jsp/OrderList.jsp";

		OrderDAO ODao = OrderDAO.getInstance();
		List<OrderVO> list = ODao.selectAllBoards();

		System.out.println(list);
		request.setAttribute("orderList", list);

		request.getRequestDispatcher(url).forward(request, response);
	}

}