package com.masai.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.Bean.Admin;
import com.masai.Bean.Buyer;
import com.masai.Bean.Seller;
import com.masai.Exceptions.AdminException;
import com.masai.Exceptions.BuyerException;
import com.masai.Exceptions.SellerException;
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

	@Override
	public List<Buyer> ViewRegisteredBuyerList() throws BuyerException {
		
		List<Buyer> buyerList = new ArrayList<>();
		
		try(Connection conn = DBUtility.GetDBConnection()){
			PreparedStatement ps = conn.prepareStatement("Select * from Buyer");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int id = rs.getInt("buyerId");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String mobile = rs.getString("mobile");
				String address = rs.getString("address");
				String pass = rs.getString("password");
				
				Buyer buyer = new Buyer(id, name, email, mobile, address, pass);
				
				buyerList.add(buyer);
			}
		}
		catch(SQLException se) {
			System.out.println(se.getMessage());
		}
		
		if(buyerList.size() == 0) {
			System.out.println("No Buyers Registered yet...");
		}
		
		
		return buyerList;
	}

	@Override
	public List<Seller> ViewRegisteredSellerList() throws SellerException {
		List<Seller> sellerList = new ArrayList<>();
		
		try(Connection conn = DBUtility.GetDBConnection()){
			PreparedStatement ps = conn.prepareStatement("Select * from Seller");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int id = rs.getInt("sellerId");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String mobile = rs.getString("mobile");
				String address = rs.getString("address");
				String pass = rs.getString("password");
				
				Seller seller = new Seller(id, name, email, mobile, address, pass);
				
				sellerList.add(seller);
			}
		}
		catch(SQLException se) {
			System.out.println(se.getMessage());
		}
		
		if(sellerList.size() == 0) {
			System.out.println("No Buyers Registered yet...");
		}
		
		
		return sellerList;
	}

}
