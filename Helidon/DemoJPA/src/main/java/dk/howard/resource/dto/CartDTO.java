package dk.howard.resource.dto;

import java.util.List;

public class CartDTO {
    private final String id;
    private final String name;
    private final List<ItemDTO> items;

    public CartDTO(String id, String name, List<ItemDTO> items) {
        this.id = id;
        this.name = name;
        this.items = items;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<ItemDTO> getItems() {
        return items;
    }
}
