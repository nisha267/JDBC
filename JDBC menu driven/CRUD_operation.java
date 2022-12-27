package com.menudriven;

import java.sql.SQLException;
import java.util.Scanner;

import com.student.Student;

public class CRUD_operation {
public static void main(String[] args) throws SQLException {
	Student e=new Student();
	Scanner s=new Scanner(System.in);
	int ch;
	do {
		System.out.println("1.Insert \n 2.Display \n 3.Update \n 4.Delete");
		System.out.println("Enter your choice from 1-5");
		ch=s.nextInt();
		System.out.println("--------THANK YOU--------");
		switch(ch) {
		case 1:
			e.saveMenudriven();
			break;
		case 2:
			e.fetchMenudriven();
			break;
		case 3:
			e.updateMenudriven();
			break;
		case 4:
			e.deleteMenudriven();
			break;
		case 5:
			System.exit(0);
			break;
		}
	}while(ch!=5);
	}
}
	
	


