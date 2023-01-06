package com.loaderclass;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.CMS.Helper;



public class Display {
	int db_id;
	public void showdetails(int id)throws SQLException{
	Connection conn=Helper.con();
	Statement stmt=conn.createStatement();
	ResultSet rs=stmt.executeQuery("select * from College where id= "+id);
	while(rs.next()) {
		db_id=rs.getInt(1);
	}
	
	if(db_id!=id) {
		System.err.println("WRONG ID INSERTED!!");
	}
	
	else {
		System.err.println("----------------------");
		System.out.println("Details of the Student:");
		ResultSet rs1=stmt.executeQuery("select * from College where id="+id);
		while(rs1.next()) {
			System.out.println("ID : "+rs1.getInt(1));
			System.out.println("Name : "+rs1.getString(2));
			System.out.println("Department : "+rs1.getString(3));
			System.out.println("Address : "+rs1.getString(4));
			System.out.println("Semester : "+rs1.getString(5));
			
			System.err.println("-----------------------");
		}
	}}}



