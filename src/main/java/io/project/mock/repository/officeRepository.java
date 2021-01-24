package io.project.mock.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import io.project.mock.model.office;
import io.project.mock.util.dbConnect;

public class officeRepository {
		
	Connection connect = dbConnect.makeConnection();
	String sql = null;
	
	//list all data
	public List<office>getOffice(){
		List<office>listOffice = new ArrayList<>();
		try {
			sql = "select * from offices";
			Statement statement = connect.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()) {
				office Office = new office();
				Office.setId(rs.getInt(1));
				Office.setCity(rs.getString(2));
				Office.setPhone(rs.getString(3));
				Office.setAddress1(rs.getString(4));
				Office.setAddress2(rs.getString(5));
				Office.setState(rs.getString(6));
				Office.setCountry(rs.getString(7));
				Office.setPostalCode(rs.getString(8));
				Office.setTeritory(rs.getString(9));
				
				listOffice.add(Office);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listOffice;
	}
	
	//add Data 
	public office addOffice(office Office){
		try {
			sql = "insert into offices(officeCode,city,phone,addressLine1,addressLine2,state,country,postalCode,territory) values (?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setInt(1, Office.getId());
			ps.setString(2,Office.getCity());
			ps.setString(3,Office.getPhone());
			ps.setString(4,Office.getAddress1());
			ps.setString(5,Office.getAddress2());
			ps.setString(6,Office.getState());
			ps.setString(7,Office.getCountry());
			ps.setString(8,Office.getPostalCode());
			ps.setString(9,Office.getTeritory());
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Office;
	}
	
	//get Data by ID
	public office getDatabyID(int id){
		office Office = new office();
		try {
			String ID = String.valueOf(id);
			System.out.println(id);
			sql = "select * from offices where officeCode =?;";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, ID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Office.setId(rs.getInt(1));
				Office.setCity(rs.getString(2));
				Office.setPhone(rs.getString(3));
				Office.setAddress1(rs.getString(4));
				Office.setAddress2(rs.getString(5));
				Office.setState(rs.getString(6));
				Office.setCountry(rs.getString(7));
				Office.setPostalCode(rs.getString(8));
				Office.setTeritory(rs.getString(9));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Office;
	}
	
	//edit Data
	public office editData(office Office){
		try {

			sql = "update offices set city = ?, phone = ?, addressLine1 = ?, addressLine2 = ?, state = ?, country = ?, postalCode = ?, territory = ? where officeCode = ?;";
			PreparedStatement ps = connect.prepareStatement(sql);
				
				ps.setString(1,Office.getCity());
				ps.setString(2,Office.getPhone());
				ps.setString(3,Office.getAddress1());
				ps.setString(4,Office.getAddress2());
				ps.setString(5,Office.getState());
				ps.setString(6,Office.getCountry());
				ps.setString(7,Office.getPostalCode());
				ps.setString(8,Office.getTeritory());
				ps.setInt(9,Office.getId());
				
				ps.executeUpdate();
							
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Office;
	}
	
	//delete Data
	public String dropData(int id){
		try {
			String ID = String.valueOf(id);
			sql = "delete from offices where officeCode = ?;";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, ID);
			ps.executeUpdate();
							
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "[ \n \"Data Sucessfully to DELETE \"\n ]";
	}
	
	//
}

