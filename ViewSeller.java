package com.masai.UseCase;

import java.util.List;


import com.masai.Bean.Seller;
import com.masai.DAO.AdminDAO;
import com.masai.DAO.AdminDAOImpl;
import com.masai.Exceptions.BuyerException;
import com.masai.Exceptions.SellerException;

public class ViewSeller {

	public static void main(String[] args) {
		
		AdminDAO seller = new AdminDAOImpl();
		
		try {
			List<Seller> buyerList = seller.ViewRegisteredSellerList();
			
			buyerList.forEach(b ->{
				System.out.println("Id of the Buyer : " + b.getSellerId());
				System.out.println("Name of the Buyer : " + b.getName());
				System.out.println("Email of the Buyer : " + b.getEmail());
				System.out.println("Address of the Buyer : " + b.getAddress());
				System.out.println("Mobile Number of the Buyer : " + b.getMobile());
				System.out.println("==============================================");
			});
		} catch (SellerException e) {
			System.out.println(e.getMessage());
		}
	}
}
