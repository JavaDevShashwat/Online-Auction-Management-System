package com.masai.UseCase;

import java.util.List;

import com.masai.Bean.Product;
import com.masai.DAO.AdminDAO;
import com.masai.DAO.AdminDAOImpl;

public class ViewDailyDispute {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdminDAO dispute = new AdminDAOImpl();
		
		try {
			List<Product> disputeList = dispute.ViewDailyDispute();
			
			disputeList.forEach(dl ->{
				System.out.println("Product id : " + dl.getProductId());
				System.out.println("Product Name is : " + dl.getProductName());
				System.out.println("Product category is : " + dl.getProductCategory());
				System.out.println("Dispute in this product is that it's price is : " + dl.getProductPrice());
				System.out.println("Product quantity is : " + dl.getProductQuantity());
				
				System.out.println("====================================================================");
			});
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}

}
