package controller.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import order.dao.OrderDAO;

public class OrderDeleteAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] selectedOrderIds = request.getParameterValues("selectedOrders");
        
        System.out.println(selectedOrderIds);
        List<String> selectedOrderList = new ArrayList<>();
        if (selectedOrderIds != null) {
            for (String orderId : selectedOrderIds) {
                selectedOrderList.add(orderId);
            }
        }
        int result = OrderDAO.getInstance().deleteSelectedOrders(selectedOrderList);

        System.out.println(result);
        response.sendRedirect("OrderListServlet?command=order_list");
    }
}