package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Order1DetailDao;
import dto.Order1_detail;

public class OrderUpdatePro implements CommandProcess {

	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("OrderUpdatePro Start...");

		try {
			// 1. form에서 갖고 온 data get
			String order_date = request.getParameter("order_date");
			int custcode = Integer.parseInt(request.getParameter("custcode"));
			int item_code = Integer.parseInt(request.getParameter("item_code"));
			String item_order_desc = request.getParameter("item_order_desc");
			int item_count = Integer.parseInt(request.getParameter("item_count"));

			// 2. 값이 담겨지는 건 detail 테이블 -> DTO 생성하고 값 setting
			Order1_detail order1_detail = new Order1_detail();
			order1_detail.setOrder_date(order_date);
			order1_detail.setCustcode(custcode);
			order1_detail.setItem_code(item_code);
			order1_detail.setItem_order_desc(item_order_desc);
			order1_detail.setItem_count(item_count);

			// 3. orderDetailDao와 인스턴스와 연결
			Order1DetailDao order1DetailDao = Order1DetailDao.getInstance();

			// 중복 체크 고려 안함
			int result = order1DetailDao.insert(order1_detail);

			request.setAttribute("result", result);
			request.setAttribute("order1_detail", order1_detail);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("orderUpdatePro end...");
		return "orderUpdatePro.jsp";
	}
}