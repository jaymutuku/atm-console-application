package com.simpleatm.app;

import java.util.Scanner;

public class ATM_Program {
	
	   protected static final double MAX_DEPOSIT_PER_DAY = 150000;
	   protected static final double MAX_DEPOSIT_PER_TRANSACTION = 40000;   
	   protected static final int MAX_DEPOSIT_FREQUENCY = 4;
	   
	   protected static final double MAX_WITHDRAWAL_PER_DAY = 50000;
	   protected static final double MAX_WITHDRAWAL_PER_TRANSACTION = 20000;
	   protected static final int MAX_WITHDRAWAL_FREQUENCY = 3;
	   
	   public static Scanner scanner = new Scanner(System.in);
	   
	    protected static final double currentBalance = 0;  	   

	   public static double deposit(double currentBalance, double depositAmount){
		   
		   currentBalance += depositAmount;
		   
		   System.out.printf("\nBalance %.2f\n",currentBalance);
		   
		   return currentBalance;
		   
	   }
	   
	   public  static double withdraw(double currentBalance,double withdrawAmount){
		   
		   currentBalance -= withdrawAmount;
		   
		   System.out.printf("\nBalance %.2f\n",currentBalance);
		   
		   return currentBalance;
		   
		  }

	   //validate maximum deposit amount
	   public static boolean verifyDeposit(double depositAmount,double currentBalance){
		   
		   boolean flag= true;   
		   
		    currentBalance += depositAmount;
		   		   
		   if(depositAmount > MAX_DEPOSIT_PER_TRANSACTION || currentBalance > MAX_DEPOSIT_PER_DAY ){
			   
			System.out.println("Error:Deposit Per Day Or Per Transaction Limit Exceeded!");
			  
			flag = false;
		   }
		   
		   return flag;
	   }
	   public static boolean verifyWithdrawal(double withdrawalAmount,double totalWithdrawalAmount){
		   
		    
		   boolean flag = true;
		   
		   totalWithdrawalAmount -= withdrawalAmount;
		   
		   if(withdrawalAmount > MAX_WITHDRAWAL_PER_TRANSACTION || totalWithdrawalAmount > MAX_WITHDRAWAL_PER_DAY){
			   
			   System.out.println("Error:Withdrawal Per Day Or Per Transaction Limit Exceeded!");
			   
			   flag= false;
		   }

		   
		   
		   return flag;
	   }
	   
	   
	   

	public static void main(String[] args) {
		int menuOption,depositCount = 0,withdrawCount = 0;
		
		double totalWithdrawalAmount = 0;
		
		double depositAmount = 0;
		double withdrawalAmount = 0;
		double currentBalance =300;
		
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
				  deposit(depositAmount,currentBalance);
				  break;
			//Deposit	  
			case 2:
				System.out.println("DEPOSIT");
				try {
				    if(depositCount < MAX_DEPOSIT_FREQUENCY)
				    {
					System.out.print("Enter deposit amount:");
					while(!scanner.hasNextDouble()){
						scanner.next();
					   }
					depositAmount = scanner.nextDouble();
					if(verifyDeposit(depositAmount,currentBalance)){
						 currentBalance = deposit(depositAmount,currentBalance);
						depositCount++;						
					    }
					
				     }
				
				    } catch (Exception ex) {
					
					System.out.printf("Exception",ex);
					
				}
				break;
			//Withdraw	
			case 3:
				System.out.println("WITHDRAWAL");
				  try {
					if(withdrawCount < MAX_WITHDRAWAL_FREQUENCY)
                       System.out.print("\nEnter withdraw amount:");
                     while(!scanner.hasNextDouble()){
                         scanner.next();
                     }
                      withdrawalAmount = scanner.nextDouble();
                      if(verifyWithdrawal(currentBalance,withdrawalAmount)){
					    currentBalance = withdraw(currentBalance,withdrawalAmount);
						withdrawCount++;					  
					  } 
                       else if(withdrawalAmount > currentBalance){
		   
		               System.out.println("Error:Withdrawal Amount exceeds current Balance!");     
                           return;
		                }		   			               
					  
				  } catch (Exception e) {
					  
					  System.out.printf("Exception", e);
				  }
				break;  
				  
				  
			//Quit
			case 4:
				 System.out.println("Are you sure you want to QUIT?(y/n)");
				 if(scanner.next().equals("y")){
					 System.exit(0);					 
				    }
					break;
					 
			default:
					System.out.println("Invalid Menu Option");
				     	 
				     }
				 } while(true);
				  
			}		

	}

   

 
	

   

 
	
