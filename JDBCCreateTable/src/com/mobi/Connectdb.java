package com.mobi;

import java.sql.*;
import java.util.Scanner;

public class Connectdb {
	public static void main(String args[]) throws Exception {
		System.out.println("Welcome to  database");
	try {

			Scanner keyboard = new Scanner(System.in);
			System.out.println("Enter Emp_Name");
			String name = keyboard.nextLine();

			System.out.println("Enter your Emp_dob");
			String dob = keyboard.next();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcsamble", "root", "Karthi33");
		
			Statement st = con.createStatement();

			st.executeUpdate("insert into empl(Emp_name,Emp_dob) values('" + name + "','" + dob + "')");
			

		} catch (Exception e) {
			System.out.println(e);
		}

		finally {
			System.out.println("Thank you");
		}
	

}
}





