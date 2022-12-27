package com.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.menudriven.Helper;

public class Student {
Scanner s=new Scanner(System.in);
int code,age,working_hour;
String name;
//saving student details in database
public void saveMenudriven()throws SQLException{
	System.out.println("Enter trainee code: ");
	code=s.nextInt();
	System.out.println("Enter trainee name: ");
	name=s.nextLine();
	System.out.println("Enter trainee age: ");
	age=s.nextInt();
	System.out.println("Enter trainee working hour: ");
	working_hour=s.nextInt();
	Connection conn=Helper.con();
	PreparedStatement stmt=conn.prepareStatement("Insert into Trainee values (?,?,?,?)");
	stmt.setInt(1, code);
	stmt.setString(2, name);
	stmt.setInt(1, age);
	stmt.setInt(1, working_hour);
	stmt.executeUpdate();}
//fetching trainee details in the database(display)
public void fetchMenudriven()throws SQLException{
	Connection conn=Helper.con();
	Statement stmt=conn.createStatement();
	//execute query fetch data from database
	ResultSet rs=stmt.executeQuery("select * from Trainee");
	//iteration
	while(rs.next()) {
		System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getInt(4));
		System.err.println("Data inserted &saved successfully------------");
	}};
	//updating trainee details in the database
	public void updateMenudriven() throws SQLException{
		Connection conn=Helper.con();
		Statement stmt=conn.createStatement();
		System.out.println("Enter trainee age:");
		age=s.nextInt();
		System.out.println("Enter trainee code:");
		code=s.nextInt();
		stmt.executeUpdate("update trainee set age= '"+age+"'where code= "+code);
	}
	//deleting trainee details in the database
	public void deleteMenudriven() throws SQLException{
		Connection conn=Helper.con();
		Statement stmt=conn.createStatement();
		System.out.println("Enter trainee code:");
		code=s.nextInt();
		stmt.executeUpdate("delete from trainee where code= "+code);
	}	
}

