



package VendingMachine;

import java.util.Scanner;
import java.util.HashMap;


//The password for a supplier to restart the system: "7iwtug";
public class V {
	public static int options = 0, coins = 0, changeMoney, productNum=3;;
	public static int total = 0, balance = 0, change = 0 , a=65, x=0;
	public static Scanner input = new Scanner(System.in);
	public static String product , displayBoard ;
	public static String[] productList;
	public static String password = "xx";
	static HashMap<String, String>productList1  = new HashMap<String, String>();
	static HashMap<Integer, String>productList2  = new HashMap<Integer, String>();
	public static String test1;
	public static int test2;
	public static boolean vt;
	public static String[] temp;
	public static void main(String[] args) {
		
		productList1.put("Coke", "0.26");
		productList1.put("Pepsi", "0.35");
		productList1.put("Soda", "0.45");
		productList2.put(0,"0.26" );
		productList2.put(1,"0.35");
		productList2.put(2, "0.45");
		temp = new String[1000];
		x = 0;
		//for (int J = 0; J<productNum; J++) {
		for (String i : productList1.keySet()) {
			char c = (char)a;
			System.out.println(c+ " "+i + " "+  productList1.get(i));
			a = a + 1;
			
			temp[x] = i;
			x ++;
  		}
		
		
		
		
		
		//}
	    System.out.println("HELLO Customer!");
	
	    System.out.println();
	    System.out.println("Type 1 when you want to insert coins");
	    System.out.println("Type 0 when you finish inserting money.");
	    //System.out.println("Type d when you want to cancel a request.");
	    System.out.println("Type -2 when you want to reset the system.");
	    System.out.println("Type 0 and then -4 when you want to refund.");
	    System.out.println();
	    
	    options = input.nextInt();
	    
	     if (options == -2) {
	    	Reset();
	     	}else{
	    Payment(options);
	    Purchase();
	    Display();
	    Decision();
	    
	    }
	}
	 public static void Payment(int options) {
		 if (options == 0) {
			 test1 = "Welcome Next Time";
			 System.out.println("Welcome Next Time");
		 	}
		 else if (options == -4) {
			 return;
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
		          case -4:
		        	break;
		          default:
		        	  System.out.println("Invalid Coins, Please enter new coins");
				 	}	
				}
		 			
		 	}else if (options!= -4 || options!=0 || options!=1 ) {
		 		System.exit(0); 
		 	}
		 
		 else {
			 System.out.println("Invalid Input. Please try again.");
		 	} 
	 	}
	 public static void Purchase() {
		 if(options == -4) {
			 return;
		 }
		 if(options == 0) {
			 test1 = "Thank you please come again next time.";
			 System.out.println("Thank you please come again next time.");
		 }else {
		    System.out.println("Please select your product.");
		    String productx = input.next();
		    if (productx.equals("-4")) {
		    	return;
		    }
		    char product1 =productx.charAt(0);
		    //product = product1.toLowerCase(); //a
		    int no = (int)product1-97;
		    	System.out.println(no);
		    String i_p = temp[no] ;
		    	System.out.println(i_p);
		    String i_price =productList1.get(i_p); //should be the price
		    double i_pp =Double.parseDouble(i_price)*100; 
		    balance +=  i_pp;
			   test2 = balance;
	 	}
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
	        	displayBoard = "Enter more money or come again next time.";
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
		  System.out.println("password");
		  String password = input.next();
		  if (password.equals("ty5j")) {
		  
					  productList1.clear();
					  productList2.clear();
					  productNum =0;
					  a = 65;
					  System.out.println("How many?");
					  //eg ( 1 )
					  productNum = input.nextInt();
					  System.out.println(productNum + " Enter your product names");
					  //eg. ( Fenta 0.75)
					  String name;
					  String price;
				  		int j=0;
				  		for (int i =1; i<productNum; i++) {
					  		name = input.next();
					  		price = input.next();
				  			productList1.put(name, price);
				  			j++;
				  		}
				  		
				  		name = input.next();
				  		price = input.next();
				  		productList1.put(name, price);
				  		System.out.println(productList1);
				  
				  		
				  		
				 System.out.println("options? Type -7 to start the system.");
				 options = input.nextInt();
				 if (options == -7) {
					 redirect(-7);
				 }
	  			}else {
			  System.exit(0);
		  }
	  	}
	  public static void redirect(int options) {
				a = 65;
				temp = new String[1000];
				x = 0;
				for (String i : productList1.keySet()) {
					char c = (char)a;
					System.out.println(c+ " "+i + " "+  productList1.get(i));
					a= a + 1;
					temp[x] = i;
					x++;
				}
				 System.out.println("Type 1 when you want to insert coins");
				    System.out.println("Type 0 when you finish inserting money.");
				    System.out.println("Type -2 when you want to reset the system.");
				    System.out.println("Type 0 and then -4 when you want to refund.");
				 options = input.nextInt();
				    
			     if (options == -2) {
			    	Reset();
			     	}else{
			    Payment(options);
			    Purchase();
			    Display();
			    Decision();
			     	}
	  			}
		  
	  
}
