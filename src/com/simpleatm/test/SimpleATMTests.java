package com.simpleatm.test;

import com.simpleatm.app.ATM_Program;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class SimpleATMTests extends ATM_Program {
	
	//DEPOSITS TESTS
	//
	@Test
	public void testDeposit(){
	System.out.println("Test:deposit(depositAmount)");	
	assertTrue(ATM_Program.verifyDeposit(ATM_Program.getBalance(),ATM_Program.deposit(32000)));	
	}
    //verify user cannot deposit more than 150k per day
	@Test
	public void testMaxDepositPerDay(){
	System.out.println("Test:Maximum Deposits Per Day");
	assertFalse(ATM_Program.verifyDeposit(160000,ATM_Program.MAX_DEPOSIT_PER_DAY));
	}
	//verify user cannot deposit more than 40k per transaction
	@Test
	public void testMaxDepositPerTransaction(){
	System.out.println("Test:Maximum Deposits Per Transaction");
	assertFalse(ATM_Program.verifyDeposit(ATM_Program.MAX_DEPOSIT_PER_TRANSACTION,ATM_Program.deposit(44000)));		
	}
	//Verify Maximum Deposit Frequency is 4
	@Test
	public void testMaxDepositFrequency(){
	System.out.println("Test:Maximum Deposit Frequency");	
	assertEquals(4,ATM_Program.MAX_DEPOSIT_FREQUENCY);	
	}
	
	//WITHDRAWALS TESTS
	
	//verify user can withdraw 8K if she has 15K in account
	@Test
	public void testWithdrawal(){		
	System.out.println("Test:withdraw(withdrawAmount)");	 
	 assertTrue(ATM_Program.verifyWithdrawal(ATM_Program.getBalance(),ATM_Program.withdraw(8000)));
	}
	//verify user cannot withdraw more than 50k per day
	@Test
	public  void testMaxWithdrawalPerDay(){		
	System.out.println("Test:Maximum Withdrawals Per Day");
    assertEquals(false,ATM_Program.verifyWithdrawal(55000,ATM_Program.MAX_WITHDRAWAL_PER_DAY));	
	}
	//verify user cannot withdraw more than 20k per transaction
	@Test
	public  void testMaxWithdrawalPerTransaction(){
		System.out.println("Test:Maximum Withdrawals Per Transaction");
    assertEquals(false,ATM_Program.verifyWithdrawal(22000,ATM_Program.MAX_WITHDRAWAL_PER_TRANSACTION));		
	}
	//Verify Maximum Withdrawal Frequency is 3
	@Test
	public  void testMaxWithdrawalFrequency(){
		System.out.println("Test:Maximum Withdrawals Frequency");
		assertEquals(3,ATM_Program.MAX_WITHDRAWAL_FREQUENCY);		
	  }

}
	



