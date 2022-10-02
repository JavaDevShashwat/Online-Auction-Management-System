package com.masai.UseCase;

import java.util.List;

import com.masai.Bean.BuyerProductDTO;
import com.masai.DAO.BuyerDAO;
import com.masai.DAO.BuyerDAOImpl;
import com.masai.Exceptions.BuyerProductDTOException;

public class ViewAllBuyerandProducts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BuyerDAO buyer = new BuyerDAOImpl();
		
		try{
			List<BuyerProductDTO> buyerProduct = buyer.SelectBuyerandProduct();
		

		buyerProduct.forEach(bp -> {
			
			System.out.println("Buyer Id is : " + bp.getBuyerID());
			System.out.println("Buyer Name is : " + bp.getBuyerName());
			System.out.println("Product Id is : " + bp.getProductId());
			System.out.println("Product Name is : " + bp.getProductName());
			System.out.println("Product quantity is : " + bp.getQuantity());
			System.out.println("Product category is : " + bp.getCategory());
			
			System.out.println("========================================");
			
		});
		}
		catch (BuyerProductDTOException e) {
			// TODO: handle exception
			
			System.out.println(e.getMessage());
		}
	}

}
