package com.masai.UseCase;

import java.util.Scanner;
import com.masai.Bean.Seller;
import com.masai.DAO.SellerDAO;
import com.masai.DAO.SellerDAOImpl;
import com.masai.Exceptions.SellerException;

public class SellerLogin {

	public static void main(String[] args) throws SellerException {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Enter your username...");
			String username = sc.next();
			
			System.out.println("Enter your password...");
			String password = sc.next();
			
			SellerDAO seller = new SellerDAOImpl();
		
			
				Seller s = seller.SellerLogin(username, password);
				System.out.println("Welcome to the System " + s.getName());
				
			} catch (SellerException e) {
				// TODO Auto-generated catch block
				throw new SellerException(e.getMessage());
			}
	}

}
