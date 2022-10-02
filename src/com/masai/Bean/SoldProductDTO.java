package com.masai.Bean;

import java.sql.Date;

public class SoldProductDTO {
	
	private int ProductId;
	private String ProductName;
	private String ProductCategory;
	private int BidonProduct;
	private int ProductQuantity;
	private Date SoldDate;
	
//	p.ProductId, p.ProductName, p.ProductCategory, p.ProductPrice, p.ProductQuantity, pb.SoldDate from product p, product_buyer pb where p.productId = pb.productId;
	
	public SoldProductDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SoldProductDTO(int productId, String productName, String productCategory, int productPrice,
			int productQuantity, Date date) {
		super();
		ProductId = productId;
		ProductName = productName;
		ProductCategory = productCategory;
		BidonProduct = productPrice;
		ProductQuantity = productQuantity;
		SoldDate = date;
	}

	public int getProductId() {
		return ProductId;
	}

	public void setProductId(int productId) {
		ProductId = productId;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public String getProductCategory() {
		return ProductCategory;
	}

	public void setProductCategory(String productCategory) {
		ProductCategory = productCategory;
	}

	public int getBidonProduct() {
		return BidonProduct;
	}

	public void setBidonProduct(int productPrice) {
		BidonProduct = productPrice;
	}

	public int getProductQuantity() {
		return ProductQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		ProductQuantity = productQuantity;
	}

	public Date getSoldDate() {
		return SoldDate;
	}

	public void setSoldDate(Date soldDate) {
		SoldDate = soldDate;
	}

	@Override
	public String toString() {
		return "SoldProductDTO [ProductId=" + ProductId + ", ProductName=" + ProductName + ", ProductCategory="
				+ ProductCategory + ", ProductPrice=" + BidonProduct + ", ProductQuantity=" + ProductQuantity
				+ ", SoldDate=" + SoldDate + "]";
	}
	
	

}
