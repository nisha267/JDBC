package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Updatejdbc {
	public static void main(String[] args) {
		try {
			//Register driver step no 1
			Class.forName("com.mysql.cj.jdbc.Driver");
			//get connection step no 2
			Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/nishadb","root","Nisha@2022");
			//create statement step no 3
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("Update emp1 set name='Sita'  where id=2"); //update
			//delete record
			stmt.executeUpdate("delete from emp1 where id=1");
			//execute query fetch data from database
			ResultSet rs= stmt.executeQuery("select * from emp1");
			//Iteration
			while(rs.next()) {
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4)+" "+rs.getInt(5)+" "+rs.getString(6));
				
			}
			//close database connection step no 5
			conn.close();
	} catch(Exception e)  {
		System.out.println(e);
	}
	}
}