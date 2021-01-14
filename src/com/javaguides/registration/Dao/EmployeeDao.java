package com.javaguides.registration.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.javaguides.registration.model.Employee;
import com.mysql.jdbc.PreparedStatement;

public class EmployeeDao {
	
	public int registerEmployee(Employee employee) throws ClassNotFoundException {
		String INSERT_USERS_SQL = "INSERT INTO EMPLOYEE" + 
	" (first_name, last_name, username, password, address, contact) VALUES" +
				"(?, ?, ?, ?, ?, ?)";
		
		int result = 0;
		
		Class.forName("com.mysql.jdbc.Driver");
		
		try(Connection connection=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/employees?useSSL = false","root","");
				
		//Step 2: Create Statement using Connection object
				PreparedStatement ps = (PreparedStatement) connection.prepareStatement(INSERT_USERS_SQL)){
		//PreparedStatement ps = connection.prepareStatement(INSERT_USERS_SQL)) {
			ps.setString(1, employee.getFirstname());
			ps.setString(2, employee.getLastname());
			ps.setString(3, employee.getUsername());
			ps.setString(4, employee.getPassword());
			ps.setString(5, employee.getAddress());
			ps.setString(6, employee.getContact());
			
			System.out.println(ps);
			
			//Step 3: Execute the Query or update the Query
			result = ps.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return result;	
	}
	
}
