package com.simpleatm.test;

import com.simpleatm.app.ATM_Program;

import org.junit.Test;
//import org.junit.Before;
//import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
//import org.junit.Ignore;

public class SimpleATMTests {

	//DEPOSITS
	//verify user can deposit 32k if account has balance = 0
	@Test
	public void testDeposit(){
	System.out.println("1.Test:deposit(depositAmount)");	
	assertTrue(ATM_Program.verifyDeposit(0,32000));	
	}
    //verify user cannot deposit 10k if account has 150k (Max deposit per day)	
	@Test
	public void testMaxDepositPerDay(){
	System.out.println("2.Test:Maximum Deposits Per Day");	
	assertFalse(ATM_Program.verifyDeposit(150000,ATM_Program.deposit(10000)));
	}
	//verify user cannot deposit more than 40k per transaction
	@Test
	public void testMaxDepositPerTransaction(){
	System.out.println("3.Test:Maximum Deposits Per Transaction");	
	assertFalse(ATM_Program.verifyDeposit(4000,ATM_Program.deposit(44000)));		
	}
	//Verify Maximum Deposit Frequency is 4
	@Test
	public void testMaxDepositFrequency(){
	System.out.println("4.Test:Maximum Deposit Frequency");	
	assertEquals(4,ATM_Program.MAX_DEPOSIT_FREQUENCY);	
	}
	
	//WITHDRAWALS TESTS
	
	//verify user can withdraw 8K in account
	@Test
	public void testWithdrawal(){		
	System.out.println("5.Test:withdraw(withdrawAmount)");	
	 assertTrue(ATM_Program.verifyWithdrawal(8000));
	}
	//verify user cannot withdraw more than 50k per day	
	@Test
	public  void testMaxWithdrawalPerDay(){		
	System.out.println("6.Test:Maximum Withdrawals Per Day");	
    assertEquals(false,ATM_Program.verifyWithdrawal(55000));	
	}
	//verify user cannot withdraw more than 20k per transaction	
	@Test
	public  void testMaxWithdrawalPerTransaction(){
		System.out.println("7.Test:Maximum Withdrawals Per Transaction");
        assertEquals(true,(ATM_Program.verifyWithdrawal(22000)));
    }
	//Verify Maximum Withdrawal Frequency is 3
	@Test
	public  void testMaxWithdrawalFrequency(){
		System.out.println("8.Test:Maximum Withdrawals Frequency");
		assertEquals(3,ATM_Program.MAX_WITHDRAWAL_FREQUENCY);		
	  }

}
	



