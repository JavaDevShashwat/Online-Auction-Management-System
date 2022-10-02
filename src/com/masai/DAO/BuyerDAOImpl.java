package com.masai.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.Bean.Buyer;
import com.masai.Bean.BuyerProductDTO;
import com.masai.Bean.HighestBid;
import com.masai.Bean.Product;
import com.masai.Exceptions.AdminException;
import com.masai.Exceptions.BuyerException;
import com.masai.Exceptions.BuyerProductDTOException;
import com.masai.Exceptions.LessQuantityException;
import com.masai.Exceptions.ProductException;
import com.masai.Utility.DBUtility;
import com.mysql.cj.protocol.Resultset;

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
			System.out.println(e.getMessage());
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
			
			if(x > 0) {
				message = "Buyer registered successfully...";
				System.out.println("Buyer registered successfully...");
			}
			else
				message = "Buyer could not registered successfully...";
				
				
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

	@Override
	public HighestBid SelectProductstoBuy(int BuyerId, int ProductID, int Quantity, int bid) throws BuyerException, ProductException, LessQuantityException {
		// TODO Auto-generated method stub
		HighestBid high = new HighestBid(ProductID, BuyerId, bid);	
		
		try(Connection conn = DBUtility.GetDBConnection()){
			
			PreparedStatement ps1 = conn.prepareStatement("Select * from buyer where buyerid = ?");
			
			ps1.setInt(1, BuyerId);
			
			ResultSet rs1 = ps1.executeQuery();
			
			if(rs1.next()) {
				
				PreparedStatement ps2 = conn.prepareStatement("select * from Product where ProductId = ?");
				
				ps2.setInt(1, ProductID);
				
				ResultSet rs2 = ps2.executeQuery();
				
				if(rs2.next()) {
					
					PreparedStatement ps3 = conn.prepareStatement("Select ProductQuantity from Product where ProductId = ? and ProductQuantity >= ?");
					
					ps3.setInt(1, ProductID);
					ps3.setInt(2, Quantity);
					
					ResultSet rs = ps3.executeQuery();
					
					if(rs.next()) {
						
//						PreparedStatement ps = conn.prepareStatement("insert into Product_Buyer values(?, ?, ?, NOW())");
//						
//						ps.setInt(1, BuyerId);
//						ps.setInt(2, ProductID);
//						ps.setInt(3, Quantity);
//						
//						int x = ps.executeUpdate();
//						
//						if(x>0) {
//							System.out.println("Product selected successfully....");
//						}
//						
//							PreparedStatement ps4 = conn.prepareStatement("Update Product set ProductQuantity = ProductQuantity - ? where ProductId = ?");
//							
//							ps4.setInt(1, Quantity);
//							ps4.setInt(2, ProductID);
//							
//							int z = ps4.executeUpdate();
//							
//							if(z > 0) {
//								System.out.println("Product table updated successfully");
//							}
						System.out.println("Yuur bid placed successfully....");
	
					}
					else {
						throw new LessQuantityException("This Product does not have the required quantity, Please select less quantity.");
					}
				}
				else {
					throw new ProductException("Either Product does not exist with Product Id : " + ProductID + " Or it is out of stock..!");
				}
			}
			else {
				throw new BuyerException("Buyer does not exist with Buye Id : " + BuyerId);
			}			
				
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
			high = null;
		}
		
		return high;
	}

	@Override
	public List<BuyerProductDTO> SelectBuyerandProduct() throws BuyerProductDTOException {
		
		List<BuyerProductDTO> buyerList = new ArrayList<>();
		
		try(Connection conn = DBUtility.GetDBConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select b.BuyerId, b.Name, p.ProductId, p.productName,pb.productQuantity, p.Productcategory from Buyer b, Product p, Product_Buyer pb where pb.BuyerId = b.BUyerId and pb.ProductId = p.ProductId group by(Productcategory)");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int Bid = rs.getInt("BuyerId");
				String Bname = rs.getString("Name");
				int Pid = rs.getInt("ProductId");
				String Pname = rs.getString("productName");
				int PQuantity = rs.getInt("productQuantity");
				String pCategory = rs.getString("Productcategory");
				
				BuyerProductDTO buyerProduct = new BuyerProductDTO(Bid, Bname, Pid, Pname, PQuantity, pCategory);
				
				buyerList.add(buyerProduct);
			}
			
			if(buyerList == null) {
				throw new BuyerProductDTOException("There is either no buyer or no product is puchased by any buyer...");
			}
		}
		catch (SQLException e) {
			// TODO: handle exception
			
			System.out.println(e.getMessage());
		}
		
		return buyerList;
	}

	@Override
	public String WonTheBid(int BuyerId, int ProductID, int Quantity, int bid) {
		
		String message = "";
		
		try(Connection conn = DBUtility.GetDBConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into Product_Buyer values(?, ?, ?, NOW())");
			
			ps.setInt(1, BuyerId);
			ps.setInt(2, ProductID);
			ps.setInt(3, Quantity);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				System.out.println("Product selected successfully....");
				message = "Product selected successfully....";
			}
			
				PreparedStatement ps4 = conn.prepareStatement("insert into highestBid values(?, ?, ?)");
				
				ps4.setInt(1, BuyerId);
				ps4.setInt(2, ProductID);
				ps4.setInt(3, bid);
				
				int z = ps4.executeUpdate();
				
				if(z > 0) {
					System.out.println("You won the Bid!!! Don't forget to pay...");
				}
			
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return message;
	}
	

}
