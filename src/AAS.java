import java.util.List;
import java.util.Scanner;

import com.masai.Bean.Admin;
import com.masai.Bean.Buyer;
import com.masai.Bean.HighestBid;
import com.masai.Bean.Seller;
import com.masai.DAO.AdminDAO;
import com.masai.DAO.AdminDAOImpl;
import com.masai.DAO.BuyerDAO;
import com.masai.DAO.BuyerDAOImpl;
import com.masai.DAO.SellerDAO;
import com.masai.DAO.SellerDAOImpl;
import com.masai.Exceptions.SellerException;
import com.masai.UseCase.AddProducttoSellingList;
import com.masai.UseCase.AdminLogin;
import com.masai.UseCase.BuyerLogin;
import com.masai.UseCase.ListofProduct;
import com.masai.UseCase.RegisterBuyer;
import com.masai.UseCase.RegisterSeller;
import com.masai.UseCase.RemoveProductfromlist;
import com.masai.UseCase.SearchProduct;
import com.masai.UseCase.SelectProducttoBuy;
import com.masai.UseCase.SellerLogin;
import com.masai.UseCase.SolveDispute;
import com.masai.UseCase.UpdateProductList;
import com.masai.UseCase.ViewAllBuyerandProducts;
import com.masai.UseCase.ViewBuyers;
import com.masai.UseCase.ViewDailyDispute;
import com.masai.UseCase.ViewDailySoldProductReport;
import com.masai.UseCase.ViewSeller;
import com.masai.UseCase.ViewSoldProductHistory;

public class AAS {

	private static AdminDAO admin = new AdminDAOImpl();
	private static BuyerDAO buyer = new BuyerDAOImpl();
	private static SellerDAO seller = new SellerDAOImpl();
	
	public static void SelectOption() {
		
			boolean role = true;
			
			while(role) {
				
			System.out.println("\nPlease select an option to continue.");
			System.out.println("\n1. Login as Admin \n2. Login as Seller \n3. Login as Buyer \n4. Register as Seller \n5. Register as Buyer.");
			
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			
			switch (choice) {
			case 1:
//				System.out.println("Enter user name.");
//				String userName = sc.next();
//				
//				System.out.println("Enter password");
//				String password = sc.next();
				
				try {
					AdminLogin.main(null);
				}
				catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
					break;
				}
//				if(admin1 != null) {
					boolean atask = true;
					
					while(atask) {
						
						System.out.println("\nPlease select an option to continue.");
						
						System.out.println("\n1. View Registered Buyer List \n2. View Daily Dispute report Seller List \n3. View Daily Dispute report \n4. View Daily Selling report \n5. Solve Daily Dispute report.");
						
						int adminChoice = sc.nextInt();
						
						switch(adminChoice) {
						
						case 1: 
							System.out.println("This is Registered Buyer List");
							
							ViewBuyers.main(null);
							
							System.out.println("Do you want to complete another task? Enter true/false...");
							
							atask = sc.nextBoolean();
							break;
							
						case 2:
							System.out.println("This is Registered Seller List");
							ViewSeller.main(null);
							
							System.out.println("Do you want to complete another task? Enter true/false...");
							
							atask = sc.nextBoolean();
							break;
							
						case 3: 
							System.out.println("This is Daily Dispute report");
							ViewDailyDispute.main(null);
							
							System.out.println("Do you want to complete another task? Enter true/false...");
							
							atask = sc.nextBoolean();
							break;
							
						case 4:
							System.out.println("This is Daily Selling report");
							ViewDailySoldProductReport.main(null);
							
							System.out.println("Do you want to complete another task? Enter true/false...");
							
							atask = sc.nextBoolean();
							break;
							
						case 5: 
							System.out.println("Solve Daily Dispute report");
							SolveDispute.main(null);
							
							System.out.println("Do you want to complete another task? Enter true/false...");
							
							atask = sc.nextBoolean();
							break;
							
						default:
							System.out.println("You have selected wrong option please Select carefully.");
							System.out.println("Do you want to complete another task? Enter true/false...");
							
							atask = sc.nextBoolean();
							break;
						}
					}
//					
//				}
//				else {
//					
//					AAS.SelectOption();
//				}
				break;//case 1 Ends here.
				
			case 2:
//				
//				System.out.println("Enter user name.");
//				String SuserName = sc.next();
//				
//				System.out.println("Enter password");
//				String Spassword = sc.next();
				
				try {
					SellerLogin.main(null);
				}
				catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
					break;
				}
//				if(admin1 != null) {
					boolean stask = true;
					
					while(stask) {
						
						System.out.println("\nPlease select an option to continue.");
						
						System.out.println("\n1. Create List of products to sell \n2. Update products price, quantity, etc. \n3. Add new Products in the list. \n4. Remove product from the list. \n5. View sold products history.");
						
						int SellerChoice = sc.nextInt();
						
						switch(SellerChoice) {
						
//						case 1:
							
//							System.out.println("This is the Registered Seller list...");
//							RegisterSeller.main(null);
//							System.out.println("Do you want to complete another task? Enter true/false...");
//							
//							stask = sc.nextBoolean();
//							break;
							
						case 1:
							
							System.out.println("This is the product list, that is available to sell...");
							ListofProduct.main(null);
							System.out.println("Do you want to complete another task? Enter true/false...");
							
							stask = sc.nextBoolean();
							break;
							
						case 2:
							
							System.out.println("Update the products specifications...");
							UpdateProductList.main(null);
							System.out.println("Do you want to complete another task? Enter true/false...");
							
							stask = sc.nextBoolean();
							break;
							
						case 3:
	
							System.out.println("Add new product to the list...");
							AddProducttoSellingList.main(null);
							System.out.println("Do you want to complete another task? Enter true/false...");
							
							stask = sc.nextBoolean();
							break;
							
						case 4:
	
							System.out.println("Remove product from the list...");
							RemoveProductfromlist.main(null);
							System.out.println("Do you want to complete another task? Enter true/false...");
							
							stask = sc.nextBoolean();
							break;
							
						case 5:
	
							System.out.println("View sold product product history...");
							ViewSoldProductHistory.main(null);
							System.out.println("Do you want to complete another task? Enter true/false...");
							
							stask = sc.nextBoolean();
							break;
							
						default:
							
							System.out.println("Do you want to complete another task? Enter true/false...");
							
							stask = sc.nextBoolean();
							break;
						}
						
					}
				
				
				break;//case 2 Ends here.
				
			case 3:
				
				try {
					BuyerLogin.main(null);
				}
				catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
					break;
				}
				
				boolean btask = true;
				
				while(btask) {
					
					System.out.println("\nPlease select an option to continue.");
					
					System.out.println("\n1 Search and view product by category \n2. Select buyers and their product category wise. \n3. Select products to buy and bid on it.");
					
					int BuyerChoice = sc.nextInt();
					
					switch(BuyerChoice) {
					
//					case 1:
						
//						System.out.println("Register as Buyer...");
//						RegisterBuyer.main(null);
//						System.out.println("Do you want to complete another task? Enter true/false...");
//						
//						btask = sc.nextBoolean();
						
//						break;
						
					case 1:
						
						System.out.println("Search and view product by category");
						SearchProduct.main(null);
						System.out.println("Do you want to complete another task? Enter true/false...");
						
						btask = sc.nextBoolean();
						break;
						
					case 2:
						
						System.out.println("Select buyers and their product category wise");
						ViewAllBuyerandProducts.main(null);
						System.out.println("Do you want to complete another task? Enter true/false...");
						
						btask = sc.nextBoolean();
						
						break;
						
					case 3:
						
						boolean bidmore = true;
						
						while(bidmore) {
							
							HighestBid bid = SelectProducttoBuy.main(null);
							
							System.out.println("Do you want to bid more?? Enter true/ flase...");
							bidmore = sc.nextBoolean();
							
							
						}
						
						if(!bidmore) {
							System.out.println("Confirm your details for payment...");
							BuyerDAO buyer = new BuyerDAOImpl();
							
							System.out.println("Enter your id");
							int bId = sc.nextInt();
							
							System.out.println("Enter Product id");
							int Pid = sc.nextInt();
							
							System.out.println("Enter product quantity");
							int quantity = sc.nextInt();
							
							System.out.println("Enter your bid");
							int bid = sc.nextInt();
							
							buyer.WonTheBid(bId, Pid, quantity, bid);
						}
						
						break;
					default:
						
						System.out.println("Do you want to complete another task? Enter true/false...");
						
						btask = sc.nextBoolean();
						
						break;
							
					}
					
				}
				
				break;//case 3 Ends here.
			case 4:
				
				System.out.println("Register youself as a seller...");
				try {
					RegisterSeller.main(null);
				}
				catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				break;
				
			case 5:
				
				System.out.println("Register as Buyer...");
				RegisterBuyer.main(null);
				
				break;
				
			default:
				break;
			}
			System.out.println("Do you want to Login/ register again?? Enter true/false...");
			role = sc.nextBoolean();
		}
		
	}
}
