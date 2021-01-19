/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.mock.repository;
import io.project.mock.model.customers;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.POST;
/**
 *
 * @author naaff
 */
public class customersRepository {
    
    Connection connect = null;
    Statement statement = null;
            
    public customersRepository(){
        String url = "jdbc:mysql://localhost:3306/classicmodels";
        String user = "naf";
        String password = "om906la";
        String driver = "com.mysql.cj.jdbc.Driver";
        try{
            Class.forName(driver);
            connect = DriverManager.getConnection(url,user,password);
            System.out.println("Koneksi Berhasil");
            statement = connect.createStatement();
            
        }catch(ClassNotFoundException ex){
            System.out.println(ex);
        }catch(SQLException ex){
            
        }
    }
    
    public List<customers> getBooks() throws SQLException{
        List<customers> books = new ArrayList<>();
        
        try {
            Statement  statement = connect.createStatement();
            
            String sql = "select * from customers";
            ResultSet rs = statement.executeQuery(sql);
            
            while(rs.next()){
                customers cs = new customers();
                cs.setId(rs.getInt(1));
                cs.setName(rs.getString(2));
                cs.setAddress(rs.getString(6));
                cs.setState(rs.getString(9));
                cs.setCity(rs.getString(8));
                cs.setCountry(rs.getString(11));
                
                books.add(cs);
                System.err.println(rs.getString(1));
                System.err.println(rs.getString(2));
                
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }        
        return  books;
    }
    
    public customers getCustomer(int id){
        try {
            String ID = String.valueOf(id);
            String sql = "select * from customers where customerNumber=?";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, ID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                customers cs = new customers();
                cs.setId(rs.getInt(1));
                cs.setName(rs.getString(2));
                cs.setAddress(rs.getString(6));
                cs.setState(rs.getString(9));
                cs.setCity(rs.getString(8));
                cs.setCountry(rs.getString(11));
                
                return cs;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return new customers();
    }
    
    public customers addData(customers Cs){
        
        try {
            String sql = "insert into customers(customerNumber,customerName,addressLine1,state,city,country) values (?,?,?,?,?,?);";
            
            PreparedStatement ps = connect.prepareStatement(sql);
              ps.setInt(1,Cs.getId());
              ps.setString(2,Cs.getName());
              ps.setString(3,Cs.getAddress());
              ps.setString(4,Cs.getState());
              ps.setString(5,Cs.getCity());
              ps.setString(6,Cs.getCountry());
              ps.executeUpdate();
                      
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return Cs;
    }
    
}
    

