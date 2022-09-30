package com.masai.UseCase;

import java.util.Scanner;

import com.masai.Bean.Product;
import com.masai.DAO.SellerDAO;
import com.masai.DAO.SellerDAOImpl;

public class AddProducttoSellingList {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the Product Name : ");
		String pname = sc.next();
		
		System.out.println("Enter the Product Category : ");
		String pcategory = sc.next();
		
		System.out.println("Enter the Product Price : ");
		int pPrice = sc.nextInt();
		
		System.out.println("Enter the Product Quantity : ");
		int pQuantity = sc.nextInt();
		
		Product productDetails = new Product(0, pname, pcategory, pPrice, pQuantity);
		
		SellerDAO product = new SellerDAOImpl();
		
		System.out.println(product.AddProducttoSell(productDetails));
	}
}
