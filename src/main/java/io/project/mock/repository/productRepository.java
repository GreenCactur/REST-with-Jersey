package io.project.mock.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import io.project.mock.model.customers;
import io.project.mock.model.products;
import io.project.mock.util.dbConnect;

import java.sql.ResultSet;
import java.sql.Statement;

public class productRepository {
	private String querySQL;
	
	//make Obj for products class
	List<products>allProduct;
	
	//call class the handle create conection
	Connection connection = dbConnect.makeConnection();
	
	
	//retrive data from database
	public List<products> getAllProducts(){
		
		querySQL = "select * from products";
		
		allProduct = new ArrayList<>();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(querySQL);
			
			while (resultSet.next()) {
				products Product = new products();
				Product.setProductCode(resultSet.getString(1));
				Product.setProductName(resultSet.getString(2));
				Product.setProductLine(resultSet.getString(3));
				Product.setProductScale(resultSet.getString(4));
				Product.setProductVendor(resultSet.getString(5));
				Product.setQuantityinStock(resultSet.getString(6));
				Product.setBuyPrice(resultSet.getString(8));
				Product.setMSRP(resultSet.getString(9));
				
				allProduct.add(Product);	
				
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return allProduct;
	}

	//retrive Data by ID
	public products getProductbyid(String id){
		querySQL = "select * from products where productCode=?";
		
		products Product = new products();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(querySQL);
			preparedStatement.setString(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				Product.setProductCode(resultSet.getString(1));
				Product.setProductName(resultSet.getString(2));
				Product.setProductLine(resultSet.getString(3));
				Product.setProductScale(resultSet.getString(4));
				Product.setProductVendor(resultSet.getString(5));
				Product.setQuantityinStock(resultSet.getString(6));
				Product.setBuyPrice(resultSet.getString(8));
				Product.setMSRP(resultSet.getString(9));						
			}	
		} 
		catch (Exception e) {
			System.out.println(e);
		}
		return Product;
	}
	
	//Delete Data by ID
	public String deleteData(String id){
		querySQL = "delete from products where productCode = ?;";
		try {
			PreparedStatement ps = connection.prepareStatement(querySQL);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return "{ \n "+
				"Data is Deleted"
				+ "\n}";
	}
	
	//Add Product Data
	public products addProduct(products Product){
		querySQL = "insert into products(productCode,productName,productLine,productScale,productVendor,quantityInStock,buyPrice,MSRP) values (?,?,?,?,?,?,?,?)";
		
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(querySQL);
			preparedStatement.setString(1, Product.getProductCode());
			preparedStatement.setString(2, Product.getProductName());
			preparedStatement.setString(3, Product.getProductLine());
			preparedStatement.setString(4, Product.getProductScale());
			preparedStatement.setString(5, Product.getProductVendor());
			preparedStatement.setString(6, Product.getQuantityinStock());
			preparedStatement.setString(7, Product.getBuyPrice());
			preparedStatement.setString(8, Product.getMSRP());
			
			preparedStatement.executeUpdate();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return Product;
	}
	
	//Edit Data
	public products editProduct(products Product){
		querySQL = "update products set productName = ?,productLine = ?,productScale = ?,productVendor = ?,quantityInStock = ?,buyPrice = ?,MSRP =?  where productCode= ? ;"; 
		
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(querySQL);
			
			preparedStatement.setString(1, Product.getProductName());
			preparedStatement.setString(2, Product.getProductLine());
			preparedStatement.setString(3, Product.getProductScale());
			preparedStatement.setString(4, Product.getProductVendor());
			preparedStatement.setString(5, Product.getQuantityinStock());
			preparedStatement.setString(6, Product.getBuyPrice());
			preparedStatement.setString(7, Product.getMSRP());
			preparedStatement.setString(8, Product.getProductCode());
			
			preparedStatement.executeUpdate();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return Product;
	}
}

