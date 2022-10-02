package com.masai.UseCase;

import java.util.List;

import com.masai.Bean.Buyer;
import com.masai.DAO.AdminDAO;
import com.masai.DAO.AdminDAOImpl;
import com.masai.Exceptions.BuyerException;

public class ViewBuyers {

	public static void main(String[] args) {
		
		AdminDAO buyer = new AdminDAOImpl();
		
		try {
			List<Buyer> buyerList = buyer.ViewRegisteredBuyerList();
			
			buyerList.forEach(b ->{
				System.out.println("Id of the Buyer : " + b.getBuyerid());
				System.out.println("Name of the Buyer : " + b.getName());
				System.out.println("Email of the Buyer : " + b.getEmail());
				System.out.println("Address of the Buyer : " + b.getAddress());
				System.out.println("Mobile Number of the Buyer : " + b.getMobile());
				System.out.println("==============================================");
			});
		} catch (BuyerException e) {
			System.out.println(e.getMessage());
		}
	}

}
