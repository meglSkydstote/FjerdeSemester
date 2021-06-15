package dk.howard.resource;

import dk.howard.domain.Id;
import dk.howard.resource.dto.AddEmployeeDTO;
import dk.howard.resource.dto.CreateProjectDTO;
import dk.howard.resource.dto.ProjectDTO;
import dk.howard.service.ProjectService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/")
public class ProjectResource {
    private final ProjectService service;
    private final Mapper mapper;

    @Inject
    public ProjectResource(ProjectService service, Mapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/projects")
    @POST
    public void createProject(CreateProjectDTO projectDTO){

            service.createProject(projectDTO.getTitle());

    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/projects")
    @GET
    public List<ProjectDTO> getAll() {

        return mapper.mapProjects(service.getAllProjects());

    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/projects/{id}/add-employee")
    @PATCH
    public void addEmployee(@PathParam("id") String id, AddEmployeeDTO addEmployeeDTO) {
        service.addEmployee(new Id(id), new Id(addEmployeeDTO.getId()));
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/projects/{id}/remove-employee")
    @PATCH
    public void removeEmployee(@PathParam("id") String id, AddEmployeeDTO addEmployeeDTO) {
        service.removeEmployee(new Id(id), new Id(addEmployeeDTO.getId()));
    }

}
