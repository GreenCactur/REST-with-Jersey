/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.mock.util;


import java.sql.*;


/**
 *
 * @author naaff
 */
public  class connection {
    
    public static Connection connection;
    public static Connection makeConnection(){
        String username = "naf";
        String password = "om906la";
        String url = "jdbc:mysql://localhost:3306/librarix";
        String driver = "com.mysql.cj.jdbc.Driver";
        try {
            connection=DriverManager.getConnection(url, username, password);
            System.out.println("Koneksi Berhasil");
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Koneksi anda gagal");
        } 
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Koneksi anda gagal");
        }
        
        return connection;
    }
    
//    public static void main(String[] args) {
//        makeConnection();
//    }
    
}
