package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Jdbctest {
	public static void main(String[] args) {
		try {
			//register driver step no 1
		Class.forName("com.mysql.cj.jdbc.Driver");
		//get connection step no 2
		Connection conn=DriverManager.getConnection
				("jdbc:mysql://localhost:3306/nishadb","root","Nisha@2022");
		//create statement step no 3
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("select * from customer");
		//iteration
		while(rs.next()) {
			System.out.println(rs.getString(1)+" "+rs.getInt(5)+" "+rs.getString(4)+" "+rs.getString(3));
		}
		conn.close();
		}catch(Exception e) {
			System.out.println(e);
		}				
	}
}
