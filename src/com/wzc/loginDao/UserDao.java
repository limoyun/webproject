package com.wzc.loginDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
	//根据用户名查找用户密码
	public String findUser(String username){
		String psw = null;
		String sql = "select * from user where username=?";
		Connection con =getConnection();
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			if(rs.next()){
				psw=rs.getString("password");
			}else{
				psw=null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			} catch (SQLException e) {		
				e.printStackTrace();
			}
		}
		return psw;
	}//根据用户名找密保
	public String findUserencrypted(String username){
		String psw = null;
		String sql = "select * from user where username=?";
		Connection con =getConnection();
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			if(rs.next()){
				psw=rs.getString("encrypted");
			}else{
				psw=null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			} catch (SQLException e) {		
				e.printStackTrace();
			}
		}
		return psw;
	}//根据用户名找答案
	public String findUseranswer(String username){
		String psw = null;
		String sql = "select * from user where username=?";
		Connection con =getConnection();
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			if(rs.next()){
				psw=rs.getString("answer");
			}else{
				psw=null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			} catch (SQLException e) {		
				e.printStackTrace();
			}
		}
		return psw;
	}
	//添加用户
	public void addUser(String username,String psw,String enc,String ans){
		Connection con = getConnection();
		PreparedStatement pstmt =null;
		String sql = "INSERT INTO user(username,password,encrypted,answer) VALUES(?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, psw);
			pstmt.setString(3, enc);
			pstmt.setString(4, ans);
			pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch (SQLException e) {	
				e.printStackTrace();
			}
		}
	}
	//添加帖子
	public void addTitle(String postid,String username,String content,String title){
		Connection con = getConnection();
		PreparedStatement pstmt =null;
		String sql = "INSERT INTO post(postid,username,content,title) VALUES(?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, postid);
			pstmt.setString(2, username);
			pstmt.setString(3, content);
			pstmt.setString(4, title);
			pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch (SQLException e) {	
				e.printStackTrace();
			}
		}
	}//根据用户名找帖子
	public String findpost(String title){
		String psw = null;
		String sql = "select * from post where title=?";
		Connection con =getConnection();
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, title);
			rs = pstmt.executeQuery();
			if(rs.next()){
				psw=rs.getString("content");
			}else{
				psw=null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			} catch (SQLException e) {		
				e.printStackTrace();
			}
		}
		return psw;
	}
	//修改密码
	public void modify(String username,String psw){
		Connection con = getConnection();
		PreparedStatement pstmt =null;
		String sql = "update user set password=? where username=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, psw);
			pstmt.setString(2, username);
			pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch (SQLException e) {	
				e.printStackTrace();
			}
		}
	}
	public String findline(){
		String id = null;
		String sql = "select max(postid) from post";
		Connection con =getConnection();
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(sql);
			//pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			if(rs.next()){
				id=rs.getString("max(postid)");
			}else{
				id=null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			} catch (SQLException e) {		
				e.printStackTrace();
			}
		}
		return id;
	}
	//获得连接
	public static Connection getConnection(){
		String driver ="com.mysql.jdbc.Driver";
		String url ="jdbc:mysql://localhost:3306/students";
		String user ="root";
		String password ="lilinzhi";
		Connection connection =null;
		try {
			Class.forName(driver);
			connection =DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	public static void main(String[] args) {
		//测试方法
//		System.out.println(new UserDao().findUser("123"));
//		new UserDao().addUser("1345", "1345");
	}


	
}
