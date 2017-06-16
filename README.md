# atm-console-application
A Simple ATM Console App
# A Simple ATM Console Application
This simple java console application demonstrate 4 common operations via ATM.
That is,Deposit,Withdraw,Balance and Quit

# How To Run The Application
The simple way to run the application is via terminal.Just comment the package part i.e
//package com.simpleatm.app;

Compile:
$ javac ATM_Program.java

Execute:
$ java ATM_Program

Otherwise you may get an error like:
Error:Could not find or load Class ATM_Program

To fix this setup path while running the app
e.g java -cp C:/Users/<username>/tasks/src ATM_Program
<username> should be replace appropriately incase you're using Windows

# Running the JUnit Tests
Add hamcrest-core-1.3.jar and junit-4.12.jar to your CLASSPATH.
Note:You can also include them in your Environment Variables(better option).

The tests are include separately in their own package.
//package com.simpleatm.tests;
They can be found in SimpleATMTests.java.
The TestRunner.java simply executes them.

You can compile and execute them as:
$ javac TestRunner.java

$ java -cp <path to where they are located> TestRunner
e.g java -cp C:/Users/<username>/tasks/tests TestRunner

Note:Commenting on the package is just for the one running the app via termina.If using Eclipse IDE there is no need to.






