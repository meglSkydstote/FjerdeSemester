package dk.howard.domain;

import java.util.UUID;

public class Item {
    private final Id id;
    private final Name name;
    private final double price;

    public Item(Id id, Name name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Id getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
