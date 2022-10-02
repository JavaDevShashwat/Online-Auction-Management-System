package com.masai.UseCase;

import java.util.Scanner;

import com.masai.Bean.Product;
import com.masai.DAO.SellerDAO;
import com.masai.DAO.SellerDAOImpl;

public class AddProducttoSellingList {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
			System.out.println("Enter the Product Name : ");
			String pname = sc.nextLine();
		
			System.out.println("Enter the Product Category : ");
			String pcategory = sc.nextLine();
			
			System.out.println("Enter the Product Quantity : ");
			int pQuantity = sc.nextInt();
			
		try{
			Product productDetails = new Product(0, pname, pcategory, 0, pQuantity);
			
			SellerDAO product = new SellerDAOImpl();
			
			System.out.println(product.AddProducttoSell(productDetails));
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
}
