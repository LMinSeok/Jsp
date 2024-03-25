package com.pro.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pro.dto.OrderVO;
import com.pro.dto.UsersVO;

public class OrderPay1Action implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("테스트");
		HttpSession session = request.getSession();

//		int num = Integer.parseInt((String) session.getAttribute("num"));

		String[] OrderId = request.getParameterValues("selectedOrders");

		System.out.println("OrderId" + OrderId);

//			UsersVO vo = OrderDAO.getInstance().selectOrderByNum(num);

		System.out.println("vo>>값" + vo);
		request.setAttribute("order", vo);
		String url = "jsp/OrderPay1.jsp";

		request.getRequestDispatcher(url).forward(request, response);
	}

}