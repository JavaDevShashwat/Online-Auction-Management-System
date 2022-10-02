package com.masai.UseCase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.Bean.SoldProductDTO;
import com.masai.DAO.AdminDAO;
import com.masai.DAO.AdminDAOImpl;
import com.masai.DAO.SellerDAO;
import com.masai.DAO.SellerDAOImpl;

public class ViewDailySoldProductReport {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AdminDAO admin = new AdminDAOImpl();
		
		try {
			
			List<SoldProductDTO> soldList = admin.ViewSellingReport();
			
			soldList.forEach(sl -> {
				
				System.out.println("Product id : " + sl.getProductId());
				System.out.println("Product Name is : " + sl.getProductName());
				System.out.println("Product category is : " + sl.getProductCategory());
				System.out.println("Highest bid on the product was : " + sl.getBidonProduct());
				System.out.println("Product quantity is : " + sl.getProductQuantity());
				System.out.println("Product selling date is : " + sl.getSoldDate());
				
				System.out.println("==========================================");
				
			});
			
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}

}
