package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Order1Dao;
import dto.Order1;

public class OrderList implements CommandProcess {

	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("OrderList Start...");

		try {
			// 싱글톤과 연결
			Order1Dao od = Order1Dao.getInstance();

			// 총갯수
			int totCnt = od.getTotalCnt();

			// 모든 컬럼값 갖고 오기 위해 List 사용
			List<Order1> orderList = od.orderList();

			request.setAttribute("totCnt", totCnt);
			request.setAttribute("orderList", orderList);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "orderList.jsp";
	}
}