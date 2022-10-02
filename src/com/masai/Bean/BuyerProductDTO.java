package com.masai.Bean;

public class BuyerProductDTO {

	private int buyerID;
	private String buyerName;
	private int productId;
	private String productName;
	private int quantity;
	private String Category;
	
	
	
	public BuyerProductDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BuyerProductDTO(int buyerID, String buyerName, int productId, String productName,int quantity, String category) {
		super();
		this.buyerID = buyerID;
		this.buyerName = buyerName;
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.Category = category;
	}

	public int getBuyerID() {
		return buyerID;
	}

	public void setBuyerID(int buyerID) {
		this.buyerID = buyerID;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	@Override
	public String toString() {
		return "BuyerProductDTO [buyerID=" + buyerID + ", buyerName=" + buyerName + ", productId=" + productId
				+ ", productName=" + productName + ", quantity=" + quantity + ", Category=" + Category + "]";
	}

	
	
	
}
