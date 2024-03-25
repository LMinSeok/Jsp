package com.pro.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pro.dao.CartDAO;
import com.pro.dto.OrderVO;



public class OrderListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		session.setAttribute("userNum", session);

		System.out.println("테스트");
		String url = "jsp/OrderList.jsp";

		CartDAO ODao = CartDAO.getInstance();
		List<OrderVO> list = ODao.selectAllBoards();

		System.out.println("list >>" + list);
		request.setAttribute("orderList", list);

		request.getRequestDispatcher(url).forward(request, response);
	}

}