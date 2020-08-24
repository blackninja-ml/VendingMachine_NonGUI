

package VendingMachine;

import java.util.Scanner;
import java.util.HashMap;


//The password for a supplier to restart the system: "7iwtug";
public class V {
	public static int options = 0, coins = 0, changeMoney, productNum=3;;
	public static int total = 0, balance = 0, change = 0 , a=65;
	public static Scanner input = new Scanner(System.in);
	public static String product , displayBoard ;
	public static String[] productList;
	public static String password = "xx";
	static HashMap<String, String>productList1  = new HashMap<String, String>();
	public static String test1;
	public static int test2;
	public static boolean vt;
	public static void main(String[] args) {
		
		productList1.put("Coke", "0.26");
		productList1.put("Pepsi", "0.35");
		productList1.put("Soda", "0.45");
		//for (int J = 0; J<productNum; J++) {
		for (String i : productList1.keySet()) {
			char c = (char)a;
			System.out.println(c+ " "+i + " "+  productList1.get(i));
			a= a + 1;
			//}
  		}

		//}
	    System.out.println("HELLO Customer!");
	
	    System.out.println();
	    System.out.println("Type 1 when you want to insert coins");
	    System.out.println("Type 0 when you finish inserting money.");
	    System.out.println("Type d when you want to cancel a request.");
	    System.out.println("Type -2 when you want to reset the system.");
	    System.out.println();
	    
	    options = input.nextInt();
	    
	    Payment(options);
	    Purchase();
	    Display();
	    Decision();
	    
	    if (options == -2) {
	    	Reset();
	    }
	}
	 public static void Payment(int options) {
		 if (options == 0) {
			 test1 = "Welcome Next Time";
			 System.out.println("Welcome Next Time");
		 	}
		 else if (options == 1) {
			 System.out.println("Please input coins.");
			 coins = -1 ;
			 while(coins!= 0) {
				 coins = input.nextInt();
				 switch (coins) {
				 	case 0:
					break;
		          case 1: 
		            total += 1;
		            break;
		          case 5: 
		            total += 5;
		            break;
		          case 10: 
		            total += 10;
		            break;
		          case 25: 
		            total += 25;
		            break;
		          default:
		        	  System.out.println("Invalid Coins, Please enter new coins");
		          		
				if (coins != 1 || coins!= 5 || coins !=10 || coins!=25 ) {
					System.out.println("Invalid Coins. Please enter new coins.");}
						}
		 			}
			 
		 }else {
			 System.out.println("Invalid Input. Please try again.");
		 	} 
	 	}
	 public static void Purchase() {
		 if(options ==0) {
			 test1 = "Thank you please come again next time.";
			 System.out.println("Thank you please come again next time.");
		 }
		    System.out.println("Please select your product.");
		    String product1 = input.next();
		    product = product1.toLowerCase();
			    switch (product) {
			    case "a":
			      balance += 26;
			      break;
			    case "b":
			      balance += 35;
			      break;
			    case "c":
			      balance += 45;
			      break;
			    case "d":
			    	System.out.println("See you next time.");
			      break;
			    default:
			    	System.out.println("Invalid Products");   	
			   }
			    test2 = balance;
	 	}
	 public static int Calculations(int change) {
		    int changeS = 0;
		    int quarters, rQuarters=0;
		    int dimes, rDimes = 0;
		    int nickles, rNickles = 0;
		    int pennies = 0;
		    
		    quarters = change/25;
		    rQuarters =change%25;
		    changeS += quarters;
		    System.out.println(changeS + " quarters");

		    if(rQuarters!=0) {
		      dimes = rQuarters/10;
		      rDimes = rQuarters%10;
		      changeS += dimes;
		      System.out.println(changeS + " dimes");
		      
		    } 
		    
		    if (rDimes!=0) {
		      nickles = rDimes/5;
		      rNickles = rDimes %5;
		      changeS += nickles;
		      System.out.println(changeS + " nickles");
		    }
		    
		    if (rNickles!=0) {
		      pennies = rNickles;
		      changeS += pennies;
		      System.out.println(changeS+ " pennies");
		    }
		    return changeS;
		  }
	 public static String Decision() {
		 if (total > balance) {
	          change = total - balance;
	          changeMoney = Calculations(change);
	          displayBoard = "Your chanege is: " + String.valueOf(change/100.0);
	          System.out.println(displayBoard);
	    }else {
	        	displayBoard = "Enter more money.";
	        	System.out.println(displayBoard);
	    		}
		 return displayBoard;
	 }

	  
	  public static void Display() {
		vt = true;
	    System.out.println("AMOUNT TO BE PAID : " + balance/100.0);
	    System.out.println("TOTAL MONEY INPUTTED: " + total/100.0);
	  }
	  
	  public static void Reset() {
		  productList1.clear();
		  productNum =0;
		  a = 65;
		  System.out.println("How many?");
		  productNum = input.nextInt();
		  System.out.println(productNum + " Enter your product names");
		  String name;
		  String price;
	  		
	  		for (int i =1; i<productNum; i++) {
		  		name = input.next();
		  		price = input.next();
	  			productList1.put(name, price);
	  			
	  		}
	  		
	  		name = input.next();
	  		price = input.next();
	  		productList1.put(name, price);
	  		System.out.println(productList1);
	  		
	  			}
}
