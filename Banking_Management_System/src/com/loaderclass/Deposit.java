package com.loaderclass;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.bms.Helper;

public class Deposit {
	
	int db_pin;
	int db_acc;
	double pbal;
	Scanner sc=new Scanner(System.in);
	public void DepositBalance(int acc_no,int pin)throws SQLException {
		Connection conn=Helper.con();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("select * from Bank where acc_no="+acc_no+" and pin="+pin);
		while(rs.next()) {
			db_acc=rs.getInt(1);
			db_pin=rs.getInt(7);
		}
		if(db_acc!=acc_no) {
			System.err.println("!!WRONG ACCOUNT NUMBER INSERTED");
		}
		if(db_pin!=pin) {
			System.err.println("!!WRONG PIN NUMBER INSERTED");

		}else {
			System.out.println("enter amount you want to deposit  :");
			double depo=sc.nextDouble();
			ResultSet rs2=stmt.executeQuery("select balance from Bank where acc_no="+acc_no+" and pin="+pin);
			while(rs2.next()) {
				pbal=rs2.getDouble(1);
				System.out.println();
				System.out.println("Your previous balance was :"+pbal);
			}
			stmt.executeUpdate("Update Bank set balance="+(pbal+depo)+" "+"where pin="+pin);
			System.err.println("Your new balance is  :"+(pbal+depo));
			System.err.println("---------------------------------------------------");
		}
	}
	}