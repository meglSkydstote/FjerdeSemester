package dk.howard.resource;

import dk.howard.domain.Name;
import dk.howard.resource.dto.CreateEmployeeDTO;
import dk.howard.service.EmployeeService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/")
public class EmployeeResource {
    private final EmployeeService service;
    private final Mapper mapper;

    @Inject
    public EmployeeResource(EmployeeService service, Mapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/employees")
    @POST
    public void createProject(CreateEmployeeDTO createEmployeeDTO) {

        service.createEmployee(new Name(createEmployeeDTO.getName()));
    }


}
