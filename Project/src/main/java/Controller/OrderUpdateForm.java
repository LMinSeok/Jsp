package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Order1Dao;
import dao.ItemDao;
import dao.Order1DetailDao;
import dto.Item;
import dto.Order1;
import dto.Order1_detail;

public class OrderUpdateForm implements CommandProcess {

	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("OrderUpdateForm Start...");

		String order_date = request.getParameter("order_date");
		int custcode = Integer.parseInt(request.getParameter("custcode"));

		try {
			// 1. 주문 내용
			Order1Dao od = Order1Dao.getInstance();
			Order1 order1 = od.select(order_date, custcode);

			// 2. 주문 상세 리스트
			Order1DetailDao order1DetailDao = Order1DetailDao.getInstance();
			List<Order1_detail> orderDetailList = order1DetailDao.orderDetailList(order_date, custcode);

			// 3. item 리스트 : 콤보 박스 이용하기 위해
			ItemDao itemDao = ItemDao.getInstance();
			List<Item> itemList = itemDao.itemList();

			request.setAttribute("order1", order1);
			request.setAttribute("orderDetailList", orderDetailList);
			request.setAttribute("itemList", itemList);

			request.setAttribute("order_date", order_date);
			request.setAttribute("custcode", custcode);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "orderUpdateForm.jsp";
	}
}