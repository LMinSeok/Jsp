package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Order1Dao;
import dto.Order1;

public class OrderContent implements CommandProcess {

	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("OrderContent Start...");

		String order_date = request.getParameter("order_date");
		int custcode = Integer.parseInt(request.getParameter("custcode"));

		System.out.println("orderContent order_date: " + order_date);
		System.out.println("orderContent custcode: " + custcode);

		try {
			Order1Dao od = Order1Dao.getInstance();

			Order1 order1 = od.select(order_date, custcode);

			request.setAttribute("order_date", order_date);
			request.setAttribute("custcode", custcode);
			request.setAttribute("order1", order1);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "orderContent.jsp";
	}
}