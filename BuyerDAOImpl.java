package com.masai.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.masai.Bean.Buyer;
import com.masai.Exceptions.AdminException;
import com.masai.Exceptions.BuyerException;
import com.masai.Utility.DBUtility;

public class BuyerDAOImpl implements BuyerDAO{

	@Override
	public Buyer BuyerLogin(String username, String password)throws BuyerException{
		
		Buyer buyer = null;
		
		try(Connection conn = DBUtility.GetDBConnection()){
			PreparedStatement ps = conn.prepareStatement("Select * from Buyer where email = ?");
			
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				PreparedStatement ps2 = conn.prepareStatement("Select * from Buyer where password = ?");
				
				ps2.setString(1,password);
				
				ResultSet rs2 = ps2.executeQuery();
				
				if(rs2.next()) {
					
					int id = rs2.getInt("buyerId");
					String name = rs2.getString("name");
					String email = rs2.getString("email");
					String mobile = rs2.getString("mobile");
					String address = rs2.getString("address");
					String pass = rs2.getString("password");
					
					buyer = new Buyer(id, name, email, mobile, address, password);
				}
				else
					throw new BuyerException("Invalid Password, Please Enter valid password...");
			}
			else
				throw new BuyerException("Invalid Username, Please Enter valid username...");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new BuyerException();
		}
		
		return buyer;
	}
	

}
