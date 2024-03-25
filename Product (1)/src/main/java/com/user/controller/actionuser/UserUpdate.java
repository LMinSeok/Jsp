package com.user.controller.actionuser;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pro.controller.action.Action;
import com.pro.dao.UserDAO;
import com.pro.dto.UsersVO;

public class UserUpdate implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		UsersVO vo = new UsersVO();
		
		vo.setNum(Integer.parseInt(request.getParameter("num")));
		//vo.setId(request.getParameter("id"));
		vo.setUsername(request.getParameter("username"));
		vo.setEmail(request.getParameter("email"));
		vo.setPass(request.getParameter("pass"));
		vo.setAddr(request.getParameter("addr"));
		vo.setAddr2(request.getParameter("addr2"));
		
		
		UserDAO.getInstance().updateUser(vo);
		
		response.sendRedirect("UserServlet?command=mypage");

	}

}
