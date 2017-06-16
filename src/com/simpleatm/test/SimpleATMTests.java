package com.simpleatm.test;

import com.simpleatm.app.ATM_Program;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class SimpleATMTests extends ATM_Program {
	
	
	@Test
	public void testDeposit(){
	System.out.println("Method:deposit(currentBal,depositAmount)");	
	assertEquals(true,ATM_Program.verifyDeposit(32000,ATM_Program.MAX_DEPOSIT_PER_TRANSACTION));	
	}
	
	@Test
	public void testWithdrawal(){
	System.out.println("Method:withdraw(currentBalance,withdrawAmount)");
	 //assertEquals(ATM_Program.withdraw(32000,7000));
	 assertEquals(true,ATM_Program.verifyWithdrawal(15000,ATM_Program.MAX_WITHDRAWAL_PER_TRANSACTION));
	}
	

	@Test
	public void testMaxDepositPerDay(){
	System.out.println("Test Deposits:Verify User Cannot Deposit More than Max Per Day:Maximum is 150k");
	assertEquals(false,ATM_Program.verifyDeposit(160000,ATM_Program.MAX_DEPOSIT_PER_TRANSACTION));
	}
	@Test
	public void testMaxDepositPerTransaction(){
	System.out.println("Test Deposits:Verify User Cannot Deposit More than Max Per Trans:Maximum is 40k");

	assertEquals(true,ATM_Program.verifyDeposit(32000,ATM_Program.deposit(0,32000)));	
		
	}
	@Test
	public void testMaxDepositFrequency(){
	System.out.println("Test Deposits:Verify User Cannot Deposit More than Max Frequency:Maximum is 4");
	
	assertEquals(4,ATM_Program.MAX_DEPOSIT_FREQUENCY);	
	}
	
	@Test
	public  void testMaxWithdrawalPerDay(){
	System.out.println("Test Maximum Withdrawals Per Day:Maximum is 50k");
	assertEquals(false,ATM_Program.verifyWithdrawal(75000,ATM_Program.MAX_WITHDRAWAL_PER_DAY));
	}
	@Test
	public  void testMaxWithdrawalPerTransaction(){
		System.out.println("Test Maximum Withdrawals Per Transaction:Maximum is 20k");
		assertEquals(false,ATM_Program.verifyWithdrawal(21000,ATM_Program.MAX_WITHDRAWAL_PER_TRANSACTION));
	}
	
	@Test
	public  void testMaxWithdrawalFrequency(){
		System.out.println("Test Maximum Withdrawals Frequency:Maximum is 3");
		assertEquals(3,ATM_Program.MAX_WITHDRAWAL_FREQUENCY);		
	  }
		
	}
	


