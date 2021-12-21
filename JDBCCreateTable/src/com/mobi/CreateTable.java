package com.mobi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import com.mysql.cj.xdevapi.Statement;

public class CreateTable {

	public static void main(String[] args) throws Exception {
		System.out.println(" table creation examble");
		Connection con = null;
		String url = "jdbc:mySql://localhost:3306/jdbcsamble";
		String dbname = "jdbcsamble";
		String driverName = "com.mysql.cj.jdbc.Driver";
		String username = "root";
		String password = "Karthi33";
		try {
			Class.forName(driverName).newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcsamble", "root", "Karthi33");
			try {
				
				Statement st = (Statement) con.createStatement();
				String tablesql = "CREATE TABLE Employee11(Emp_id int(),Emp_dob varchar())";
				   ((java.sql.Statement) st).executeUpdate(tablesql);
				   
				System.out.println("table creation process succesfully");
//((Connection) st).close();
			} catch (Exception e) {
				System.out.println("table are ready exit");

			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
