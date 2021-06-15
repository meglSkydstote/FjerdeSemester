package dk.Jonathan.resource;


import dk.Jonathan.domain.Advertisement;
import dk.Jonathan.domain.User;
import dk.Jonathan.resource.DTO.createUserDTO;
import dk.Jonathan.service.Service;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/")
public class AnnonceResource {

    private Mapper mapper;
    private Service service;

    @Inject
    public AnnonceResource(Service service,Mapper mapper ) {
        this.mapper = mapper;
        this.service = service;
    }

    //Users
    @Path("/users")
    @POST
    public void createUsers(createUserDTO userDTO){
        service.createUser(mapper.map(userDTO), userDTO.getZipCode());
    }

    //Advertisements
    /*@Path("/advertisements")
    @GET
    public List<AdvertisementsDTO> getAdvertisements(){
        return null;
    }*/


   /* @Path("/advertisements/{id}")
    @GET
    public AdvertisementDTO getAdvertisement(@PathParam("id") String id){
        return null;
    }*/

    /*@Path("/advertisements/{id}")
    @POST
    public AdvertisementPO getAdvertiesementToUserId(@PathParam("id") String id){
        return null;
    }*/

   /* @Path("/categories")
    @GET
    public CategoryDTO getCategories(){
        return null;
    }*/

    /*@Path("categories/count")
    @GET
    public CategoryDTO getCategoriesAndCount(){
        return null;
    }*/
}

