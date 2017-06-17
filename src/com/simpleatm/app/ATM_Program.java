package com.simpleatm.app;

import java.util.Scanner;

public class ATM_Program {

       protected static final double MAX_DEPOSIT_PER_DAY = 150000;
	   protected static final double MAX_DEPOSIT_PER_TRANSACTION = 40000;    
	   protected static final int MAX_DEPOSIT_FREQUENCY = 4;
	   
	   protected static final double MAX_WITHDRAWAL_PER_DAY = 50000;
	   protected static final double MAX_WITHDRAWAL_PER_TRANSACTION = 20000;
	   protected static final int MAX_WITHDRAWAL_FREQUENCY = 3;
	   
	    protected static double currentBalance;
	   	protected static double depositAmount;
		protected static double withdrawalAmount;

        protected static int depositCount;
		protected static int withdrawCount;		

       public ATM_Program (){
	
	    currentBalance = 0;
	    depositAmount = 0;
		withdrawalAmount = 0;

        depositCount = 0;
		withdrawCount = 0;	
	   
	   } 
	   
	     public static Scanner scanner = new Scanner(System.in);

         public static double getBalance(){
		 
		 System.out.printf("\nBalance %.2f\n",currentBalance);
		 
		 return currentBalance;
         }	     

	   public static double deposit(double depositAmount){	   
	   
	       if(depositAmount <= 0) {
		        System.out.println("Can't Deposit non positive amounts");
				
				return getBalance();
				
		    }else {
			      
                   currentBalance += depositAmount;
                   System.out.println("Kes."+ depositAmount + " deposited");			   
		   
		          }
           
             return currentBalance;		   
		   
	   } 
   
	   public  static double withdraw(double withdrawAmount){
	   
	         if(withdrawAmount <=0 || withdrawAmount > currentBalance){
			 
			      System.out.println("Insufficient funds or Invalid input");
				  
				  return getBalance();
			} else {  
		   
		         currentBalance -= withdrawAmount;
				 System.out.println("Kes."+ withdrawAmount + " withdrawn");
		    }
            return currentBalance;		   	   
		  }

	   //validate maximum deposit amount
	   public static boolean verifyDeposit(double currentBalance,double depositAmount){   	    
		   		   
		   if(currentBalance > MAX_DEPOSIT_PER_DAY || depositAmount > MAX_DEPOSIT_PER_TRANSACTION ){
			   
			System.out.println("Error:Deposit Per Day Or Per Transaction Limit Exceeded!");
			  
			return false;
		   }
		   
		   return true;
	   }
	   public static boolean verifyWithdrawal(double withdrawalAmount,double totalWithdrawalAmount){	   
		   
		   if(withdrawalAmount > MAX_WITHDRAWAL_PER_TRANSACTION || totalWithdrawalAmount > MAX_WITHDRAWAL_PER_DAY){
			   
			   System.out.println("Error:Withdrawal Per Day Or Per Transaction Limit Exceeded!");
			   
			   return false;
			   }
		                 		   
		   
		   return true;
	   }	   

	public static void main(String[] args) {
		int menuOption;				

		do {
			System.out.println("************************************************");
			System.out.println("1.Balance");
			System.out.println("2.Deposit");
			System.out.println("3.Withdraw");
			System.out.println("4.Quit");
			System.out.println("************************************************");
			System.out.print("Enter Menu Option(and press Enter):");
			
			while(!scanner.hasNext()){
				scanner.next();
			}
			menuOption = scanner.nextInt();
			
			switch(menuOption){
			//Balance
			case 1:
				System.out.println("BALANCE");
				  getBalance();
				  break;
			//Deposit	  
			case 2:
				
				try {
				     System.out.println("DEPOSIT");
					 
				    if(depositCount < MAX_DEPOSIT_FREQUENCY)
				    {
					System.out.println("Enter deposit amount:");
					while(!scanner.hasNextDouble()){
						scanner.next();
					   }
					depositAmount = scanner.nextDouble();
					if(verifyDeposit(currentBalance,depositAmount)){
						 currentBalance = deposit(depositAmount);
						depositCount++;						
					    }						
					
				     }
				
				    } catch (Exception ex) {
					
					System.out.printf("Exception",ex);
					
				}
				break;
			//Withdraw	
			case 3:
				
				  try {
				    System.out.println("WITHDRAWAL");
					
					if(withdrawCount < MAX_WITHDRAWAL_FREQUENCY)
                       System.out.println("Enter withdraw amount:");
                     while(!scanner.hasNextDouble()){
                         scanner.next();
                     }
                      withdrawalAmount = scanner.nextDouble();
                      if(verifyWithdrawal(currentBalance,withdrawalAmount)){
					    currentBalance = withdraw(withdrawalAmount);
						withdrawCount++;					  
					  }
                            			               
					  
				  } catch (Exception e) {
					  
					  System.out.printf("Exception", e);
				  }
				break; 				  
				  
			//Quit
			case 4:
			    try {
				 System.out.println("Are you sure you want to QUIT?(y/n)");
				 if(scanner.next().equals("y")){
					 System.exit(0);					 
				    }
				} catch (Exception ex){
				
				    System.out.printf("Exception",ex);
				}
					break;
					 
			default:
					System.out.println("Invalid Menu Option");
				     	 
				     }
				 } while(true);
				  
			}		

	}

   

 
	

   

 
	
