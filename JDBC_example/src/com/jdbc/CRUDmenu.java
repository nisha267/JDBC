package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class CRUDmenu {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Code:");
		String code=sc.next();
		System.out.println("Enter name:");
		String name=sc.next();
		System.out.println("Enter age:");
		String age=sc.next();
		System.out.println("Enter Working_hour:");
		String Working_hour=sc.next();
		
		try {
			//register driver step no 1
			Class.forName("com.mysql.cj.jdbc.Driver");
			//get connection step no 2
			Connection conn=DriverManager.getConnection
					("jdbc:mysql://localhost:3306/nisdb","root","Nisha@2022");
			//creating statement
			PreparedStatement stm;
			//inserting data in database table
			String sql="insert into trainee values(?,?,?,?)";
			stm=conn.prepareStatement(sql);
			stm.setString(1, code);
			stm.setString(2, name);
			stm.setString(3, age);
			stm.setString(4,Working_hour);
			stm.execute();
			System.out.println("inserted successfully");
			Statement stmt=conn.createStatement();
			stmt.executeUpdate("Update emp1 set name='Ram'  where id=4"); 
			//DELETE record
			Statement stmt4=conn.createStatement();
			stmt4.executeUpdate("delete from emp1 where id=5 ");
			ResultSet  rs=stmt.executeQuery("select * from emp1");}
		catch(Exception e) {
			System.out.println(e);
			
			
		}
	}
	}

