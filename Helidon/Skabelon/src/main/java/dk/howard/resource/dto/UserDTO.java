package dk.howard.resource.dto;

public class UserDTO {
    private final String id;
    private final String name;

    public UserDTO(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
