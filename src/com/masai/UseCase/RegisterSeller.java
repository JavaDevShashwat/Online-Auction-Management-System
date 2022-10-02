package com.masai.UseCase;

import java.util.Scanner;

import com.masai.Bean.Seller;
import com.masai.DAO.SellerDAO;
import com.masai.DAO.SellerDAOImpl;

public class RegisterSeller {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		try{
			System.out.println("Enter your name : ");
			String name = sc.next();
			
			System.out.println("Enter your email : ");
			String email = sc.next();
			
			System.out.println("Enter your mobile number : ");
			String mobile = sc.next();
			
			System.out.println("Enter your address : ");
			String address = sc.next();
			
			System.out.println("Enter your password : ");
			String password = sc.next();
			
			Seller sellerDetails =  new Seller(0, name, email, mobile, address, password);
			
			SellerDAO seller = new SellerDAOImpl();
			
			seller.RegisterSeller(sellerDetails);
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}

}
