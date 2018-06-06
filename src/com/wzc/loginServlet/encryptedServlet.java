package com.wzc.loginServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wzc.loginDao.UserDao;

public class encryptedServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("username");
		String psw =new UserDao().findUserencrypted(username);
		
		
		//System.out.println("<script language='javascript'>alert('用户注册成功！');window.location.href='index.jsp';</script>");
		System.out.println("encrypted="+psw);
		request.setAttribute("msg", psw);
		request.getRequestDispatcher("/forgetpassword.jsp").forward(request, response);

	}

}
