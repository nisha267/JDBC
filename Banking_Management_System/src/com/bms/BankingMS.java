package com.bms;
import java.sql.SQLException;
import java.util.Scanner;

import com.loaderclass.*;
public class BankingMS {
 static Scanner sc=new Scanner(System.in);
 public static void main(String[] args) throws SQLException {
	int variable;
	do {
		System.out.println("""
				->|| WELCOME TO OUR BANKING SERVICE ||<-
				press 1 to open account in our bank:~
				press 2 to show your account status in our bank:~
				press 3 to deposit money in your account:~
				press 4 to withdraw money from your account:~
				press 5 to change pin:~
				press 6 to close your account:~
				press 7 to exit:~
				""");
		variable=sc.nextInt();
		System.out.println("-----------------------");
		switch(variable) {
		case 1:
			System.out.println("Enter 10 digits to create a new account number:");
			int acc_no=sc.nextInt();
			System.out.println("Enter account IFSC: ");
			String ifsc_code=sc.next();
			System.out.println("Enter 4 digits to create a new Account pin:");
			int pin =sc.nextInt();
			Open op=new Open();
			op.OpenNewAccount(acc_no, ifsc_code, pin);
			System.err.println("---NEW ACCOUNT CREATED-----");
			break;
		case 2:
			System.out.println("Enter your account number:");
			int p=sc.nextInt();
			System.out.println("Enter your pin: ");
			int q=sc.nextInt();
			Showbal sb=new Showbal();
			sb.showAccountDetails(p, q);
			System.out.println();
			break;
		case 3:
			System.out.println("Enter your account number:");
			int a=sc.nextInt();
			System.out.println("Enter your pin: ");
			int b=sc.nextInt();
			Deposit db=new Deposit();
			db.DepositBalance(a, b);
			System.out.println();
			break;
		case 4:
			System.out.println("Enter your account number:");
			int c=sc.nextInt();
			System.out.println("Enter your pin: ");
			int d=sc.nextInt();
			Withdraw wb=new Withdraw();
			wb.withdraw(c, d);
			System.out.println();
			break;
		case 5:
			System.out.println("Enter your account number:");
			int e=sc.nextInt();
			System.out.println("Enter your pin: ");
			int f=sc.nextInt();
			PinChange pc=new PinChange();
			pc.PinChange(e, f);
			System.err.println("PIN HAS CHANGED");
			break;
		case 6:
			System.out.println("Enter your account number:");
			int g=sc.nextInt();
			System.out.println("Enter your pin: ");
			int h=sc.nextInt();
			CloseAccount ca=new CloseAccount();
			ca.cloacc(g, h);
			System.out.println();
			break;
		case 7:
			System.out.println("You have successfully logged out");
			System.out.println("THANK YOU");
			System.out.println();
			System.exit(0);
			break;
		}}
	while(variable>0 && variable <8);
 }}			
				
				
				
				
				
				
				
				
				
				