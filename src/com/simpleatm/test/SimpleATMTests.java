package com.simpleatm.test;

import com.simpleatm.app.ATM_Program;

import java.io.IOException;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
		

//import org.junit.Ignore;

public class SimpleATMTests {
	
	ATM_Program atm;
	
	
	@Before
	public void setUp(){
		
		atm = new ATM_Program();
	
	
	}
	
	
	@After
	public void tearDown(){
		
		atm = null;
		
		
	}
	
	
	//DEPOSITS	
	
	@Test
	public void testDeposit()throws IOException,Exception{
	System.out.println("1.Test:deposit(depositAmount)");	
    //this should add 5k to total balance & total deposits but since max deposit is reached,assert false
   
	atm.deposit(5000);

	assertTrue(atm.getBalance()==5000.00);
	
	}
	
	
	
	@Test(expected = IOException.class)
	//depositing negative figures
	public void testDepositNonPositiveAmounts()throws IOException,Exception{
	System.out.println("10:Test:deposit negative numbers");	
	atm.deposit(-100);

	assertTrue(atm.getBalance()== 0.00);
	assertTrue(atm.getBalance()!= -100.00);	
	}
    
   
	@Test(expected = IOException.class)
	public void testMaximumDepositPerTransaction()throws IOException,Exception{
	System.out.println("3.Test:Maximum Deposits Per Transaction");	
	atm.deposit(41000.00);

	assertTrue(atm.getBalance()==0.00);

	assertFalse(atm.getBalance()==41000.00);		
	}
	
	//Verify Maximum Deposit Frequency is 4
	@Test(expected = IOException.class)
	public void testMaximumDepositFrequency()throws IOException,Exception{
	System.out.println("4.Test:Maximum Deposit Frequency");	
	
     atm.deposit(100);
     atm.deposit(200);
     atm.deposit(300);
     atm.deposit(400);

     assertTrue(atm.getBalance()==1000.00);
     //depositing 5th time
     atm.deposit(500);
     assertFalse(atm.getBalance()==1500.00);   

	}
     
	//WITHDRAWALS TESTS
	 
	
	@Test
	public void testWithdrawal() throws IOException,Exception{		
	System.out.println("5.Test:withdraw(withdrawAmount)");
	
	atm.deposit(10000);	
	atm.withdraw(7000);

	assertTrue(atm.getBalance()==3000.00);
	
	}
	
	
	@Test(expected = Exception.class)
	public void testMaximumDepositPerDay()throws IOException,Exception {
    System.out.println("Test:Maximum  Deposits Per Day ");    
    
    atm.deposit(40000);
    atm.deposit(40000);
    atm.deposit(40000);
    assertTrue(atm.getBalance()==120000.00); 

    //trying to deposit more 40k should return deposit per day limit error >150k
    //i.e Total Deposits = 160K
    atm.deposit(40000);
    assertFalse(atm.getBalance()==160000.00);    
    
	}
	
	@Test(expected = Exception.class)
	public void testMaximumWithdrawalPerDay() throws IOException,Exception{
    System.out.println("Test:Maximum Withdrawals Per Day ");

    atm.withdraw(20000);    
    atm.withdraw(20000);
    //i.e Total Withdraws = 60k
    //trying to withdraw more 20k should return withdraw per day limit error >50k
    atm.withdraw(20000);

    assertTrue(atm.getBalance()==40000.00);

    assertTrue(atm.getTotalWithdrawals()==60000.00);
    
	}
	
	//verify user cannot withdraw more than 20k per transaction	
	@Test(expected = IOException.class)
	public  void testMaximumWithdrawalPerTransaction() throws IOException,Exception{
		System.out.println("7.Test:Maximum Withdrawals Per Transaction");

		atm.deposit(35000);
		atm.withdraw(22000);
        
		assertTrue(atm.getBalance()==35000.00);
    }
    
    
	//Verify Maximum Withdrawal Frequency is 3
	//Exception is expected because of insufficient funds
	@Test(expected = IOException.class)	
	public  void testMaximumWithdrawalFrequency()throws IOException,Exception{
		System.out.println("8.Test:Maximum Withdrawals Frequency");

		atm.deposit(15000);

		atm.withdraw(1000);
		atm.withdraw(2000);
		atm.withdraw(3000);

        assertTrue(atm.getBalance()==9000.00);
        //withdraw 4th time 
		atm.withdraw(4000);
		assertFalse(atm.getBalance()==5000.00);
				
	  }	  		 
	
	 //BALANCE TESTS
	//verify user can withdraw if balance > withdraw amount		
	@Test
	public void testBalanceDepositGreaterThanWithdraw() throws IOException,Exception {
		
		System.out.println("13.Test Balance:Deposit = 4700 < Withdraw = 1300");

		atm.deposit(4700);		
		atm.withdraw(1300);

		assertTrue(atm.getBalance()==3400.00);
	}
	//Expected IOException
	@Test(expected = IOException.class)
	public void testBalanceWithdrawGreaterThanDeposit()throws IOException,Exception {
		
		System.out.println("12.Test Balance:Deposit = 1500 < Withdraw = 4000");

		atm.deposit(1500);		
		atm.withdraw(4000);

		assertTrue(atm.getBalance()==0.00);
		
	}

}
	



