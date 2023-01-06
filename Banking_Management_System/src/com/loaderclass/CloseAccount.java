package com.loaderclass;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bms.Helper;

public class CloseAccount {
int db_pin;
int db_acc;
public void cloacc(int acc_no,int pin) throws SQLException{
	Connection conn=Helper.con();
	Statement stmt=conn.createStatement();
	ResultSet rs = stmt.executeQuery("select * from Bank where acc_no= " + acc_no + " and pin= " + pin);
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

		stmt.executeUpdate("delete  from Bank where acc_no=" + acc_no + " and pin= " + pin);
	System.out.println("__BANK A/C CLOSED__");

}

}