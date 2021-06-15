package dk.howard.resource.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateUserDTO {
    private final String name;

    @JsonCreator
    public CreateUserDTO(@JsonProperty("name") String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

}
