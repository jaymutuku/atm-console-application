package com.simpleatm.app;

import com.simpleatm.exceptions.InsufficientFundsException;

import java.util.Scanner;

public  class ATM_Program {      

        private   final double MAX_DEPOSIT_PER_DAY = 150000.00;
        private   final double MAX_DEPOSIT_PER_TRANSACTION = 40000.00;    
        private   final  int MAX_DEPOSIT_FREQUENCY = 4;
       
        private   final double MAX_WITHDRAWAL_PER_DAY = 50000.00;
        private   final double MAX_WITHDRAWAL_PER_TRANSACTION = 20000.00;
        private   final int MAX_WITHDRAWAL_FREQUENCY = 3;
       
       	public   double totalBalance;
        
        public   double totalWithdrawAmount;         

        public  double totalDepositAmount;
         
        public  static Scanner input = new Scanner(System.in);
        
        //constructor
        public ATM_Program(){
        	totalBalance = 0.00;
        	totalWithdrawAmount = 0.00;
        	totalDepositAmount = 0.00;
        	
        }
        
        
       public  double getBalance(){
         
         System.out.printf("\nCurrent Balance:%.2f\n",totalBalance);
         
         return totalBalance;
         }

       public   double getMaximumDepositPerDay(){
       System.out.printf("\nMaximum Deposit Per Day is %.2f\n",MAX_DEPOSIT_PER_DAY);
       	return MAX_DEPOSIT_PER_DAY;
       }

       public   double getMaximumDepositPerTransaction(){
       System.out.printf("\nMaximum Deposit Per Transaction is %.2f\n",MAX_DEPOSIT_PER_TRANSACTION);

        return MAX_DEPOSIT_PER_TRANSACTION;
       }

       public   int getMaximumDepositFrequency(){

        return MAX_DEPOSIT_FREQUENCY;
       } 

       public  double getMaximumWithdrawPerDay(){
        
        System.out.printf("\nMaximum Withdraw Per Day is %.2f\n",MAX_WITHDRAWAL_PER_DAY);
       	return MAX_WITHDRAWAL_PER_DAY;
       }

       public   double getMaximumWithdrawPerTransaction(){

       System.out.printf("\nMaximum Withdraw Per Transaction is %.2f\n",MAX_WITHDRAWAL_PER_TRANSACTION);
        return MAX_WITHDRAWAL_PER_TRANSACTION;
       }
       public   int getMaximumWithdrawalFrequency(){

        return MAX_WITHDRAWAL_FREQUENCY;
       }  

       public   double getTotalWithdrawals(){    

        System.out.printf("\nTotal Withdrawals:%.2f\n",totalWithdrawAmount);

        return totalWithdrawAmount;

       }
       public  double getTotalDeposits(){ 

       	System.out.printf("\nTotal Deposits:%.2f\n",totalDepositAmount);

       	return totalDepositAmount;
       }
      
       public   boolean verifyDeposit(double depositAmount){       	   
 
       	if(depositAmount <= 0) {              

                  return false; 
                
                   } else if(depositAmount > MAX_DEPOSIT_PER_TRANSACTION){

                  return false;               
                   }       	     	
                          
       	if(totalDepositAmount > MAX_DEPOSIT_PER_DAY){
       	    
             return false;                                                           	
           }         
              return true;       
       }
       

       public   double deposit(double depositAmount){                              	   
       
           if(depositAmount <= 0) {
                System.out.println("Can't Deposit non positive amounts");

                  return totalBalance; 
                
                   } else if(depositAmount > MAX_DEPOSIT_PER_TRANSACTION){
                System.out.println("Error:Deposit Per Transaction Limit Exceeded!");                
                  
                  return totalBalance;               
                   }     
                  
                  totalDepositAmount += depositAmount;
                  
                    if(totalDepositAmount > MAX_DEPOSIT_PER_DAY){
                System.out.println("Error:Deposit Per Day Limit Exceeded!");
                
  
                   return totalBalance;                                
                  
                   } else {

                   	totalBalance += depositAmount;               
                          }          	
           
             return totalBalance;           
       }

       public  boolean verifyWithdraw(double withdrawAmount){   	

        if(withdrawAmount <=0 || withdrawAmount > totalBalance){
             
                   return false;
				   
                }else if(withdrawAmount > MAX_WITHDRAWAL_PER_TRANSACTION){

                  return false;

                }
                                      
                
        if(totalWithdrawAmount > MAX_WITHDRAWAL_PER_DAY){
            
            return false;                       
           
           }
            return true;
       }
       
       public  boolean verifyBalance(double balance,double depositAmount,double withdrawAmount){
    	   
    	   balance = totalBalance;
    	   depositAmount = totalDepositAmount;
    	   withdrawAmount = totalWithdrawAmount;
    		   
    	   if(balance != depositAmount - withdrawAmount){
    		   
    		   return false; 
    		   
    	   }

    	 return true;  
       }
       
   
       public   double withdraw(double withdrawAmount) throws InsufficientFundsException{                   	      
       
             if(withdrawAmount <=0 || withdrawAmount > totalBalance){             
                                    
            	 throw new InsufficientFundsException("Invalid input or Insufficient funds"); 
                  
                } 
				   
                if(withdrawAmount > MAX_WITHDRAWAL_PER_TRANSACTION){

                  System.out.println("Error:Withdrawal Per Transaction Limit Exceeded!");
                  
                  return totalBalance;

                }
                totalWithdrawAmount += withdrawAmount;            
                                            
                if(totalWithdrawAmount > MAX_WITHDRAWAL_PER_DAY){
		   
		       System.out.println("Error:Withdrawal Per Day Limit Exceeded!"); 
               

               return totalBalance;

			   } else {

			   	totalBalance = totalBalance - withdrawAmount;

			   }              
            
            return totalBalance;			   	   
          }


		  
    public static void main(String[] args) {
    	
    	ATM_Program atm = new ATM_Program();

        int menuOption; int depositCount = 0; int withdrawCount = 0;      				

        do {
            System.out.println("************************************************");
            System.out.println("1.Balance");
            System.out.println("2.Deposit");
            System.out.println("3.Withdraw");
            System.out.println("4.Quit");
            System.out.println("************************************************");
            System.out.print("Enter Menu Option(and press Enter):");
            
            while(!input.hasNext()){
                input.next();
            }
            menuOption = input.nextInt();
            
            switch(menuOption){
            //Balance
            case 1:
                System.out.println("BALANCE");
                  atm.getBalance();
                  break;
            //Deposit	  
            case 2:                 
                 if(depositCount >= atm.MAX_DEPOSIT_FREQUENCY){
                        System.out.println("MAXIMUM DEPOSIT FREQUENCY Reached");

                       } else {                     
                    System.out.println("DEPOSIT");
                    atm.getBalance();   
                    System.out.print("Enter deposit amount:");

                    while(!input.hasNextDouble()){
                         input.next();
                         
                     }                       
                    double amountToDeposit = input.nextDouble();

                     if(atm.verifyDeposit(amountToDeposit)){
                     atm.totalBalance = atm.deposit(amountToDeposit);
                     atm.getTotalDeposits();
                     depositCount++;
                     }
                       
                  } 
                   break;
            //Withdraw	
            case 3:
                  if(withdrawCount >= atm.MAX_WITHDRAWAL_FREQUENCY){
                        System.out.println("MAXIMUM WITHDRAWAL FREQUENCY Reached");
                         
                     } else {                      
                       System.out.println("WITHDRAWAL");
                       atm.getBalance();
                       System.out.print("Enter withdraw amount:");
                       
                     while(!input.hasNextDouble()){
                         input.next();
                         
                     }
                     double amountToWithdraw = input.nextDouble();
                     
                     try {
                      if(atm.verifyWithdraw(amountToWithdraw)){
                          atm.totalBalance = atm.withdraw(amountToWithdraw);
                          withdrawCount++;
                          atm.getTotalWithdrawals();
                           
                        }
                     }catch (InsufficientFundsException ex){
                    	 
                    	 System.out.println(ex.getMessage());
                       }
                      
                    }
                    
                break;                  
            //Quit
            case 4:
                try {
                 System.out.print("Are you sure you want to QUIT?(y/n)");
                 if(input.next().equals("y")){
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
