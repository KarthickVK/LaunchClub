package com.mobi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;


	 class Override extends Polymorphism
		{
			
				
					void connect()
					{
						try
						{
							Scanner keyboard = new Scanner(System.in);
							System.out.println("Enter Emp_Name");
							String name = keyboard.nextLine();

							System.out.println("Enter your Emp_dob");
							String dob = keyboard.next();
							Class.forName("com.mysql.cj.jdbc.Driver");
							Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcsamble", "root", "Karthi33");
						
							Statement st = con.createStatement();

							st.executeUpdate("insert into empl(Emp_name,Emp_dob) values('" + name + "','" + dob + "')");

						
					}
					
				catch(Exception e)
				{
					System.out.println(e);
				}
					}
						public static void main(String[] args)
						{
						
						
						
						Override obj1 = new Override();
						obj1.connect();
						
						}
		
			





	}


