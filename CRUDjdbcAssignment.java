package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CRUDjdbcAssignment {
	public static void main(String[] args) {
		try {
			//register driver step no 1
		Class.forName("com.mysql.cj.jdbc.Driver");
		//get connection step no 2
		Connection conn=DriverManager.getConnection
				("jdbc:mysql://localhost:3306/nishadb","root","Nisha@2022");
		//CREATE
		//create statement step no 3
		Statement stmt=conn.createStatement();
		stmt.executeUpdate("insert into emp1 values (10,'Rita',6786,'Developer',22,'C')");
		System.out.println("inserted successfully");
		//READ
		//read statement step no 4
		Statement stmt2=conn.createStatement();
		ResultSet rs=stmt2.executeQuery("select * from emp1");
		//UPDATE
		//update statement step no 5
		Statement stmt3=conn.createStatement();
		stmt3.executeUpdate("Update emp1 set name='Ram'  where id=4"); 
		//DELETE record
		Statement stmt4=conn.createStatement();
		stmt4.executeUpdate("delete from emp1 where id=5 ");
		 rs=stmt.executeQuery("select * from emp1");
		
		//Iteration
		while(rs.next()) {
			System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4)+" "+rs.getInt(5)+" "+rs.getString(6));
			
		}
		//close database connection step no 6
		conn.close();
} catch(Exception e)  {
	System.out.println(e);
}
}
}
	


