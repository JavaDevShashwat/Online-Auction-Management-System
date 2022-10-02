package com.masai.UseCase;

import java.util.Scanner;

import com.masai.Bean.HighestBid;
import com.masai.DAO.BuyerDAO;
import com.masai.DAO.BuyerDAOImpl;

public class SelectProducttoBuy {

	public static HighestBid main(String[] args) {
		// TODO Auto-generated method stub
		HighestBid hbid = new HighestBid();
		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("Enter your Id : ");
			int buyerId = sc.nextInt();
			
			System.out.println("Enter product Id : ");
			int productId = sc.nextInt();
			
			System.out.println("Enter product quantity");
			int quantity = sc.nextInt();
			
			System.out.println("Enter your Bidding...");
			int bid = sc.nextInt();
			
			BuyerDAO buyerNeed = new BuyerDAOImpl();
			
			try {
				hbid = buyerNeed.SelectProductstoBuy(buyerId, productId, quantity, bid);
			}
			catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return hbid;
	}

}
