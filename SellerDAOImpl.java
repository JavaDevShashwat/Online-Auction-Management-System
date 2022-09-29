package com.masai.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.masai.Bean.Seller;
import com.masai.Exceptions.SellerException;
import com.masai.Utility.DBUtility;


public class SellerDAOImpl implements SellerDAO{

		@Override
		public Seller SellerLogin(String username, String password) throws SellerException{
			
			Seller seller = null;
			
			try(Connection conn = DBUtility.GetDBConnection()){
				PreparedStatement ps = conn.prepareStatement("Select * from Seller where email = ?");
				
				ps.setString(1, username);
				
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()) {
					PreparedStatement ps2 = conn.prepareStatement("Select * from Seller where password = ?");
					
					ps2.setString(1,password);
					
					ResultSet rs2 = ps2.executeQuery();
					
					if(rs2.next()) {
						
						int id = rs2.getInt("sellerId");
						String name = rs2.getString("name");
						String email = rs2.getString("email");
						String mobile = rs2.getString("mobile");
						String address = rs2.getString("address");
						String pass = rs2.getString("password");
						
						seller = new Seller(id, name, email, mobile, address, password);
					}
					else
						throw new SellerException("Invalid Password, Please Enter valid password...");
				}
				else
					throw new SellerException("Invalid Username, Please Enter valid username...");
				
			} catch (SQLException e) {
				throw new SellerException();
			}
			
			return seller;
		}
}
