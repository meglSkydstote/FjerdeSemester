package dk.howard.resource.dto;

public class UserDTO {
    private final String id;
    private final String name;
    private final String email;
    private final AddressDTO addressDTO;


    public UserDTO(String id, String name, String email, AddressDTO addressDTO) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.addressDTO = addressDTO;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public AddressDTO getAddressDTO() {
        return addressDTO;
    }
}
