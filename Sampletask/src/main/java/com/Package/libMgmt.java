package com.Package;

import java.sql.*;
import java.util.*;

public class libMgmt {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcsamble", "root", "Karthi33");
		Statement st = c.createStatement();
		PreparedStatement ps = c.prepareStatement("update Library set bookname= ? where authorname=?;");
		System.out.println("Searching Based on\n 1.id \n 2.bookname \n 3.authorname ");
		System.out.println("Enter your choice");
		int ch = sc.nextInt();
		switch (ch) {		
		case 1: {
			System.out.println("Enter id");
			int id = sc.nextInt();
			ResultSet rs = st.executeQuery("select * from Liblist where id= '" + id + "'");
			while (rs.next()) {
				System.out.println("Details are:" + rs.getString(1) + "\n" + rs.getString(2) + "\n" + rs.getString(3));
			}
			break;
		}
		case 2: {
			System.out.println("Enter Book Name");
			String BookName = sc1.nextLine();
			ResultSet rs = st.executeQuery("select * from Liblist where bookname= '" + BookName + "'");
			while (rs.next()) {
				System.out.println("Details are:" + rs.getString(1) + "\n" + rs.getString(2) + "\n" + rs.getString(3));
			}
			System.out.println("Book name not found");
			break;
		}
		case 3: {
			System.out.println("Enter Author Name");
			String AuthorName = sc1.nextLine();
			ResultSet rs = st.executeQuery("select * from Liblist where authorname= '" + AuthorName + "'");
			while (rs.next()) {
				System.out.println("Details are:" + rs.getString(1) + "\n" + rs.getString(2) + "\n" + rs.getString(3));
			}
			System.out.println("Author name not found");
			break;
		}
		default: {
			System.out.println("Enter 1 to 3");
			break;
		}
		}
	}
}
