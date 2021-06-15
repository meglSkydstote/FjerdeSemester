package dk.howard.domain;

import java.util.List;
import java.util.UUID;

public class Cart {
    private final Id id;
    private final Name name;
    private final List<Item> items;

    public Cart(Id id, Name name, List<Item> items) {
        this.id = id;
        this.name = name;
        this.items = items;
    }

    public Id getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public List<Item> getItems() {
        return items;
    }
}
