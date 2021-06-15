package dk.howard.resource.dto;

public class EmployeeDTO {
    private final String name;

    public EmployeeDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
