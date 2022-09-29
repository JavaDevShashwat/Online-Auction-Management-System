package com.masai.DAO;

import java.util.List;

import com.masai.Bean.Admin;
import com.masai.Bean.Buyer;
import com.masai.Bean.Seller;
import com.masai.Exceptions.AdminException;
import com.masai.Exceptions.BuyerException;
import com.masai.Exceptions.SellerException;

public interface AdminDAO {
	//For admin login py passing username and password.
	public Admin AdminLogin(String username, String password)throws AdminException;
	
	//For admin to view the registered Buyer list;
	public List<Buyer> ViewRegisteredBuyerList() throws BuyerException;
	
	//For admin to view the registered Seller List;
	public List<Seller> ViewRegisteredSellerList() throws SellerException;

}
