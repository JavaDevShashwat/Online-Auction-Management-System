package com.masai.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.masai.Bean.Admin;
import com.masai.Exceptions.AdminException;
import com.masai.Utility.DBUtility;

public class AdminDAOImpl implements AdminDAO{

	@Override
	public Admin AdminLogin(String username, String password)throws AdminException{

		Admin admin = null;
		
		try (Connection conn = DBUtility.GetDBConnection()){
			PreparedStatement ps = conn.prepareStatement("Select * from Admin where Aemail = ?");
			
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				PreparedStatement ps2 = conn.prepareStatement("Select * from Admin where Apassword = ?");
				
				ps2.setString(1, password);
				
				ResultSet rs2 = ps.executeQuery();
				
				if(rs2.next()) {
					String name = rs2.getString("Aname");
					String uname = rs2.getString("Aemail");
					String pass = rs2.getString("Apassword");
					
					admin = new Admin(name, uname, pass);
					
				}
				else 
					throw new AdminException("Invalid Password, Please Enter valid password...");
			}
			else
				throw new AdminException("Invalid Username, Please Enter valid Username...");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new AdminException();
		}
		
		
		return admin;
	}

}
