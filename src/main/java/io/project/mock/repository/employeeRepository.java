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
			String ID = String.valueOf(id);
			String sql ="select employeeNumber,firstname,lastname,email,jobTitle from employees where employeeNumber =?;";
			PreparedStatement ps= connection.prepareStatement(sql);
			ps.setString(1, ID);
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
	
	public employee addEmployee(employee Employee){
		try {
			String sql = "insert into employees(employeeNumber,firstname,lastname,email,jobTitle) values(?,?,?,?,?)";
			PreparedStatement ps= connection.prepareStatement(sql);
			ps.setInt(1, Employee.getID());
			ps.setString(2, Employee.getFirstname());
			ps.setString(3, Employee.getLastname());
			ps.setString(4, Employee.getEmail());
			ps.setString(5, Employee.getJob());
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return Employee;
	}
	
	public employee editEmployee(employee Employee){
		try {
			String sql = "update employees set firstname = ?, lastname= ?, email= ?, jobTitle =? where employeeNumber = ? ; "; 
			PreparedStatement ps= connection.prepareStatement(sql);
			ps.setString(1, Employee.getFirstname());
			ps.setString(2, Employee.getLastname());
			ps.setString(3, Employee.getEmail());
			ps.setString(4, Employee.getJob());
			
			ps.setInt(5, Employee.getID());
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return Employee;
	}
	
	public String deleteEmployee(int id){
		try {
			String sql = "delete from employees where employeeNumber=?;"; 
			PreparedStatement ps= connection.prepareStatement(sql);
			ps.setInt(1, id);
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return "[ \n \"Data Sucessfully to DELETE \"\n ]";
	}
	
}
