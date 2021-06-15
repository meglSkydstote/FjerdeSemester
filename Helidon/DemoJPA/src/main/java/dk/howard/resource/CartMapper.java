package dk.howard.resource;

import dk.howard.domain.Cart;
import dk.howard.domain.Id;
import dk.howard.domain.Item;
import dk.howard.domain.Name;
import dk.howard.resource.dto.CartDTO;
import dk.howard.resource.dto.CreateCartDTO;
import dk.howard.resource.dto.CreateItemDTO;
import dk.howard.resource.dto.ItemDTO;
import dk.howard.service.request.CreateCartRequest;
import dk.howard.service.request.CreateItemRequest;

import javax.enterprise.context.Dependent;
import java.util.List;
import java.util.stream.Collectors;

@Dependent
public class CartMapper {

    Id mapId(String id) {
        return new Id(id);
    }

    Name mapName(String id) {
        return new Name(id);
    }


    CreateCartRequest map(CreateCartDTO createCartDTO) {
        return new CreateCartRequest(mapName(createCartDTO.getName()));

    }
    CreateItemRequest map(String cartId,CreateItemDTO createItemDTO) {
        return new CreateItemRequest(mapId(cartId), mapName(createItemDTO.getName()),createItemDTO.getPrice());

    }

    CartDTO map(Cart cart) {
        return new CartDTO(cart.getId().toString(), cart.getName().getName(), mapItems(cart.getItems()));
    }


    List<CartDTO> map(List<Cart> carts) {
        return carts.stream().map(this::map).collect(Collectors.toList());
    }

    ItemDTO map(Item item) {
        return new ItemDTO(item.getId().toString(), item.getName().getName(), item.getPrice());
    }

    List<ItemDTO> mapItems(List<Item> items) {
        return items.stream().map(this::map).collect(Collectors.toList());
    }
}
