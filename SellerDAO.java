package com.masai.DAO;

import com.masai.Bean.Seller;
import com.masai.Exceptions.SellerException;

public interface SellerDAO {
	
	public Seller SellerLogin(String username, String password)throws SellerException;
}
