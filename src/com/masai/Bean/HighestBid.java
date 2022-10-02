package com.masai.Bean;

public class HighestBid {

	private int ProductId;
	private int BuyerId;
	private int bid;
	
	public HighestBid() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HighestBid(int productId, int buyerId, int bid) {
		super();
		ProductId = productId;
		BuyerId = buyerId;
		this.bid = bid;
	}

	public int getProductId() {
		return ProductId;
	}

	public void setProductId(int productId) {
		ProductId = productId;
	}

	public int getBuyerId() {
		return BuyerId;
	}

	public void setBuyerId(int buyerId) {
		BuyerId = buyerId;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	@Override
	public String toString() {
		return "HighestBid [ProductId=" + ProductId + ", BuyerId=" + BuyerId + ", bid=" + bid + "]";
	}
	
	
}
