package com.wzc.loginServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wzc.loginDao.UserDao;

public class findpostServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("title");
		String psw =new UserDao().findpost(username);
		
		
		//System.out.println("<script language='javascript'>alert('�û�ע��ɹ���');window.location.href='index.jsp';</script>");
		System.out.println("content="+psw);
		request.setAttribute("msg", "���ݣ�"+psw);
		request.getRequestDispatcher("/findpost.jsp").forward(request, response);

	}

}
