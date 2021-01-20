/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.mock.service;


import io.project.mock.model.customers;
import io.project.mock.repository.customersRepository;
import java.sql.SQLException;
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

/**
 *
 * @author naaff
 */
@Path("/")
public class customersService {
    
    customersRepository br = new customersRepository();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<customers> getBook() throws SQLException{
//        return Bookrepo.getBook();
        return br.getBooks();
    }
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public customers getCustomers(@PathParam("id") int id) throws Exception{
        System.out.print("get customer by id run ! ");
        return br.getCustomer(id);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addData(customers cs) throws Exception{
        br.addData(cs);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public customers editCustomers(customers cs){
        br.editData(cs);
        return cs;
    }
    
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public String deleteData(@PathParam("id") int id){
        return br.dropData(id);
    }
}   
