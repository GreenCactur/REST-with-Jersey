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

import io.project.mock.model.office;
import io.project.mock.repository.officeRepository;

@Path("office")
public class officeService {

	officeRepository OfficeRepo = new officeRepository();
	
	@GET
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public List<office> getAllOffice(){
		return OfficeRepo.getOffice();
	}
	
	@POST
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public office addOffice(office Office){
		return OfficeRepo.addOffice(Office);
	}
	
	@GET
	@Path("{id}")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public office getOfficebyID(@PathParam("id")int id){
		return OfficeRepo.getDatabyID(id);
	}
	
	@PUT
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public office editData(office Office){
		return OfficeRepo.editData(Office);
	}
	
	@DELETE
	@Path("{id}")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public String deleteData(@PathParam("id")int id){
		return OfficeRepo.dropData(id);
	}
	
}
