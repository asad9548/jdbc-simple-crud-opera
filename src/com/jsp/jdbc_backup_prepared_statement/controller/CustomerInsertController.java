package com.jsp.jdbc_backup_prepared_statement.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerInsertController {
	public static void main(String[] args) {
		Connection connection = null;
		try {
			//step-1 load/register the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//step-2 create connection
			String url = "jdbc:mysql://localhost:3306/jdbc-preparedstatement";
			String user = "root";
			String pass = "asad9548A@#";
			
			 connection = DriverManager.getConnection(url, user, pass);
			
			//step-3 create statement
			String insertCustomerQuery = "insert into customer values(?, ?, ?, ?, ?, ?)";
		PreparedStatement preparedStatement = connection.prepareStatement(insertCustomerQuery);
		Date date = new Date(2023, 07, 19);
		preparedStatement.setInt(1, 125);
		preparedStatement.setString(2, "Raghav");
		preparedStatement.setString(3, "raghav@gmail.com");
		preparedStatement.setLong(4, 2154895);
		preparedStatement.setString(5, "Noida sector-15");
		preparedStatement.setDate(6, date);
		
		//step-4 execute Query
		preparedStatement.execute();
		System.out.println("Data-------stored");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
