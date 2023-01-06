package com.loaderclass;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.bms.Helper;

public class PinChange {
int db_acc,db_pin;
Scanner sc=new Scanner(System.in);
public void PinChange(int acc_no,int pin)throws SQLException{
	Connection conn=Helper.con();
	Statement stmt=conn.createStatement();
	System.out.println("Enter new pin: ");
	int newPin=sc.nextInt();
	ResultSet rs = stmt.executeQuery("select * from Bank where acc_no= " + acc_no);
	while (rs.next()) {
		db_acc = rs.getInt(1);
		db_pin = rs.getInt(7);
	}
	if (db_acc != acc_no) {
		System.err.println("!! WRONG ACCOUNT NUMBER INSERTED !!");
	}
	if (db_pin != pin) {
		System.err.println("!! WRONG PIN INSERTED !!");
	} else

		stmt.executeUpdate("update Bank set pin= " +newPin+" where acc_no="+acc_no);
	

}


}

