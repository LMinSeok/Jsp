package com.pro.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProCheckDeleteFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "/pro/proDeleteCheck.jsp";
		
		request.getRequestDispatcher(url).forward(request, response);

	}

}
