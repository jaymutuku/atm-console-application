package com.simpleatm.test;

import com.simpleatm.app.ATM_Program;
import com.simpleatm.exceptions.InsufficientFundsException;


import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

//import org.junit.Ignore;

public class SimpleATMTests {
	
	ATM_Program atm;
	
		
	 double balance;
	 double deposits;
	 double withdraws;
	
	
	@Before
	public void setUp(){
		
		atm = new ATM_Program();
	
	
	}
	
	
	@After
	public void tearDown(){
		balance = atm.getBalance();
		deposits = atm.getTotalDeposits();
		withdraws = atm.getTotalWithdrawals();
		
		atm = null;
		
		
	}
	
	
	//DEPOSITS	
	
	@Test
	public void testDeposit(){
	System.out.println("1.Test:deposit(depositAmount)");	
    //this should add 5k to total balance & total deposits but since max deposit is reached,assert false
   
	assertTrue(atm.verifyDeposit(atm.deposit(5000)));
	
	}
	
	
	
	@Test
	//depositing negative figures
	public void testDepositNonPositiveAmounts(){
	System.out.println("10:Test:deposit negative numbers");	
	assertFalse(atm.verifyDeposit(atm.deposit(-100)));	
	}

   
	@Test
	public void testMaximumDepositPerTransaction(){
	System.out.println("3.Test:Maximum Deposits Per Transaction");	
	assertFalse(atm.verifyDeposit(atm.deposit(41000.00)));		
	}
	
	//Verify Maximum Deposit Frequency is 4
	@Test
	public void testMaximumDepositFrequency(){
	System.out.println("4.Test:Maximum Deposit Frequency");	
	assertEquals(4,atm.getMaximumDepositFrequency());	
	}

	//WITHDRAWALS TESTS
	
	 
	
	@Test(expected = InsufficientFundsException.class)
	public void testWithdrawal() throws InsufficientFundsException{		
	System.out.println("5.Test:withdraw(withdrawAmount)");
	
		
	assertTrue(atm.verifyWithdraw(atm.withdraw(7000)));
	
	}
	
	
	
	@Test
	public void testMaximumDepositPerDay() {
    System.out.println("Test:Maximum  Deposits Per Day ");    
    
    atm.verifyDeposit(atm.deposit(40000));
    atm.verifyDeposit(atm.deposit(40000));
    atm.verifyDeposit(atm.deposit(40000));
    //trying to deposit more 40k should return deposit per day limit error >150k
    //i.e Total Deposits = 160K
    assertFalse(atm.verifyDeposit(atm.deposit(40000)));
    
    
	}
	
	
	@Test(expected = InsufficientFundsException.class)
	public void testMaximumWithdrawalPerDay() throws InsufficientFundsException{
    System.out.println("Test:Maximum Withdrawals Per Day ");    
    
    atm.verifyWithdraw(atm.withdraw(20000));    
    atm.verifyWithdraw(atm.withdraw(20000));
    //i.e Total Withdraws = 60k
    //trying to withdraw more 20k should return withdraw per day limit error >50k
    assertFalse(atm.verifyWithdraw(atm.withdraw(20000)));
    
	}
	
	
	
	//verify user cannot withdraw more than 20k per transaction	
	@Test
	public  void testMaximumWithdrawalPerTransaction(){
		System.out.println("7.Test:Maximum Withdrawals Per Transaction");
		assertFalse("error withdraw per transaction > 20k",atm.verifyWithdraw(22000));
    }
    
    
	
	//Verify Maximum Withdrawal Frequency is 3
	@Test
	public  void testMaximumWithdrawalFrequency(){
		System.out.println("8.Test:Maximum Withdrawals Frequency");
		assertEquals(3,atm.getMaximumWithdrawalFrequency());		
	  }
	  	
	  
	
	 //BALANCE TESTS
	//verify user can withdraw if balance > withdraw amount
	
	@Test
	public void testBalance()throws InsufficientFundsException{
		
		System.out.println("11.Test Balance");
		
		double deposit = atm.deposit(20000);
		double withdraw = atm.withdraw(19000);
		
	   assertEquals(true,atm.verifyBalance(1000,deposit,withdraw));		
			
	}
		
	@Test
	public void testBalanceDepositGreaterThanWithdraw() throws InsufficientFundsException {
		
		System.out.println("13.Test Balance:Deposit = 4700 < Withdraw = 1300");		
		
		assertTrue(atm.verifyBalance(3400, atm.deposit(4700),atm.withdraw(1300)));
	}
	//Expected InsufficientFundsException
	@Test(expected = InsufficientFundsException.class)
	public void testBalanceWithdrawGreaterThanDeposit()throws InsufficientFundsException {
		
		System.out.println("12.Test Balance:Deposit = 1500 < Withdraw = 4000");		
		
		assertFalse(atm.verifyBalance(2500, atm.deposit(1500),atm.withdraw(4000)));
	}
	

}
	



