package com.simpleatm.app;

import java.util.Scanner;

public  class ATM_Program {      

        private  static final double MAX_DEPOSIT_PER_DAY = 150000.00;
        private  static final double MAX_DEPOSIT_PER_TRANSACTION = 40000.00;    
        private  static final  int MAX_DEPOSIT_FREQUENCY = 4;
       
        private  static final double MAX_WITHDRAWAL_PER_DAY = 50000.00;
        private  static final double MAX_WITHDRAWAL_PER_TRANSACTION = 20000.00;
        private  static final int MAX_WITHDRAWAL_FREQUENCY = 3;
       
       	public static  double totalBalance = 0.00;
        
        public static  double totalWithdrawAmount = 0.00;         

        public static double totalDepositAmount = 0.00;
         
        public  static Scanner input = new Scanner(System.in);
        
        
       public static double getBalance(){
         
         System.out.printf("\nCurrent Balance:%.2f\n",totalBalance);
         
         return totalBalance;
         }

       public  static double getMaximumDepositPerDay(){
       System.out.printf("\nMaximum Deposit Per Day is %.2f\n",MAX_DEPOSIT_PER_DAY);
       	return MAX_DEPOSIT_PER_DAY;
       }

       public  static double getMaximumDepositPerTransaction(){
       System.out.printf("\nMaximum Deposit Per Transaction is %.2f\n",MAX_DEPOSIT_PER_TRANSACTION);

        return MAX_DEPOSIT_PER_TRANSACTION;
       }

       public  static int getMaximumDepositFrequency(){

        return MAX_DEPOSIT_FREQUENCY;
       } 

       public  static double getMaximumWithdrawPerDay(){
        
        System.out.printf("\nMaximum Withdraw Per Day is %.2f\n",MAX_WITHDRAWAL_PER_DAY);
       	return MAX_WITHDRAWAL_PER_DAY;
       }

       public  static double getMaximumWithdrawPerTransaction(){

       System.out.printf("\nMaximum Withdraw Per Transaction is %.2f\n",MAX_WITHDRAWAL_PER_TRANSACTION);
        return MAX_WITHDRAWAL_PER_TRANSACTION;
       }
       public  static int getMaximumWithdrawalFrequency(){

        return MAX_WITHDRAWAL_FREQUENCY;
       }  

       public static  double getTotalWithdrawals(){    

        System.out.printf("\nTotal Withdrawals:%.2f\n",totalWithdrawAmount);

        return totalWithdrawAmount;

       }
       public static double getTotalDeposits(){ 

       	System.out.printf("\nTotal Deposits:%.2f\n",totalDepositAmount);

       	return totalDepositAmount;
       }
      
       public  static boolean verifyDeposit(double depositAmount){       	   
 
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
       

       public  static double deposit(double depositAmount){                              	   
       
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

       public  static boolean verifyWithdraw(double withdrawAmount){   	

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
       
       public static boolean verifyBalance(double totalBalance,double totalDeposits,double totalWithdraws){      	    
    		   
    	   if(!(totalBalance == deposit(totalDeposits) - withdraw(totalWithdraws))){
    		   
    		   return false; 
    		   
    	   } 
    	   
    	 return true;  
       }
       
   
       public  static double withdraw(double withdrawAmount){                   	      
       
             if(withdrawAmount <=0 || withdrawAmount > totalBalance){
             
                  System.out.println("Invalid input or Insufficient funds");

                  return totalBalance;
				   
                }else if(withdrawAmount > MAX_WITHDRAWAL_PER_TRANSACTION){

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
                  getBalance();
                  break;
            //Deposit	  
            case 2:                 
                 if(depositCount >= MAX_DEPOSIT_FREQUENCY){
                        System.out.println("MAXIMUM DEPOSIT FREQUENCY Reached");

                       } else {                     
                    System.out.println("DEPOSIT");
                    getBalance();   
                    System.out.print("Enter deposit amount:");

                    while(!input.hasNextDouble()){
                         input.next();
                         
                     }                       
                    double amountToDeposit = input.nextDouble();

                     if(verifyDeposit(amountToDeposit)){
                     totalBalance = deposit(amountToDeposit);
                     getTotalDeposits();
                     depositCount++;
                     }
                       
                  } 
                   break;
            //Withdraw	
            case 3:
                  if(withdrawCount >= MAX_WITHDRAWAL_FREQUENCY){
                        System.out.println("MAXIMUM WITHDRAWAL FREQUENCY Reached");
                         
                     } else {                      
                       System.out.println("WITHDRAWAL");
                       getBalance();
                       System.out.print("Enter withdraw amount:");
                       
                     while(!input.hasNextDouble()){
                         input.next();
                         
                     }
                     double amountToWithdraw = input.nextDouble();
                      
                      if(verifyWithdraw(amountToWithdraw)){
                          totalBalance = withdraw(amountToWithdraw);
                          withdrawCount++;
                          getTotalWithdrawals();
                           
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
