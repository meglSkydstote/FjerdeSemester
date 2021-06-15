package dk.howard.resource.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateItemDTO {
    private final String name;
    private final double price;

    @JsonCreator
    public CreateItemDTO(@JsonProperty("name") String name, @JsonProperty("price") double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
