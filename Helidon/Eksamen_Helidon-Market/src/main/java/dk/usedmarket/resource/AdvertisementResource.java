package dk.usedmarket.resource;

import dk.usedmarket.domain.AdvertisementWithLocation;
import dk.usedmarket.resource.dto.AdvertisementDTO;
import dk.usedmarket.resource.dto.AdvertisementWithLocationDTO;
import dk.usedmarket.resource.dto.CategoryDTO;
import dk.usedmarket.resource.dto.CreateAdvertisementDTO;
import dk.usedmarket.service.Service;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.UUID;

@Path("/advertisements")
public class AdvertisementResource {
    private final Service service;
    private final Mapper mapper;

    @Inject
    public AdvertisementResource(Service service, Mapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    // CHECK
    @POST
    @Path("/{userId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createAdvertisement(@PathParam("userId") UUID id, CreateAdvertisementDTO createAdvertisementDTO) {
        service.createAdvertisement(mapper.map(id, createAdvertisementDTO));
    }

    // CHECK
    @GET
    @Path("/") // ?category={id}
    @Produces(MediaType.APPLICATION_JSON)
    public List<AdvertisementDTO> findAllByCategory(@QueryParam("category") int id) {
        return mapper.mapAdvertisements(service.getAdvertisementsByCategory(id));
    }

    // CHECK
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public AdvertisementDTO findById(@PathParam("id") UUID id) {
        return mapper.map(service.getAdvertisement(id));
    }

    // CHECK
    @GET
    @Path("/user/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<AdvertisementDTO> getAdvertisementsById(@PathParam("id") UUID id) {
        return mapper.mapAdvertisements(service.getAdvertisementsById(id));
    }

    @GET
    @Path("/fungere ikke - skulle nok have lavet med noget join") // ?category={id}
    @Produces(MediaType.APPLICATION_JSON)
    public List<AdvertisementWithLocationDTO> findAllByCategoryWithLocation(@QueryParam("category") int id) {
        return mapper.mapAdvertisementsWithLocation(service.getAdvertisementsByCategoryWithLocation(id));
    }
}
