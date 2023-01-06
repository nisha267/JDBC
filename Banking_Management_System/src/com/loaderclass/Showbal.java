package com.loaderclass;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bms.Helper;

public class Showbal {
int db_acc;
int db_pin;
public void showAccountDetails(int acc_no,int pin)throws SQLException{
		Connection conn=Helper.con();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("select * from bank where acc_no="+acc_no+" and pin="+pin);
		while(rs.next()) {
			db_acc=rs.getInt(1);
			db_pin=rs.getInt(7);
		}
		if(db_acc !=acc_no) {
			System.err.println("WRONG ACCOUNT NUMBER INSERTED!!");
		}
		if(db_pin!=pin) {
			System.err.println("!! WRONG PIN INSERTED!!");
		}
		else {
			System.err.println("----------------------");
			System.out.println("Details of your account:");
			ResultSet rs1=stmt.executeQuery("select * from bank where pin="+pin);
			while(rs1.next()) {
				System.out.println("Account number : "+rs1.getInt(1));
				System.out.println("Account holder : "+rs1.getString(2));
				System.out.println("Branch IFSC : "+rs1.getString(3));
				System.out.println("Branch : "+rs1.getString(4));
				System.out.println("Account type : "+rs1.getString(5));
				System.out.println("Account Balance : "+rs1.getDouble(6));
				System.out.println("Account pin : "+rs1.getInt(7));
				System.err.println("-----------------------");
			}
		}
}
}
