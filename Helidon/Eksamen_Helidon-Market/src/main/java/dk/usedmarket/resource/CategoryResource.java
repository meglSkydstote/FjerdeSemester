package dk.usedmarket.resource;

import dk.usedmarket.resource.dto.CategoryDTO;
import dk.usedmarket.service.Service;
import dk.usedmarket.resource.dto.CategoryWithCountDTO;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/categories")
public class CategoryResource {
    private final Service service;
    private final Mapper mapper;

    @Inject
    public CategoryResource(Service service, Mapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    // CHECK
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CategoryDTO> getAll() {
        return mapper.mapCategories(service.getCategories());
    }

    // CHECK
    @GET
    @Path("/count")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CategoryWithCountDTO> getCount() {
        return mapper.mapCategoriesWithCount(service.getCategories());
    }
}


