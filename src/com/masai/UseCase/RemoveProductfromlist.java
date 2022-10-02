package com.masai.UseCase;

import java.util.Scanner;

import com.masai.DAO.SellerDAO;
import com.masai.DAO.SellerDAOImpl;

public class RemoveProductfromlist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Enter the Product Id which you want to remove from the list.");
			int id = sc.nextInt();
			
			SellerDAO seller = new SellerDAOImpl();
			System.out.println(seller.RemoveProductfromList(id));
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}
