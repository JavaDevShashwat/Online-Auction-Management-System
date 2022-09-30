package com.masai.DAO;

import java.util.List;

import com.masai.Bean.Buyer;
import com.masai.Bean.Product;
import com.masai.Exceptions.BuyerException;
import com.masai.Exceptions.ProductException;

public interface BuyerDAO {

	public Buyer BuyerLogin(String username, String password)throws BuyerException;

	public String RegisterBuyer(Buyer buyer);
	
	public List<Product> SearchProduct(String category) throws ProductException;
	
	
}
