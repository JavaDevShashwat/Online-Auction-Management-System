package com.masai.Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtility {

	public static Connection GetDBConnection(){
		
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String url = "jdbc:mysql://localhost:3306/ConstructWeek";
		
		try{
			conn = DriverManager.getConnection(url,"root", "root");
			
		}
		catch(SQLException se) {
			
		}
		
		return conn;

	}
}
