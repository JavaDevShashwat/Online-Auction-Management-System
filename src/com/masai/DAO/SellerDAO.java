package com.masai.DAO;

import java.util.List;

import com.masai.Bean.Product;
import com.masai.Bean.Seller;
import com.masai.Bean.SoldProductDTO;
import com.masai.Exceptions.ProductException;
import com.masai.Exceptions.SellerException;
import com.masai.Exceptions.SoldProductDTOException;

public interface SellerDAO {
	
	public Seller SellerLogin(String username, String password)throws SellerException;
	
	public String RegisterSeller(Seller seller);
	
	public List<Product> CreateListofProducttoSell()throws ProductException;
	
	public String UpdateProductinList(Product product);
	
	public String AddProducttoSell(Product product);
	
	public String RemoveProductfromList(int id);
	
	public List<SoldProductDTO> ViewSoldProductHistory() throws SoldProductDTOException;
}
