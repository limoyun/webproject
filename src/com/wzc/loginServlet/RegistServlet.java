package com.wzc.loginServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wzc.loginDao.UserDao;

public class RegistServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String rpsw = request.getParameter("rpsw");
		String encrypted = request.getParameter("encrypted");//�ܱ�
		String answer=request.getParameter("answer");//��
		System.out.println("encrypted="+encrypted);
		if(username==null||username.trim().isEmpty()){
			request.setAttribute("msg", "��ˮǧɽ�����飬�����˺��в��У�");
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		if(password==null||password.trim().isEmpty()){
			request.setAttribute("msg", "���粻�����Źأ�û������������");
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		if(!password.equals(rpsw)){
			request.setAttribute("msg", "С�ɲ�¶���ǣ���������û���");
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		
		UserDao u = new UserDao();
		u.addUser(username,password,encrypted,answer);
		request.setAttribute("msg", "<script language='javascript'>alert('�û�ע��ɹ���');</script>");
		request.getRequestDispatcher("/index.jsp").forward(request, response);

	}

}
