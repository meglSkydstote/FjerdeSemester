package dk.howard.service.request;

import dk.howard.domain.Id;
import dk.howard.domain.Name;

public class CreateItemRequest {
    private final Id cartId;
    private final Name name;
    private final double price;

    public CreateItemRequest(Id cartId, Name name, double price) {
        this.cartId = cartId;
        this.name = name;
        this.price = price;
    }

    public Name getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Id getCartId() {
        return cartId;
    }
}
