package dk.usedmarket.resource;

import dk.usedmarket.resource.dto.AdvertisementDTO;
import dk.usedmarket.resource.dto.CategoryDTO;
import dk.usedmarket.resource.dto.CreateUserDTO;
import dk.usedmarket.resource.dto.UserDTO;
import dk.usedmarket.service.Service;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.UUID;

@Path("/users")
public class UserResource {
    private final Service service;
    private final Mapper mapper;

    @Inject
    public UserResource(Service service, Mapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    // CHECK
    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createUser(CreateUserDTO userDTO) {
        service.createUser(mapper.map(userDTO));
    }


    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserDTO getUserById(@PathParam("id") UUID id) {
        return mapper.mapUser(service.getUserById(id));
    }


}