package com.loaderclass;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.CMS.Helper;



public class Addmissionnew {
	int id;
	String name,dept,add,sem;
	
	Scanner sc=new Scanner(System.in);
	public void newaddmission()throws SQLException{
		Connection conn=Helper.con();
		
		
			System.out.println("Enter College id:");
			id=sc.nextInt();
			System.out.println("Enter your name:");
			name=sc.nextLine();
			
			System.out.println("Enter your department:");
			dept=sc.nextLine();
			System.out.println("Enter your address:");
			add=sc.nextLine();
			System.out.println("Enter your semester:");
			add=sc.nextLine();
			PreparedStatement stmt= conn.prepareStatement("insert into College values(?,?,?,?,?)");
			stmt.setInt(1,id);
			stmt.setString(2,name);
			stmt.setString(3,dept);
			stmt.setString(4,add);
			stmt.setString(5,sem);
			
			stmt.executeUpdate();
			
		}
	}
	

