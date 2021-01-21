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

import io.project.mock.model.employee;
import io.project.mock.repository.employeeRepository;

@Path("employees")
public class employeesService {

	employeeRepository EmployeeRepository = new employeeRepository();
	
	
	//show all data 
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<employee> getEmployee(){
		
		return EmployeeRepository.getEmployees();
	}
	
	//show all data with id
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public employee getEmployee(@PathParam("id") int id){
		
		return EmployeeRepository.getEmployee(id);
	}
	
	//add new Data
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public employee addEmployee(employee Employee){
		
		return EmployeeRepository.addEmployee(Employee);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public employee editEmployee(employee Employee){
		
		return EmployeeRepository.editEmployee(Employee);
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public String deleteEmployee(@PathParam("id")int id){
		
		return EmployeeRepository.deleteEmployee(id);
	}
	
	
}
