package com.simpleatm.app;

import java.util.Scanner;

public  class ATM_Program {      

       public static final double MAX_DEPOSIT_PER_DAY = 150000;
       public static  final double MAX_DEPOSIT_PER_TRANSACTION = 40000;    
       public static  final  int MAX_DEPOSIT_FREQUENCY = 4;
       
       public static final double MAX_WITHDRAWAL_PER_DAY = 50000;
       public static final double MAX_WITHDRAWAL_PER_TRANSACTION = 20000;
       public static final int MAX_WITHDRAWAL_FREQUENCY = 3;
       
       	public static double balance = 0;
       	protected static double totalDepositAmount = 0 ;
        protected static double totalWithdrawalAmount = 0 ;

        protected static int depositCount = 0;
        protected static int withdrawCount = 0;       
  
       
         public static Scanner scanner = new Scanner(System.in);		 

         public static double getBalance(){
         
         System.out.printf("\nBalance %.2f\n",balance);
         
         return balance;
         }	     

       public  static double deposit(double depositAmount){	   
       
           if(depositAmount <= 0) {
                System.out.println("Can't Deposit non positive amounts");
                
                return depositAmount;
                
            }else {
                  
                   balance += depositAmount;
                   System.out.println("Kes."+ depositAmount + " deposited");			   
           
                  }	
           
             return balance;	           
           
       } 
   
       public  static double withdraw(double withdrawAmount){
       
             if(withdrawAmount <=0 || withdrawAmount > balance|| withdrawAmount > MAX_WITHDRAWAL_PER_TRANSACTION){
             
                  System.out.println("Invalid input or Insufficient funds or withdrawal transaction limit exceeded");
				   
				   boolean quit = true;
				   
            } else {  
           
                 balance -= withdrawAmount;
                 System.out.println("Kes."+ withdrawAmount + " withdrawn");
            }
            return balance;		   	   
          }
		  
		
       //validate maximum deposit amount
       public static boolean verifyDeposit(double currentBalance,double depositAmount){   	    
           		   
           if(currentBalance > MAX_DEPOSIT_PER_DAY || depositAmount > MAX_DEPOSIT_PER_TRANSACTION ){
               
            System.out.println("Error:Deposit Per Day Or Per Transaction Limit Exceeded!");
              
            return false;
           }
           
           return true;
       }
       public static boolean verifyWithdrawal(double withdrawalAmount){	   
          
		   if(withdrawalAmount > MAX_WITHDRAWAL_PER_DAY){
		   
		       System.out.println("Error:Withdrawal Per Day Limit Exceeded!"); 

               return false;
			}                        		   
           
           return true;
       }	   

    public static void main(String[] args) {    	
        int menuOption; boolean quit = false;				

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
                 if(depositCount >= MAX_DEPOSIT_FREQUENCY)
                        System.out.println("MAXIMUM DEPOSIT FREQUENCY Reached");
                         quit = true;                        
                try {                                         
                    if(depositCount < MAX_DEPOSIT_FREQUENCY){
                    System.out.println("Enter deposit amount:");
                    while(!scanner.hasNextDouble()){
                        scanner.next();
                       }
                    totalDepositAmount = scanner.nextDouble();
                    if(verifyDeposit(balance,totalDepositAmount)){
                         balance = deposit(totalDepositAmount);
						 depositCount++;                       					
                         }	                    
                     }
                
                    } catch (Exception ex) {

                    System.out.println("DEPOSIT");				
                    
                    System.out.printf("Exception",ex);
                    
                }
                break;
            //Withdraw	
            case 3:
                  if(withdrawCount >= MAX_WITHDRAWAL_FREQUENCY)
                        System.out.println("MAXIMUM WITHDRAWAL FREQUENCY Reached");
                         quit = true;                   
                  try {                    
                    if(withdrawCount < MAX_WITHDRAWAL_FREQUENCY) {
                       System.out.println("Enter withdraw amount:");
                     while(!scanner.hasNextDouble()){
                         scanner.next();
                     }
                      totalWithdrawalAmount = scanner.nextDouble();
                      if(verifyWithdrawal(totalWithdrawalAmount)){
                        balance = withdraw(totalWithdrawalAmount);
                        withdrawCount++;					  
                        }                  
                     }                                                       
                      
                  } catch (Exception e) {
				    
					  System.out.println("WITHDRAWAL");
                      
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

   

 
    

   

 
    
