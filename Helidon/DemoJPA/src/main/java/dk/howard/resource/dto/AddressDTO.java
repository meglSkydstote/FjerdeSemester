package dk.howard.resource.dto;

public class AddressDTO {
    private final String street;
    private final String city;

    public AddressDTO(String street, String city) {
        this.street = street;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }
}
