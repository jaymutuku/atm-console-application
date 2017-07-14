package com.simpleatm.test;

import com.simpleatm.app.ATM_Program;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import org.junit.BeforeClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import org.junit.Ignore;

public class SimpleATMTests {
	
	 double balance;
	 double deposits;
	 double withdraws;
	
	
	@Before
	public void setUp(){
		
	balance = 0.00;
	deposits = 0.00;
	withdraws = 0.00;

		
	}
	
	
	@After
	public void tearDown(){
		balance = ATM_Program.getBalance();
		deposits = ATM_Program.getTotalDeposits();
		withdraws = ATM_Program.getTotalWithdrawals();
		
	}
	
	
	//DEPOSITS	
	
	@Test
	public void testDeposit(){
	System.out.println("1.Test:deposit(depositAmount)");	
    //this should add 5k to total balance & total deposits but since max deposit is reached,assert false
   
	ATM_Program.deposit(5000);
	
	}
	
	@Test
	//depositing negative figures
	public void testDepositNonPositiveAmounts(){
	System.out.println("10:Test:deposit negative numbers");	
	assertFalse(ATM_Program.verifyDeposit(ATM_Program.deposit(-100)));	
	}

   
	@Test
	public void testMaxDepositPerTransaction(){
	System.out.println("3.Test:Maximum Deposits Per Transaction");	
	assertFalse(ATM_Program.verifyDeposit(ATM_Program.deposit(41000.00)));		
	}
	
	//Verify Maximum Deposit Frequency is 4
	@Test
	public void testMaxDepositFrequency(){
	System.out.println("4.Test:Maximum Deposit Frequency");	
	assertEquals(4,ATM_Program.getMaximumDepositFrequency());	
	}

	//WITHDRAWALS TESTS
	
	//verify user cannot withdraw 20k from account-check we deposited 19k in acc with bal 0
    
	@Test
	public void testWithdrawal(){		
	System.out.println("5.Test:withdraw(withdrawAmount)");
	
	ATM_Program.withdraw(7000);
	}
	
	@Test
	public void testMaxWithdrawalAndDepositPerDay(){
    System.out.println("6b.Test:Maximum Withdrawals & Deposits Per Day Again");    
    
    ATM_Program.deposit(40000);    
    ATM_Program.deposit(40000);
    ATM_Program.deposit(40000);
    ATM_Program.deposit(40000);

    
    ATM_Program.withdraw(20000);    
    ATM_Program.withdraw(20000);    
    ATM_Program.withdraw(20000);

	}	
	
	//verify user cannot withdraw more than 20k per transaction	
	@Test
	public  void testMaxWithdrawalPerTransaction(){
		System.out.println("7.Test:Maximum Withdrawals Per Transaction");
		assertFalse("error withdraw per trans > 20k",ATM_Program.verifyWithdraw(22000));
    }
    
    
	
	//Verify Maximum Withdrawal Frequency is 3
	@Test
	public  void testMaxWithdrawalFrequency(){
		System.out.println("8.Test:Maximum Withdrawals Frequency");
		assertEquals(3,ATM_Program.getMaximumWithdrawalFrequency());		
	  }
	  	
	  
	
	 //BALANCE TESTS
	//verify user can withdraw if balance > withdraw amount
	
	@Test
	public void testBalance(){
		
		System.out.println("11.Test Balance");
		ATM_Program.deposit(20000);
		ATM_Program.withdraw(19000);		
			
	}
	
	@Test
	public void testBalanceWithdrawGreaterThanDeposit(){
		
		System.out.println("12.Test Balance Again:Deposit = 1500 < Withdraw = 4000");		
		
		assertFalse(ATM_Program.verifyBalance(2500, 1500, 4000));
	}
		

}
	



