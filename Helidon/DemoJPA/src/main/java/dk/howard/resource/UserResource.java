package dk.howard.resource;

import dk.howard.resource.dto.CreateUserDTO;
import dk.howard.resource.dto.MessageDTO;
import dk.howard.resource.dto.UserDTO;
import dk.howard.service.Service;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collections;
import java.util.List;

@Path("/")
public class UserResource {
    private final Service service;// for hver request er denne ny
    private final Mapper mapper;

    @Inject
    public UserResource(Service service, Mapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/users")
    @POST
    public void createUser(CreateUserDTO userDTO) {
        service.createUser(mapper.map(userDTO));
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/users")
    @GET
    public List<UserDTO> find(@QueryParam("name") String name) {
        if (name != null) {
            return Collections.singletonList(mapper.map(service.findByName(mapper.mapName(name))));
        } else {
            return mapper.map(service.findAll());
        }
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/users/{id}/message")
    @POST
    public void sendMessage(@PathParam("id") String userId, MessageDTO messageDTO) {
        service.sendMessage(mapper.mapId(userId), mapper.map(messageDTO));
    }


}
