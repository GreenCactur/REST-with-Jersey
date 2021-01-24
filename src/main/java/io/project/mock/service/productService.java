package io.project.mock.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.project.mock.model.products;
import io.project.mock.repository.productRepository;




@Path("products")
public class productService {

	//make object product
	productRepository ProductRepository = new productRepository();
	
	//get all data
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<products>listProducts(){
		return ProductRepository.getAllProducts();
	}
	
	//Get data by ID
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public products getProductbyID(@PathParam("id") String id) {
		return ProductRepository.getProductbyid(id);
	}
	
	//Delete Product Data
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public String deleProducts(@PathParam("id") String id) {
		return ProductRepository.deleteData(id);
	}
	
	// Add Data
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public products addProduct(products Products){
		return ProductRepository.addProduct(Products);
	}
	
	// Edit Prodcts Data
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public products editProduct(products Products){
		return ProductRepository.editProduct(Products);
	}
}

	
