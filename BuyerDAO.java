package com.masai.DAO;

import com.masai.Bean.Buyer;
import com.masai.Exceptions.BuyerException;

public interface BuyerDAO {

	public Buyer BuyerLogin(String username, String password)throws BuyerException;
	
	
}
