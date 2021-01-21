package io.project.mock.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import io.project.mock.model.employee;
import io.project.mock.util.dbConnect;

public class employeeRepository {
	Connection connection = dbConnect.makeConnection();
	
	List<employee>listEmployees;
	
	public List<employee> getEmployees(){
		listEmployees = new ArrayList<employee>();
		try {
			String sql = "Select * from employees";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
				employee Emp = new employee();
				Emp.setID(resultSet.getInt(1));
				Emp.setFirstname(resultSet.getString(3));
				Emp.setLastname(resultSet.getString(2));
				Emp.setEmail(resultSet.getString(5));
				Emp.setJob(resultSet.getString(8));
				
				
				listEmployees.add(Emp);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		return listEmployees; 
	}
	
	public employee getEmployee(int id){
			employee Employee = new employee();
		try {
			String sql ="select employeeNumber,firstname,lastname,email,jobTitle from employees where employeeNumber =?;";
			PreparedStatement ps= connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				Employee.setID(resultSet.getInt(1));
				Employee.setFirstname(resultSet.getString(2));
				Employee.setLastname(resultSet.getString(3));
				Employee.setEmail(resultSet.getString(4));
				Employee.setJob(resultSet.getString(5));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return Employee;
	}
	
}
