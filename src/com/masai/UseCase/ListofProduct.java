package com.masai.UseCase;

import java.util.List;

import com.masai.Bean.Product;
import com.masai.DAO.SellerDAO;
import com.masai.DAO.SellerDAOImpl;
import com.masai.Exceptions.ProductException;

public class ListofProduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SellerDAO productDetail = new SellerDAOImpl();
		
		try {
			List<Product> productList = productDetail.CreateListofProducttoSell();
			
			productList.forEach(p -> {
				System.out.println("Product Id is : " + p.getProductId());
				System.out.println("Product Name is : " + p.getProductName());
				System.out.println("Product Category is : " + p.getProductCategory());
				System.out.println("Product Price is : " + p.getProductPrice());
				System.out.println("Product Quantity is : " + p.getProductQuantity());
				
				System.out.println("============================================");
				
			});
		}
		catch (ProductException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}
