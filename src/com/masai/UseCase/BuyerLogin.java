package com.masai.UseCase;

import java.util.Scanner;
import com.masai.Bean.Buyer;
import com.masai.DAO.BuyerDAO;
import com.masai.DAO.BuyerDAOImpl;
import com.masai.Exceptions.BuyerException;

public class BuyerLogin {

	public static void main(String[] args) throws BuyerException {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Enter your username...");
			String username = sc.next();
			
			System.out.println("Enter your password...");
			String password = sc.next();
			
			BuyerDAO buyer = new BuyerDAOImpl();
		
			
			Buyer b = buyer.BuyerLogin(username, password);
			System.out.println("Welcome to the System " + b.getName());
				
			} catch (BuyerException e) {
				// TODO Auto-generated catch block;
				throw new BuyerException(e.getMessage());
			}
		
	}
}
