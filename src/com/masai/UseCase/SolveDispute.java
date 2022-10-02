package com.masai.UseCase;

import java.util.Scanner;

import com.masai.DAO.AdminDAO;
import com.masai.DAO.AdminDAOImpl;

public class SolveDispute {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Enter the Diputed product Id...");
			int pId  = sc.nextInt();
			
			AdminDAO admin = new AdminDAOImpl();
		
			String DisputeResult = admin.SolveDailyDispute(pId);
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}

}
