package unit03;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddionServlet03")
public class AddionServlet03 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddionServlet03() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int n1 = 10;
		int n2 = 20;
		int add = n1 + n2;
		request.setAttribute("num1", n1);
		request.setAttribute("num2", n2);
		request.setAttribute("add", add);
		
		//forward 방식
		RequestDispatcher dispatcher = request.getRequestDispatcher("addition03.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
