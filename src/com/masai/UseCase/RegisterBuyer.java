package com.masai.UseCase;

import java.util.Scanner;

import com.masai.Bean.Buyer;
import com.masai.DAO.BuyerDAO;
import com.masai.DAO.BuyerDAOImpl;

public class RegisterBuyer {

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
			
			Buyer buyerDetails =  new Buyer(0, name, email, mobile, address, password);
			
			BuyerDAO seller = new BuyerDAOImpl();
			
			seller.RegisterBuyer(buyerDetails);
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}
}
