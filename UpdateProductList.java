package com.masai.UseCase;

import java.util.Scanner;

import com.masai.Bean.Product;
import com.masai.DAO.SellerDAO;
import com.masai.DAO.SellerDAOImpl;

public class UpdateProductList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Product id : ");
		int id = sc.nextInt();
		
		System.out.println("Enter Product name : ");
		String pname = sc.next();
		
		System.out.println("Enter Product category : ");
		String pcategory = sc.next();
		
		System.out.println("Enter Product price : ");
		int pprice = sc.nextInt();
		
		System.out.println("Enter Product quantity : ");
		int pquantity = sc.nextInt();
		
		Product product = new Product(id, pname, pcategory, pprice, pquantity);
		
		SellerDAO seller = new SellerDAOImpl();
		
		System.out.println(seller.UpdateProductinList(product));

	}

}
