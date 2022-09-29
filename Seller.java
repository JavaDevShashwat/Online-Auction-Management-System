package com.masai.Bean;

public class Seller {

	private int sellerId;
	private String name;
	private String email;
	private String mobile;
	private String address;
	private String password;
	
	public Seller() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Seller(int sellerid, String name, String email, String mobile, String address, String password) {
		super();
		this.sellerId = sellerid;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
		this.password = password;
	}

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Seller [name=" + name + ", email=" + email + ", mobile=" + mobile + ", address=" + address
				+ ", password=" + password + "]";
	}
	
	
}
