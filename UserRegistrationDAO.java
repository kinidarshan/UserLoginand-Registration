package com.fujitsu.loginandRegister.DAO;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.fujitsu.loginandRegister.model.User;
import com.sun.jdi.connect.spi.Connection;

public class UserRegistrationDAO {
	
	
	public boolean verifyUserCredentials(String username,String password) {
		
		String url = "jdbc:mysql://localhost:3306/test1";
		String db_username = "root";
		String db_password = "darshan@645";
		
		
		Connection con;
		PreparedStatement pstmt;
		
		String sql = "select * from user where userName=? and password=?";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		con = (Connection) DriverManager.getConnection(url, db_username, db_password);
		
		
		pstmt = ((java.sql.Connection) con).prepareStatement("sql");
				
		pstmt.setString(1, username);
		pstmt.setString(2, password);
		
		ResultSet rs = pstmt.executeQuery();
	
		if(rs.next())
			return true;
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public boolean registerUser(User newUser) {
		// TODO Auto-generated method stub
		return false;
	}

	
	}



