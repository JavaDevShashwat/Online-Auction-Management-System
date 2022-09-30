package com.masai.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.Bean.Buyer;
import com.masai.Bean.Product;
import com.masai.Exceptions.AdminException;
import com.masai.Exceptions.BuyerException;
import com.masai.Exceptions.ProductException;
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

	@Override
	public String RegisterBuyer(Buyer buyer) {
		// TODO Auto-generated method stub
		String message = "";
		
		try(Connection conn = DBUtility.GetDBConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into Buyer (name, email, mobile, address, password) values (?, ?, ?, ?, ?)");
			
			ps.setString(1, buyer.getName());
			ps.setString(2, buyer.getEmail());
			ps.setString(3, buyer.getMobile());
			ps.setString(4, buyer.getAddress());
			ps.setString(5, buyer.getPassword());
			
			int x = ps.executeUpdate();
			
			if(x > 0)
				message = "Buyer registered successfully...";
			else
				message = "Buyer could not registered successfully...";
				throw new SQLException();
				
		}
		catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return message;
	}

	@Override
	public List<Product> SearchProduct(String category)throws ProductException{
		// TODO Auto-generated method stub
		
		List<Product> productList = new ArrayList<>();
		
		try(Connection conn = DBUtility.GetDBConnection()){
			
			PreparedStatement ps = conn.prepareStatement("Select * from product where ProductCategory = ?");
			
			ps.setString(1, category);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("ProductId");
				String pname = rs.getString("ProductName");
				String pcategory = rs.getString("ProductCategory");
				int pprice = rs.getInt("ProductPrice");
				int pquantity = rs.getInt("ProductQuantity");
				
				Product product = new Product(id, pname, pcategory, pprice, pquantity);
				
				productList.add(product);
			}
			
		}
		catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return productList;
	}
	

}
