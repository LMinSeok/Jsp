package unit01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Test() {
        super();

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head></head><body>");
		out.println("<body><h1>지리산</h1>");
		out.println("<p>중부고속국도를 타고 가다 산청나들목을 나와<br>");
		out.println("59번 국도를 타고 지리산·대원산 방면으로<br>");
		out.println("20km 정도 가면 평촌삼거리가 나온다.</p>");
		out.println("<hr>");
		out.println("<hr>");
		out.println("<h1>태백산</h1>");
		out.println("<p>강원도 태백시와 경상북도 봉화군 석포면에 걸쳐 있는 산. <br>");
	    out.println("</body></html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
