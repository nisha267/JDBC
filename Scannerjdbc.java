package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Scannerjdbc {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter id:");
	String id=sc.next();
	System.out.println("Enter name:");
	String name=sc.next();
	System.out.println("Enter basic:");
	String basic=sc.next();
	System.out.println("Enter designation:");
	String designation=sc.next();
	System.out.println("Enter age:");
	String age=sc.next();
	System.out.println("Enter skill:");
	String skill=sc.next();
	try {
		//register driver step no 1
		Class.forName("com.mysql.cj.jdbc.Driver");
		//get connection step no 2
		Connection conn=DriverManager.getConnection
				("jdbc:mysql://localhost:3306/nishadb","root","Nisha@2022");
		//creating statement
		PreparedStatement stm;
		//inserting data in database table
		String sql="insert into emp1 values(?,?,?,?,?,?)";
		stm=conn.prepareStatement(sql);
		stm.setString(1, id);
		stm.setString(2, name);
		stm.setString(3, basic);
		stm.setString(4,designation);
		stm.setString(5, age);
		stm.setString(6, skill);
		stm.execute();
		System.out.println("inserted successfully");}
	catch(Exception e) {
		System.out.println(e);
		
		
	}
}
}
