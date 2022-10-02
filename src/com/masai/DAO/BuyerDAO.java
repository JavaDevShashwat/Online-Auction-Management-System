package com.masai.DAO;

import java.util.List;

import com.masai.Bean.Buyer;
import com.masai.Bean.BuyerProductDTO;
import com.masai.Bean.HighestBid;
import com.masai.Bean.Product;
import com.masai.Exceptions.BuyerException;
import com.masai.Exceptions.BuyerProductDTOException;
import com.masai.Exceptions.LessQuantityException;
import com.masai.Exceptions.ProductException;

public interface BuyerDAO {

	public Buyer BuyerLogin(String username, String password)throws BuyerException;

	public String RegisterBuyer(Buyer buyer);
	
	public List<Product> SearchProduct(String category) throws ProductException;
	
	public HighestBid SelectProductstoBuy(int BuyerId, int ProductID, int Quantity, int bid)throws BuyerException, ProductException, LessQuantityException;
	
	public List<BuyerProductDTO> SelectBuyerandProduct() throws BuyerProductDTOException;
	
	public String WonTheBid(int BuyerId, int ProductID, int Quantity, int bid);
}
