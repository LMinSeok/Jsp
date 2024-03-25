package com.user.controller.actionuser;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pro.controller.action.Action;
import com.pro.dao.UserDAO;
import com.pro.dto.UsersVO;

public class UserUpdateForm implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int num =Integer.parseInt(request.getParameter("num"));
		
		UsersVO vo = new UsersVO();
		
		vo = UserDAO.getInstance().selectUser(num);
		
		request.setAttribute("user", vo);
		
		
		request.getRequestDispatcher("user/userUpdate.jsp").forward(request, response);

	}

}
