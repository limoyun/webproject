package com.wzc.loginDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
	//�����û��������û�����
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
	}
	//����û�
	public void addUser(String username,String psw){
		Connection con = getConnection();
		PreparedStatement pstmt =null;
		String sql = "INSERT INTO user(username,password) VALUES(?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, psw);
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
	//�޸�����
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
	//�������
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
		//���Է���
//		System.out.println(new UserDao().findUser("123"));
//		new UserDao().addUser("1345", "1345");
	}

/*
 * ���ݱ�
  CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8
*/
	
}
