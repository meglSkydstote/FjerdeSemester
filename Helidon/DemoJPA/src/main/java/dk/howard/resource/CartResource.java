package dk.howard.resource;

import dk.howard.resource.dto.CartDTO;
import dk.howard.resource.dto.CreateCartDTO;
import dk.howard.resource.dto.CreateItemDTO;
import dk.howard.resource.dto.ItemDTO;
import dk.howard.service.CartService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/")
public class CartResource {
    private final CartService service;
    private final CartMapper mapper;

    @Inject
    public CartResource(CartService service, CartMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/carts")
    @POST
    public CartDTO createCart(CreateCartDTO createCartDTO) {
        return mapper.map(service.createCart(mapper.map(createCartDTO)));
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/carts/{id}/item")
    @POST
    public CartDTO createItem(@PathParam("id") String cartId, CreateItemDTO createItemDTO) {
        return mapper.map(service.createItem(mapper.map(cartId,createItemDTO)));
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/carts")
    @GET
    public List<CartDTO> get() {
        return mapper.map(service.getCarts());
    }
}
