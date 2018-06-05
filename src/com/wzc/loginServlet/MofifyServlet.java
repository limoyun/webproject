package com.wzc.loginServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wzc.loginDao.UserDao;

public class MofifyServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("username");
		String oldpassword = request.getParameter("oldpassword");
		String password = request.getParameter("password");
		String rpsw = request.getParameter("rpsw");
		String psw =new UserDao().findUser(username);
		System.out.println("psw="+psw);
		if(psw!=null&&!psw.equals(oldpassword)){
			request.setAttribute("username", username);
			request.setAttribute("msg", psw);
			request.getRequestDispatcher("/modify.jsp").forward(request, response);
			return;
		}
		if(username==null||username.trim().isEmpty()){
			request.setAttribute("msg", "万水千山总是情，给个账号行不行！");
			request.getRequestDispatcher("/modify.jsp").forward(request, response);
			return;
		}
		if(password==null||password.trim().isEmpty()){
			request.setAttribute("msg", "春风不度玉门关，没有密码心怎安");
			request.getRequestDispatcher("/modify.jsp").forward(request, response);
			return;
		}
		if(!password.equals(rpsw)){
			request.setAttribute("msg", "小荷才露尖尖角，两次密码没搞好");
			request.getRequestDispatcher("/modify.jsp").forward(request, response);
			return;
		}
		//System.out.println("<script language='javascript'>alert('用户注册成功！');window.location.href='index.jsp';</script>");
		UserDao u = new UserDao();
		u.modify(username,password);
		request.setAttribute("msg", "<script language='javascript'>alert('用户修改密码成功！');</script>");
		request.getRequestDispatcher("/index.jsp").forward(request, response);

	}

}
