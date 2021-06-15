package dk.howard.resource.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateUserDTO {
    private final String name;
    private final String email;
    private final String street;
    private final String city;

    @JsonCreator
    public CreateUserDTO(
            @JsonProperty("name") String name,
            @JsonProperty("email") String email,
            @JsonProperty("street") String street,
            @JsonProperty("city") String city) {
        this.name = name;
        this.email = email;
        this.street = street;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }
}
