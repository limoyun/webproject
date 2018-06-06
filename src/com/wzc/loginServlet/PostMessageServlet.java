package com.wzc.loginServlet;

import java.io.IOException;
import java.util.Date;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wzc.loginDao.UserDao;



public class PostMessageServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		HttpSession session = req.getSession();
		String postsuccess="发表成功";
		String id =new UserDao().findline();
		String username=(String) session.getAttribute("user");
		
		String title=req.getParameter("title");
		Date time=new Date();
		String content=req.getParameter("content");
		
		
		
		UserDao u = new UserDao();
		u.addTitle(	id,username,content,title);
		System.out.println("ok");
		req.getRequestDispatcher("/welcome.jsp").forward(req, resp);


	}
}
