package com.masai.UseCase;

import java.util.Scanner;

import com.masai.Bean.Admin;
import com.masai.DAO.AdminDAO;
import com.masai.DAO.AdminDAOImpl;
import com.masai.Exceptions.AdminException;

public class AdminLogin {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your username...");
		String username = sc.next();
		
		System.out.println("Enter your password...");
		String password = sc.next();
		
		AdminDAO admin = new AdminDAOImpl();
		
		try {
			Admin a = admin.AdminLogin(username, password);
			System.out.println("Welcome to the System " + a.getName());
			
		} catch (AdminException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
}
