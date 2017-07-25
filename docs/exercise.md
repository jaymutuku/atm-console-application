### QA 4 Hours Exam

1. Write a simple “ATM” program.

    a.  Program should have 4 options: Balance, Deposit, Withdrawal,Quit

    b.  Balance - should display remaining balance

    c.  Deposit
   
        i.  Enter deposit amount

        ii. Max deposit for the day = 150K

        iii. Max deposit per transaction = 40K

        iv. Max deposit frequency = 4

    d.  Withdrawal

        i.  Enter withdrawal amount

        ii. Max withdrawal for the day = 50K

        iii. Max withdrawal per transaction = 20K

        iv. Max withdrawal frequency = 3

        v.  Cannot withdraw when balance is less than withdrawal amount
      
    e.  Quit
   
        i.  Should ask to confirm to quit

        ii. End program

        iii.  Data should not persist, i.e. when the user quits and restarts,data should be reset.

2. Write tests against that program. Which tool(s) can you use to ensure
proper code coverage? Bonus: implement the tool and show code coverage numbers for
your tests.

3. Make sure your code is readable and can be run.

4. Check in your code to github and write instructions on [README](../README.md) on how to run.


### Sample Flow

\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*

1.  Balance

2.  Deposit

3.  Withdrawal

4.  Quit

Enter Menu Option

&gt;

\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*

BALANCE

150000.00

Type “menu” and press enter to go back to main menu

&gt;

\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*

DEPOSIT

Current Balance: 150000.00

Error: &lt;put error here only if exist&gt;

Enter amount and press enter (or type menu and press enter to go back to main menu)

&gt;

\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*

WITHDRAWAL

Current Balance: 150000.00

Error: &lt;put error here only if exist&gt;

Enter amount and press enter (or type menu and press enter to go back to main menu)

&gt;

\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*

QUIT

Are you sure you want to quit? (yes/no)

&gt;

\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*
