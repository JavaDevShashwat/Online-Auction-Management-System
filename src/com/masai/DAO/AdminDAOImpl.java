package com.masai.DAO;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.Bean.Admin;
import com.masai.Bean.Buyer;
import com.masai.Bean.Product;
import com.masai.Bean.Seller;
import com.masai.Bean.SoldProductDTO;
import com.masai.Exceptions.AdminException;
import com.masai.Exceptions.BuyerException;
import com.masai.Exceptions.ProductException;
import com.masai.Exceptions.SellerException;
import com.masai.Exceptions.SoldProductDTOException;
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
					
					System.out.println("Admin logged in Successfully.");
					
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
			
			if(buyerList.size() == 0) {
				System.out.println("No Buyers Registered yet...");
				throw new BuyerException("No Buyers Registered yet...");
			}
		}
		catch(SQLException se) {
			System.out.println(se.getMessage());
			throw new BuyerException();
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
			
			if(sellerList.size() == 0) {
				System.out.println("No Buyers Registered yet...");
				throw new SellerException("No Buyers Registered yet...");
			}
		}
		catch(SQLException se) {
			System.out.println(se.getMessage());
			throw new SellerException();
		}
		
		return sellerList;
	}

	@Override
	public List<SoldProductDTO> ViewSellingReport() throws SoldProductDTOException {

		List<SoldProductDTO> soldProduct = new ArrayList<>();
		
		try(Connection conn = DBUtility.GetDBConnection()){
			PreparedStatement ps = conn.prepareStatement("Select p.ProductId,p.ProductName,p.ProductCategory,p.ProductPrice,p.ProductQuantity,pb.SoldDate from product p, product_Buyer pb where p.productId = pb.productId and pb.SoldDate = CURDATE()");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int id = rs.getInt("ProductId");
				String name = rs.getString("ProductName");
				String category = rs.getString("ProductCategory");
				int price = rs.getInt("ProductPrice");
				int quantity = rs.getInt("ProductQuantity");
				Date date = rs.getDate("SoldDate");
				
				SoldProductDTO sold = new SoldProductDTO(id, name, category, price, quantity, date);
				
				soldProduct.add(sold);
			}
		}
		catch(SQLException se) {
			System.out.println(se.getMessage());
		}
		
		if(soldProduct.size() == 0) {
			System.out.println("No product has been sold yet..!");
		}
		
		return soldProduct;
	}

	@Override
	public List<Product> ViewDailyDispute() throws ProductException {
		// TODO Auto-generated method stub
		List<Product> dispute = new ArrayList<>();
		
		try(Connection conn = DBUtility.GetDBConnection()){
			
			PreparedStatement ps = conn.prepareStatement("Select p.ProductId,p.ProductName,p.ProductCategory,p.ProductPrice,p.ProductQuantity from product p, product_Buyer pb where p.productId = pb.productId and p.ProductPrice is null and pb.SoldDate = CurDate()");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int id = rs.getInt("ProductId");
				String name = rs.getString("ProductName");
				String category = rs.getString("ProductCategory");
				int price = rs.getInt("ProductPrice");
				int quantity = rs.getInt("ProductQuantity");
				
				Product sold = new Product(id, name, category, price, quantity);
				
				dispute.add(sold);
			}
			if(dispute.size() == 0) {
				System.out.println("There is no dispute yet...");
				throw new ProductException();
			}
			
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return dispute;
	}

	@Override
	public String SolveDailyDispute(int productId)throws ProductException{
		// TODO Auto-generated method stub
		
		String message = "";
		
		try(Connection conn = DBUtility.GetDBConnection()){
			
			PreparedStatement ps = conn.prepareStatement("Update product set productPrice = (select highestbid from highestbid h where h.productId = ?) where productId = ? and productId in (Select productId from highestBid)");
			
			ps.setInt(1, productId);
			ps.setInt(2, productId);
			
			int rs = ps.executeUpdate();
			
			if(rs > 0) {
				
				message = "Dispute is resolved";
				System.out.println("Dispute is resolved...");
				
			}
			else {
				throw new ProductException("Product is not there in the purchased list, Please check the product Id...");
			}
		}
		catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			
			message = "Dispute cannot be resolved....";
		}
		
		return message;
	}

	

}
